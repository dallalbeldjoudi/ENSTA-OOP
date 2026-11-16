public class Main {
    public static void main(String[] args) {
        CourseManagementSystem cms = new CourseManagementSystem();

        // 1. Create Courses & Students
        Course oop = new Course("CS201", "Object-Oriented Programming", 2);
        Course algo = new Course("CS202", "Algorithms & Data Structures", 3);
        cms.addCourse(oop);
        cms.addCourse(algo);

        Student s1 = new Student("S101", "Alice");
        Student s2 = new Student("S102", "Bob");
        Student s3 = new Student("S103", "Charlie");
        cms.addStudent(s1);
        cms.addStudent(s2);
        cms.addStudent(s3);

        // 2. Perform Enrollments & Handle Constraints
        try {
            cms.enrollStudentInCourse("S101", "CS201");
            cms.enrollStudentInCourse("S102", "CS201");
            
            // This will trigger CourseFullException and add Charlie to the waiting list
            cms.enrollStudentInCourse("S103", "CS201");
        } catch (CourseManagementException e) {
            System.err.println("Enrollment notice: " + e.getMessage());
        }

        // 3. Display Course Info & Waiting List
        System.out.println("\nCS201 Status: " + oop);
        System.out.println("CS201 Waiting List: " + oop.getWaitingList());

        // 4. Remove Student & Auto-Promote from Waiting List
        System.out.println("\nRemoving S101 (Alice) from CS201...");
        cms.removeStudentFromCourse("S101", "CS201");
        System.out.println("CS201 Status after removal: " + oop);

        // 5. System Removal & Statistics
        cms.displaySystemStatistics();
        
    }
}