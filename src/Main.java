import EmployeeBook.Employee;


import static EmployeeBook.TermPaper.*;

public class Main {
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
        System.out.println("____________________________________________________________");


        indexationSalary(15, employees);
        printEmployees();
        int divisionRequired = 3;
        System.out.println("Сотрудник с минимальной зарплатой в отделе: " + divisionRequired + ": " + findMinSalary(filterByDivision(divisionRequired)));
        System.out.println("Сотрудник с максимальной зарплатой в отделе: " + divisionRequired + ": " + findMaxSalary(filterByDivision(divisionRequired)));
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
}