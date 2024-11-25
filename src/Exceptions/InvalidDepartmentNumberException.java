package Exceptions;

public class InvalidDepartmentNumberException extends RuntimeException {
    public InvalidDepartmentNumberException(Exception e) {
        super(e);
    }

    public InvalidDepartmentNumberException(String message) {
        super(message);
    }
}
