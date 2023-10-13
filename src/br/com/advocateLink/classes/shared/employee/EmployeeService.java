package br.com.advocateLink.classes.shared.employee;

import br.com.advocateLink.classes.exceptions.NegativeNumberException;
import br.com.advocateLink.classes.exceptions.UserNotFound;
import br.com.advocateLink.classes.interfaces.IService;
import br.com.advocateLink.classes.models.Employee;
import br.com.advocateLink.classes.shared.MethodsUtil;
import br.com.advocateLink.classes.shared.connections.database.commands.CommandsEmployee;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** this class gives function to the ObjectMethods interface, processing the CRUD
 * @author Guilherme vinicius
 * @version 1.0
 */
public  class EmployeeService implements IService<Employee> {
    public static List<Employee> list = new ArrayList<>();
    private CommandsEmployee commandsEmployee = new CommandsEmployee();
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
     * @return
     * @throws NullPointerException
     */
    @Override
    public Employee search(Long id){
        try {
           return commandsEmployee.searchRow(id);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Sem conexao");
            return null;
        }catch (UserNotFound ex){
            JOptionPane.showMessageDialog(null,"Usuario nao encontrado");
            return null;
        }
    }
    /**
     * delete an employee passed by the parameter.
     * @param tempEmployee
     * @return
     * @throws NullPointerException
     */
    @Override
    public Boolean delete(Employee tempEmployee)  {
        try{
            commandsEmployee.deleteRow(tempEmployee);
            return true;
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Sem conexao");
            return false;
        }
    }
    /**
     * CHANGES EMPLOYEE INFORMATION.
     * @return
     */
    @Override
    public Boolean alter(Long id, Employee temp) {
        try {
            commandsEmployee.updateRow(id,temp);
            return true;
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Sem conexao");
            return false;
        } catch (UserNotFound e) {
            JOptionPane.showMessageDialog(null,"Usuario nao encontrado");
            return false;
        }
    }

    /**
     * Registers the employee in the employeelList.
     * @param employee
     * @return
     */
    @Override
    public Boolean register(Employee employee) {
        try{
            commandsEmployee.insertRow(employee);
            return true;
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"sem conexao");
            return false;
        }
    }
    @Override
    public List<Employee> show() {
        return list;
    }

}
