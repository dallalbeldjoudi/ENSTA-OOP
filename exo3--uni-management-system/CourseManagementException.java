//custom exception class that we extended from the built in exception in java
public class CourseManagementException extends Exception {
    public CourseManagementException(String message) { //acts as a parent class for the other exceptions
        super(message); //calls the constructor of the parent class
    }
}  // we used inheritance by using extends and super

class CourseFullException extends CourseManagementException {
    public CourseFullException(String message) {  //cannot let another student get added because the class reached its full potential
        super(message);
    }
}

 class DuplicateEnrollmentException extends CourseManagementException { 
    public DuplicateEnrollmentException(String message) {
        super(message);
    }
}
//NOTE: we could only write he coursefull and duplicate enrollement withoit the coursemanagement parent class, 
//but it is faster to catch an error when we have a common parent , rather than going through each exception.