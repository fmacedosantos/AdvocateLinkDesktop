package br.com.advocateLink.classes.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Manageable {
    private long idEmployee;
    private String role;
    private double salary;

    public Employee(long id, String name, String cpf, Address address, Contact contact, String photograph, long idEmployee, String role, double salary) {
        super(id, name, cpf, address, contact, photograph);
        this.idEmployee = idEmployee;
        this.role = role;
        this.salary = salary;
    }

    public Employee(String nome, String cpf, Address endereco, Contact contato, String urlfoto, long idEmployee, String role, double salary) {
        super(nome, cpf, endereco, contato, urlfoto);
        this.idEmployee = idEmployee;
        this.role = role;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return     urlfoto +
                "\nrole='" + role + '\'' +
                "\nsalary=" + salary +
                "\nid=" + id +
                "\nnome='" + nome + '\'' +
                "\ncpf='" + cpf + '\'' +
                "\nendereco=" + endereco +
                "\ncontato=" + contato;
    }
}
