package br.com.advocateLink.classes.interfaces;

import br.com.advocateLink.classes.models.Employee;

import java.sql.SQLException;
import java.util.List;

/**This Interface is a "CRUD", when implemented it will have all the necessary methods for a "CRUD" of some object.
 * @version 1.0
 * @param <T>
 * @author Guilherme vinicius
 */

public interface ObjectMethods<T>{
    /** Searches for an object from a name.
     * @version 1.0
     * @author Guilherme vinicius
     * @param t
     * @return
     */
    T search(String t);

    /** Delete for an object from a Object.
     * @version 1.0
     * @author Guilherme vinicius
     * @param t
     * @return
     */
    T delete(T t);

    /**
     * Changes an object in a list
     * @version 1.0
     * @author Guilherme vinicius
     * @param tempEmployee
     * @param urlfoto
     * @param role
     * @param salario
     * @param email
     * @param tel
     * @return
     */
    // ALTERA AS INFORMACOES DO FUNCIONARIO
    Employee alter(Employee tempEmployee, String urlfoto, String role, double salario, String email, long tel) throws NullPointerException;

    /**
     * Registers an object to a list
     * @version 1.0
     * @author Guilherme vinicius
     * @param t
     * @return
     */
    T register(T t) throws SQLException;
    List<T> show();
}
