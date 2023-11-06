package br.com.advocateLink.service;

import br.com.advocateLink.classes.exceptions.NegativeNumberException;
import br.com.advocateLink.classes.exceptions.UserNotFound;
import br.com.advocateLink.classes.exceptions.handler.ErrorHandler;
import br.com.advocateLink.classes.interfaces.IService;
import br.com.advocateLink.classes.models.Employee;
import br.com.advocateLink.classes.shared.MethodsUtil;
import br.com.advocateLink.connections.database.commands.CommandsEmployee;

import java.sql.SQLException;
import java.util.List;

/**
 * this class gives function to the ObjectMethods interface, processing the CRUD
 *
 * @author Guilherme vinicius
 * @version 1.0
 */
public class EmployeeService implements IService<Employee> {
    private ErrorHandler errorHandler = new ErrorHandler();
    private CommandsEmployee commandsEmployee = new CommandsEmployee();

    /**
     * sends bonuses to an employee.
     *
     * @param tempEmployee
     * @param bonus
     * @throws NegativeNumberException
     */
    public void sendBonus(Employee tempEmployee, Double bonus) {
        try {
            if (bonus < 0) {
                throw new NegativeNumberException("Numero negativo");
            }
            MethodsUtil.validatesNumber(bonus);
            tempEmployee.setSalary(tempEmployee.getSalary() * bonus);
        } catch (NegativeNumberException ex) {
            errorHandler.negativeNumberHandler(ex);
            throw new RuntimeException();
        }

    }

    /**
     * Grab a reference.
     *
     * @return
     * @throws NullPointerException
     */
    @Override
    public Employee search(Long id) {
        try {
            Employee e = commandsEmployee.searchRow(id);
            if (e.getSalary() == 0) {
                throw new UserNotFound("Cliente nao encontrado");
            }
            return e;
        } catch (UserNotFound ex) {
            errorHandler.userNotFoundHandler(new UserNotFound("usuario incorreto"));
            throw new RuntimeException();
        } catch (SQLException ex) {
            errorHandler.sqlHandler(new SQLException("Falha na conexao: " + ex.getMessage()));
            throw new RuntimeException();
        }
    }

    /**
     * delete an employee passed by the parameter.
     *
     * @param tempEmployee
     * @return
     * @throws NullPointerException
     */
    @Override
    public Boolean delete(Employee tempEmployee) {
        try {
            commandsEmployee.deleteRow(tempEmployee);
        } catch (SQLException | UserNotFound ex) {
            errorHandler.sqlHandler(new SQLException("Falha na conexao: " + ex.getMessage()));
            throw new RuntimeException();
        }
        return true;
    }

    /**
     * CHANGES EMPLOYEE INFORMATION.
     *
     * @return
     */
    @Override
    public Boolean alter(Long id, Employee temp) {
        try {
            commandsEmployee.updateRow(id, temp);
            System.out.println(temp.getSalary());
        } catch (UserNotFound ex) {
            errorHandler.userNotFoundHandler(new UserNotFound("usuario incorreto"));
            throw new RuntimeException();
        } catch (SQLException ex) {
            errorHandler.sqlHandler(new SQLException("Falha na conexao: " + ex.getMessage()));
            throw new RuntimeException();
        }
        return true;
    }

    /**
     * Registers the employee in the employeelList.
     *
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
