package EmployeeBook;
import java.util.Arrays;
public class TermPaper {
    private static Employee[] employees;

    public static void main(String[] args) {
        employees = new Employee[10];
        employees[0] = new Employee("Ким Нам Джун", 1, 15358.54);
        employees[1] = new Employee("Ким Сок Джин", 2, 15384.55);
        employees[2] = new Employee("Мин Юнги", 1, 12365.89);
        employees[3] = new Employee("Чон Хо Сок", 3, 17038.27);
        employees[4] = new Employee("Пак Чи Мин", 3, 20880.00);
        employees[5] = new Employee("Ким Тэ Хён", 5, 30657.25);
        employees[6] = new Employee("Чон Чонгук", 5, 30877.99);
        employees[7] = new Employee("Ли Тэ Мин", 2, 20222.54);
        employees[8] = new Employee("Сон Хёну", 4, 20333.44);
        employees[9] = new Employee("Ли Мин Хёк", 4, 20078.55);
        printEmployees();
        System.out.println("Сумма зарплат всех сотрудников составляет: " + countAllSalaries(employees));
        System.out.println("Сотрудник с наименьшей зарплатой: " + findMinSalary(employees));
        System.out.println("Сотрудник с наибольшей зарплатой: " + findMaxSalary(employees));
        System.out.println("Средняя зарплата сотрудников: " + countAverageSalary(employees));
        printNames();
        System.out.println("______________________________________________________________");


        indexationSalary(15, employees);
        printEmployees();
        int divisionRequired = 3;
        double divPercentage = 25;
        System.out.println("Сотрудник с минимальной зарплатой в отделе: " + divisionRequired + ": " + findMinSalary(filterByDivision(divisionRequired)));
        System.out.println("Сотрудник с мксимальной зарплатой в отделе: " + divisionRequired + ": " + findMaxSalary(filterByDivision(divisionRequired)));
        System.out.println("Сумма зарплат в отделе: " + divisionRequired + ": " + countAllSalaries(filterByDivision(divisionRequired)));
        System.out.println("Средняя зарплата по отделу: " + divisionRequired + ": " + countAverageSalary(filterByDivision(divisionRequired)));
        indexationSalaryInDivision(divisionRequired, 25);
        System.out.println("Проиндексированная зарплата сотрудников по отделу " + divisionRequired + ": ");
        printEmployees(divisionRequired);
        double salary = 20000;
        System.out.println("Сотрудник с зарплатой ниже чем " + salary);
        printSalaryLessThan(salary);
        System.out.println("Сотрудник с зарплатой выше чем " + salary);
        printSalaryMoreThan(salary);
    }

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





