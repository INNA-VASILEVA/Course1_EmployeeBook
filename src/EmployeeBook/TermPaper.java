package EmployeeBook;
import java.util.Arrays;
public class TermPaper {
    public static Employee[] employees = new Employee[10];
    public static void printEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toString());
            }
        }
    }

    public static void printEmployees (int division) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDivision() == division) {
                System.out.printf("ID: %d. %s; Зарплата: %.2f \n", employees[i].getId(),employees[i].getName(), employees[i].getSalary());
            }
        }
    }

    public static double countAllSalaries(Employee [] employees1) {
        double sum = 0;
        for (int i = 0; i < employees1.length; i++) {
            if (employees1[i] != null) {
                sum += employees1[i].getSalary();
            }
        }
        return sum;
    }

    public static Employee findMinSalary(Employee[] employees1) {
        Employee result = employees1[0];
        double minimal = Double.POSITIVE_INFINITY;
        for (int i = 0; i < employees1.length; i++) {
            if (employees1[i] != null && employees1[i].getSalary() < minimal) {
                minimal = employees1[i].getSalary();
                result = employees1[i];
            }
        }
        return result;
    }

    public static Employee findMaxSalary(Employee [] employees1) {
        Employee result = employees1[0];
        double maximum = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < employees1.length; i++) {
            if (employees1[i] != null && employees1[i].getSalary() > maximum) {
                maximum = employees1[i].getSalary();
                result = employees1[i];
            }
        }
        return result;
    }

    public static double countAverageSalary(Employee[] employees1) {
        int counterFilledElements = 0;
        for (int i = 0; i < employees1.length; i++) {
            if (employees1[i] != null) {
                counterFilledElements++;
            }
        }
        return countAllSalaries(employees1) / counterFilledElements;
    }

    public static void printNames() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getName());
            }
        }
    }

    public static void indexationSalary(double percentage, Employee[] employees1) {
        double increasedBy = 1 + percentage / 100;
        for (int i = 0; i < employees1.length; i++) {
            if (employees1[i] != null) {
                employees1[i].setSalary(employees1[i].getSalary() * increasedBy);
            }
        }
    }

    public static void indexationSalaryInDivision(int division, double percentage) {
        double increasedBy = 1 + percentage / 100;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDivision() == division) {
                employees[i].setSalary(employees[i].getSalary() * increasedBy);
            }
        }
    }

    public static Employee [] filterByDivision(int division) {
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDivision() == division) {
                counter++;
            }
        }
        Employee [] result = new Employee [counter];
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDivision() == division) {
              result[index] = employees[i];
              index ++;
            }
        }
        return result;
    }

    public static void printSalaryLessThan (double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() <= salary ) {
                System.out.printf("ID: %d. %s; Зарплата: %.2f \n", employees[i].getId(),employees[i].getName(), employees[i].getSalary());
            }
        }
    }

    public static void printSalaryMoreThan (double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= salary) {
                System.out.printf("ID: %d. %s; Зарплата: %.2f \n", employees[i].getId(), employees[i].getName(), employees[i].getSalary());
            }
        }
    }
}





