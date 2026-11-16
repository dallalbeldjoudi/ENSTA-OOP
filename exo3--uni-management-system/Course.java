import java.util.*;

public class Course {
    private final String code;
    private String title;
    private final int capacity;
    private final Set<Student> enrolledStudents;
    private final Queue<Student> waitingList;   //queue for wating when the course is full first in first out

    public Course(String code, String title, int capacity) {
        this.code = code;
        this.title = title;
        this.capacity = capacity;
        this.enrolledStudents = new HashSet<>(); //we use hashset for setss in the constructor
        this.waitingList = new LinkedList<>(); //we use linked lists for queues in the constructpr
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCapacity() { return capacity; }

    public Set<Student> getEnrolledStudents() {
        return Collections.unmodifiableSet(enrolledStudents); //setter that uses a helper function from the class collections to make the set readonly
    }

    public Queue<Student> getWaitingList() {
        return new LinkedList<>(waitingList);
    }

    public boolean isFull() {
        return enrolledStudents.size() >= capacity;
    }

    void enrollStudent(Student student) throws CourseFullException, DuplicateEnrollmentException { //throw is used when having an errror, it skips the line after it
        if (enrolledStudents.contains(student)) {  // we use this even if we used set before to not let the error fall silently, and so that a student alr enrolled get skipped and not add them in the waiting list.
            throw new DuplicateEnrollmentException("Student " + student.getId() + " is already enrolled in " + code);
        }
        if (isFull()) {
            if (!waitingList.contains(student)) {
                waitingList.offer(student);
            }
            throw new CourseFullException("Course " + code + " is full. Student added to waiting list.");
        }
        enrolledStudents.add(student);
        student.addCourse(this);
    }

    // Priority Enrollment (Twist: bypasses standard queue placement)
    void enrollStudentWithPriority(Student student) throws DuplicateEnrollmentException {
        if (enrolledStudents.contains(student)) {
            throw new DuplicateEnrollmentException("Student " + student.getId() + " is already enrolled in " + code);
        }
        if (isFull()) {
            // Priority addition puts the student at the head of the waiting list if full
            ((LinkedList<Student>) waitingList).addFirst(student);
        } else {
            enrolledStudents.add(student);
            student.addCourse(this);
        }
    }

    boolean removeStudent(Student student) {
        boolean removed = enrolledStudents.remove(student);
        if (removed) {
            student.removeCourse(this);
            // Auto-promote next student from waiting list if space opens up
            if (!waitingList.isEmpty()) {
                Student nextStudent = waitingList.poll();
                enrolledStudents.add(nextStudent);
                nextStudent.addCourse(this);
            }
        } else {
            waitingList.remove(student);
        }
        return removed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Course course = (Course) o;
        return Objects.equals(code, course.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return String.format("Course[Code='%s', Title='%s', Enrolled=%d/%d, Waiting=%d]",
                code, title, enrolledStudents.size(), capacity, waitingList.size());
    }
}
