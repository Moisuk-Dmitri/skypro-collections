package Domain;

import Exceptions.AddingEmployeeException;
import Exceptions.EmptyMapException;

import java.util.HashMap;
import java.util.Map;

public class EmployeeBook {
    private static Map<Integer, Employee> employeeMap = new HashMap();

    public void addEmployee(Employee employee) {
        for (Employee value : employeeMap.values()) {
            if (value.getFirstName().equals(employee.getFirstName()) &&
                    value.getMiddleName().equals(employee.getMiddleName()) &&
                    value.getLastName().equals(employee.getLastName())) {
                throw new AddingEmployeeException("New employee cannot be added, check original employee's name");
            }
        }

        employeeMap.put(employee.getId(), employee);
    }


    public Employee getEmployeeById(int id) {
        return employeeMap.get(id); //ex
    }

    public void deleteEmployeeById(int id) {
        employeeMap.remove(id);
    }

    public String getAllEmployees() {
        String str = "";
        for (Employee value : employeeMap.values()) {
            str += value.toString() + "\n";
        }

        return str;
    }

    public int sumSalaries() {
        int sum = 0;
        for (Employee value : employeeMap.values()) {
            sum += value.getSalary();
        }

        return sum;
    }

    public Employee findMinSalary() {
        if (employeeMap.isEmpty()) {
            throw new EmptyMapException("Employee container is empty");
        }
        Employee employee = null;

        for (Employee value : employeeMap.values()) {
            if (employee == null) {
                employee = value;
            } else if (employee.getSalary() > value.getSalary()) {
                employee = value;
            }
        }

        return employee;
    }

    public Employee findMaxSalary() {
        if (employeeMap.isEmpty()) {
            throw new EmptyMapException("Employee container is empty");
        }
        Employee employee = null;

        for (Employee value : employeeMap.values()) {
            if (employee == null) {
                employee = value;
            } else if (employee.getSalary() < value.getSalary()) {
                employee = value;
            }
        }

        return employee;
    }

    public double getAverageSalary() {
        if (employeeMap.isEmpty()) {
            throw new EmptyMapException("Employee container is empty");
        }

        return (double) sumSalaries() / employeeMap.size();
    }

    public String getAllFullNames() {
        if (employeeMap.isEmpty()) {
            throw new EmptyMapException("Employee container is empty");
        }

        String str = "";
        for (Employee value : employeeMap.values()) {
            str += value.getFirstName() + " " + value.getMiddleName() + " " + value.getLastName() + "\n";
        }

        return str;
    }

    public static void indexSalary(int percent) {
        if (employeeMap.isEmpty()) {
            throw new EmptyMapException("Employee container is empty");
        }

        for (Employee value : employeeMap.values()) {
            value.setSalary(value.getSalary() + value.getSalary() * percent / 100);
        }
    }

    public Employee findMinSalaryByDepartment(int departmentNumber) {
        if (employeeMap.isEmpty()) {
            throw new EmptyMapException("Employee container is empty");
        }

        Employee employee = null;
        for (Employee value : employeeMap.values()) {
            if (employee == null && value.getDepartmentNumber() == departmentNumber) {
                employee = value;
            } else if (employee.getSalary() < value.getSalary() && value.getDepartmentNumber() == departmentNumber) {
                employee = value;
            }
        }

        return employee;
    }

    public Employee findMaxSalaryByDepartment(int departmentNumber) {
        if (employeeMap.isEmpty()) {
            throw new EmptyMapException("Employee container is empty");
        }

        Employee employee = null;
        for (Employee value : employeeMap.values()) {
            if (employee == null && value.getDepartmentNumber() == departmentNumber) {
                employee = value;
            } else if (employee.getSalary() > value.getSalary() && value.getDepartmentNumber() == departmentNumber) {
                employee = value;
            }
        }

        return employee;
    }

    public int sumSalariesByDepartment(int departmentNumber) {
        if (employeeMap.isEmpty()) {
            throw new EmptyMapException("Employee container is empty");
        }

        int sum = 0;
        for (Employee value : employeeMap.values()) {
            if (value.getDepartmentNumber() == departmentNumber) {
                sum += value.getSalary();
            }
        }

        return sum;
    }

    public double getAverageSalaryByDepartment(int departmentNumber) {
        if (employeeMap.isEmpty()) {
            throw new EmptyMapException("Employee container is empty");
        }

        int sum = 0;
        int employeeCounter = 0;
        for (Employee value : employeeMap.values()) {
            if (value.getDepartmentNumber() == departmentNumber) {
                sum += value.getSalary();
                employeeCounter++;
            }
        }

        return (double) sum / employeeCounter;
    }

    public void indexSalaryByDepartment(int percent, int departmentNumber) {
        if (employeeMap.isEmpty()) {
            throw new EmptyMapException("Employee container is empty");
        }

        for (Employee value : employeeMap.values()) {
            if (value.getDepartmentNumber() == departmentNumber) {
                value.setSalary(value.getSalary() + value.getSalary() * percent / 100);
            }
        }
    }

    public String getEmployeeArrayByDepartment(int departmentNumber) {
        String str = "";
        for (Employee value : employeeMap.values()) {
            if (value.getDepartmentNumber() == departmentNumber) {
                str += "Employee{" +
                        "firstName='" + value.getFirstName() + '\'' +
                        ", lastName='" + value.getLastName() + '\'' +
                        ", middleName='" + value.getMiddleName() + '\'' +
                        ", salary=" + value.getSalary() +
                        ", id =" + value.getId() +
                        "}\n";
            }
        }

        return str;
    }

    public String getEmployeesBelowSalary(int salary) {
        String str = "";
        for (Employee value : employeeMap.values()) {
            if (value.getSalary() < salary) {
                str += "Employee{" +
                        "firstName='" + value.getFirstName() + '\'' +
                        ", lastName='" + value.getLastName() + '\'' +
                        ", middleName='" + value.getMiddleName() + '\'' +
                        ", salary=" + value.getSalary() +
                        ", id =" + value.getId() +
                        "}\n";
            }
        }

        return str;
    }

    public String getEmployeesAboveSalary(int salary) {
        String str = "";
        for (Employee value : employeeMap.values()) {
            if (value.getSalary() > salary) {
                str += "Employee{" +
                        "firstName='" + value.getFirstName() + '\'' +
                        ", lastName='" + value.getLastName() + '\'' +
                        ", middleName='" + value.getMiddleName() + '\'' +
                        ", salary=" + value.getSalary() +
                        ", id =" + value.getId() +
                        "}\n";
            }
        }

        return str;
    }
}