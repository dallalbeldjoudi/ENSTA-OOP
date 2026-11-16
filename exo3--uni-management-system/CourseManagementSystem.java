import java.util.*;
import java.util.stream.Collectors;

public class CourseManagementSystem {
    private final Map<String, Student> students = new HashMap<>(); // used it in order to search for the student and course by
    private final Map<String, Course> courses = new HashMap<>(); //constructor

  
    public boolean addStudent(Student student) {
        if (student == null || students.containsKey(student.getId())) return false;
        students.put(student.getId(), student);
        return true;
    }

    public boolean addCourse(Course course) {
        if (course == null || courses.containsKey(course.getCode())) return false;
        courses.put(course.getCode(), course);
        return true;
    }

    public void enrollStudentInCourse(String studentId, String courseCode) 
            throws CourseManagementException {
        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);

        if (student == null) throw new CourseManagementException("Student ID not found: " + studentId);
        if (course == null) throw new CourseManagementException("Course code not found: " + courseCode);

        course.enrollStudent(student);
    }

    public void enrollStudentWithPriority(String studentId, String courseCode) 
            throws CourseManagementException {
        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);

        if (student == null) throw new CourseManagementException("Student ID not found: " + studentId);
        if (course == null) throw new CourseManagementException("Course code not found: " + courseCode);

        course.enrollStudentWithPriority(student);
    }

    public boolean removeStudentFromCourse(String studentId, String courseCode) {
        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);
        if (student != null && course != null) {
            return course.removeStudent(student);
        }
        return false;
    }

    // Search Operations 
    public Student findStudentById(String id) {
        return students.get(id);
    }

    public Course findCourseByCode(String code) {
        return courses.get(code);
    }

    public Set<Student> getStudentsInCourse(String courseCode) {
        Course course = findCourseByCode(courseCode);
        return (course != null) ? course.getEnrolledStudents() : Collections.emptySet();
    }

    public Set<Course> getCoursesOfStudent(String studentId) {
        Student student = findStudentById(studentId);
        return (student != null) ? student.getEnrolledCourses() : Collections.emptySet();
    }

   
    public List<Student> getStudentsSortedByName() {
        List<Student> list = new ArrayList<>(students.values());
        Collections.sort(list); // Uses Comparable 
        return list;
    }

    public List<Course> getCoursesSortedByCapacity() {
        List<Course> list = new ArrayList<>(courses.values());
        list.sort(Comparator.comparingInt(Course::getCapacity));
        return list;
    }

    public List<Course> getCoursesSortedByEnrollmentCount() {
        List<Course> list = new ArrayList<>(courses.values());
        list.sort((c1, c2) -> Integer.compare(c2.getEnrolledStudents().size(), c1.getEnrolledStudents().size()));
        return list;
    }

    public Map<Integer, List<Student>> groupStudentsByCourseCount() {  //a map puts each key with its value for example here the key is the course count and the vslue is students
        return students.values().stream()
                .collect(Collectors.groupingBy(s -> s.getEnrolledCourses().size()));
    }

    public Optional<Course> getCourseWithHighestEnrollment() { //the optional keyword means that this can return a course or would retrn nothing
        return courses.values().stream()
                .max(Comparator.comparingInt(c -> c.getEnrolledStudents().size()));
    }

    // --- System Statistics ---
    public void displaySystemStatistics() {
        System.out.println("=== SYSTEM STATISTICS ===");
        System.out.println("Total Students : " + students.size());
        System.out.println("Total Courses  : " + courses.size());
        
        double avgEnrollment = courses.values().stream()
                .mapToInt(c -> c.getEnrolledStudents().size())
                .average()
                .orElse(0.0);

        System.out.printf("Average Enrollment per Course: %.2f\n", avgEnrollment);
        System.out.println("=========================");
    }
}
