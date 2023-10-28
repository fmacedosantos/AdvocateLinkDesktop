package br.com.advocateLink.service;

import br.com.advocateLink.classes.exceptions.NegativeNumberException;
import br.com.advocateLink.classes.exceptions.UserNotFound;
import br.com.advocateLink.classes.interfaces.IService;
import br.com.advocateLink.classes.models.Employee;
import br.com.advocateLink.classes.shared.MethodsUtil;
import br.com.advocateLink.connections.database.commands.CommandsEmployee;

import java.sql.SQLException;
import java.util.List;

/** this class gives function to the ObjectMethods interface, processing the CRUD
 * @author Guilherme vinicius
 * @version 1.0
 */
public  class EmployeeService implements IService<Employee> {
    private CommandsEmployee commandsEmployee = new CommandsEmployee();
    /**
     * sends bonuses to an employee.
     * @param tempEmployee
     * @param bonus
     * @throws NegativeNumberException
     */
    public void sendBonus(Employee tempEmployee,Double bonus)throws NegativeNumberException {
        if (bonus<0){
            throw new NegativeNumberException("Numero negativo");
        }
        MethodsUtil.validatesNumber(bonus);
        tempEmployee.setSalary(tempEmployee.getSalary()*bonus);
    }
    /**
     * Grab a reference.
     * @return
     * @throws NullPointerException
     */
    @Override
    public Employee search(Long id) throws UserNotFound, SQLException {
        return commandsEmployee.searchRow(id);
    }
    /**
     * delete an employee passed by the parameter.
     * @param tempEmployee
     * @return
     * @throws NullPointerException
     */
    @Override
    public Boolean delete(Employee tempEmployee) throws SQLException {
        commandsEmployee.deleteRow(tempEmployee);
        return true;
    }
    /**
     * CHANGES EMPLOYEE INFORMATION.
     * @return
     */
    @Override
    public Boolean alter(Long id, Employee temp) throws UserNotFound, SQLException {
        commandsEmployee.updateRow(id,temp);
        return true;
    }
    /**
     * Registers the employee in the employeelList.
     * @param employee
     * @return
     */
    @Override
    public Boolean register(Employee employee) throws SQLException {
        commandsEmployee.insertRow(employee);
        return true;
    }
    @Override
    public List<Employee> show() {
        return null;
    }
}
