package Exceptions;

public class AddingEmployeeException extends RuntimeException {
    public AddingEmployeeException(Exception e) {
        super(e.getMessage());
    }

    public AddingEmployeeException(String message) {
        System.out.println(message);
    }
}
