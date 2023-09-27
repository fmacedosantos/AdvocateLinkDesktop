package br.com.advocateLink.classes.shared.employee;

import br.com.advocateLink.classes.exceptions.NegativeNumberException;
import br.com.advocateLink.classes.interfaces.ObjectMethods;
import br.com.advocateLink.classes.models.Employee;
import br.com.advocateLink.classes.shared.MethodsUtil;
import br.com.advocateLink.classes.shared.connections.database.ConnectionMysqlUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/** this class gives function to the ObjectMethods interface, processing the CRUD
 * @author Guilherme vinicius
 * @version 1.0
 */
public  class EmployeeService implements ObjectMethods<Employee> {
    public static List<Employee> employeeslList = new ArrayList<>();
    public static EmployeeService employee = new EmployeeService();
    private ConnectionMysqlUtil connectionMysql= new ConnectionMysqlUtil();

    /**
     * sends bonuses to an employee.
     * @param tempEmployee
     * @param bonus
     * @throws NegativeNumberException
     */
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

    /**
     * Grab a reference.
     * @param tempEmployee
     * @return
     * @throws NullPointerException
     */
    @Override
    public Employee search(String tempEmployee) throws NullPointerException {
        for (Employee employee:employeeslList) {
            if (employee.getNome().equals(tempEmployee)){
                return employee;
            }
        }
        throw new NullPointerException();
    }

    /**
     * delete an employee passed by the parameter.
     * @param tempEmployee
     * @return
     * @throws NullPointerException
     */
    @Override
    public Employee delete(Employee tempEmployee)throws NullPointerException {
            employeeslList.remove(employeeslList.indexOf(tempEmployee));
            return tempEmployee;
    }

    /**
     * CHANGES EMPLOYEE INFORMATION.
     * @param tempEmployee
     * @param urlfoto
     * @param role
     * @param salario
     * @param email
     * @param tel
     * @return
     */
    @Override
    public Employee alter(Employee tempEmployee, String urlfoto, String role, double salario, String email, long tel) {
        for (Employee employee:employeeslList){
            if (employee.getNome().equals(tempEmployee.getNome())){
                employee.getContato().setEmail(email);
                employee.getContato().setTelefone(tel);
                employee.setSalary(salario);
                employee.setRole(role);
                employee.setUrlfoto(urlfoto);
                return employee;
            }
        }
        return null;
    }

    /**
     * Registers the employee in the employeelList.
     * @param employee
     * @return
     */
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
