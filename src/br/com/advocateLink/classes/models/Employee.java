package br.com.advocateLink.classes.models;

import br.com.advocateLink.classes.interfaces.UsefulEmployee;

public class Employee extends Manageable implements UsefulEmployee {
    private long idEmployee;
    private String role;
    private double salary;

    public Employee(long id, String name, String cpf, Address address, Contact contact, String photograph, long idEmployee, String role, double salary) {
        super(id, name, cpf, address, contact, photograph);
        this.idEmployee = idEmployee;
        this.role = role;
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double getBonus(double salary, double bonus) {
        return salary * bonus;
    }
}
