package EmployeeBook;

import java.util.Objects;

public class Employee {
    private String name;
    private int division;
    private double salary;
    private int id;
    private static int counter = 0;

    public Employee (String name, int division, double salary) {
        this.name = name;
        this.division = division;
        this.salary = salary;
        counter++;
        id = counter;
    }

    public String getName() {
        return name;
    }

    public int getDivision() {
        return division;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return String.format("%s. Номер отдела: %d; Зарпалата: %.2f; ID: %d", name, division, salary, id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return division == employee.division && Double.compare(employee.salary, salary) == 0 && id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, division, salary, id);
    }
}