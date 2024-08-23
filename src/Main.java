import Domain.Employee;
import Domain.EmployeeBook;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("123", "213", "123", 2, 23000);
        Employee employee2 = new Employee("123", "213", "123", 2, 23000);

        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee(employee1);
        employeeBook.addEmployee(employee2);

        System.out.println(employeeBook.getAllEmployees());
    }
}
