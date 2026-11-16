import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student implements Comparable<Student> { // built in java comparator 
    private final String id;// the final is used to asign the value and not be able to modify it after that
    private String name;
    private final Set<Course> enrolledCourses;  //set is like a list but doesnt allow duplicates, so that a student will be enrolled in the course once

    public Student(String id, String name) { //constructors
        this.id = id;
        this.name = name;
        this.enrolledCourses = new HashSet<>(); //hashset
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<Course> getEnrolledCourses() {
        return Collections.unmodifiableSet(enrolledCourses); //getter that uses unmodified in order to make it readonly and couldnt change it through the setter
    }

 
    boolean addCourse(Course course) {  //it is a private method , used only inside the class not outside. (there are no static or public keywords)
        return enrolledCourses.add(course);
    }

    boolean removeCourse(Course course) {
        return enrolledCourses.remove(course);
    }

    @Override  //overridding the compareTo method from the comparable interface, to compare the students by their names
    public int compareTo(Student o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override //overrides the built in java equals method to check if the ids are the same, by checing if they refer to the same pointer
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override  //helps with formattinge the print function, to not show a random hexadecimal pointer
    public String toString() {
        return String.format("Student[ID='%s', Name='%s', Enrolled Courses=%d]", id, name, enrolledCourses.size());
    }
}
