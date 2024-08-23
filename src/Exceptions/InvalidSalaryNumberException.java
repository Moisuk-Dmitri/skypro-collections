package Exceptions;

public class InvalidSalaryNumberException extends RuntimeException {
    public InvalidSalaryNumberException(Exception e) {
        super(e);
    }

    public InvalidSalaryNumberException(String message) {
        System.out.println(message);
    }
}
