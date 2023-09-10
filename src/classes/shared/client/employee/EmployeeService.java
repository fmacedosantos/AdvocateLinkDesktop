package classes.shared.client.employee;

import classes.exceptions.NegativeNumberException;
import classes.interfaces.ObjectMethods;
import classes.models.Employee;
import classes.shared.client.MethodsUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public  class EmployeeService implements ObjectMethods<Employee> {
    public static List<Employee> employeeslList = new ArrayList<>();
    public static EmployeeService employee = new EmployeeService();
    public void sendBonus(Employee tempEmployee,double bonus)throws NegativeNumberException {
        try {
            if (bonus<0){
                throw new NegativeNumberException("Numero negativo");
            }
            MethodsUtil.validatesNumber(bonus);
            tempEmployee.setSalary(tempEmployee.getSalary()*bonus);
            System.out.println(tempEmployee.getSalary()*bonus);
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, " VERIFIQUE AS INFORMACOES");
            System.err.println("Erro ao enviar a solicitação: " + ex.getMessage());
        }
    }
    //Pega Referencia
    @Override
    public Employee search(String tempEmployee) throws NullPointerException {
        for (Employee employee:employeeslList) {
            if (employee.getNome().equals(tempEmployee)){
                return employee;
            }
        }
        throw new NullPointerException();
    }
    //DELETA O FUNCIONARIO
    @Override
    public Employee delete(Employee tempEmployee)throws NullPointerException {
        for (Employee employee:employeeslList){
            if (employee.getNome().equals(tempEmployee.getNome())){
                employeeslList.remove(tempEmployee.getIdEmployee());
                return null;
            }
        }
        throw new NullPointerException();
    }
    // ALTERA AS INFORMACOES DO FUNCIONARIO
    @Override
    public Employee alter(Employee tempEmployee) throws NullPointerException {
        for (Employee employee:employeeslList){
            if (employee.getNome().equals(tempEmployee.getNome())){
                employee.setNome(tempEmployee.getNome());
                employee.setContato(tempEmployee.getContato());
                employee.setEndereco(tempEmployee.getEndereco());
                employee.setSalary(tempEmployee.getSalary());
                employee.setCpf(tempEmployee.getCpf());
                employee.setRole(tempEmployee.getRole());
                employee.setUrlfoto(tempEmployee.getUrlfoto());
                return null;
            }
        }
        throw new NullPointerException();
    }
    // Registra o funcionario no employeelList
    @Override
    public Employee register(Employee employee) {
        employeeslList.add(employee);
        return null;
    }
    @Override
    public List<Employee> show() {

        return employeeslList;
    }
}
