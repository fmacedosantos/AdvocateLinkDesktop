package br.com.advocateLink.classes.interfaces;

import br.com.advocateLink.classes.exceptions.UserNotFound;
import br.com.advocateLink.classes.models.Employee;

import java.sql.SQLException;
import java.util.List;

/**This Interface is a "CRUD", when implemented it will have all the necessary methods for a "CRUD" of some object.
 * @version 1.0
 * @param <T>
 * @author Guilherme vinicius
 */

public interface IService<T>{
    /** Searches for an object from a name.
     * @version 1.0
     * @author Guilherme vinicius
     * @param t
     * @return
     */
    T search(Long id) throws UserNotFound, SQLException;

    /** Delete for an object from a Object.
     * @version 1.0
     * @author Guilherme vinicius
     * @param t
     * @return
     */
    Boolean delete(T t) throws SQLException;

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
    Boolean alter(Long id, T t) throws UserNotFound, SQLException;

    /**
     * Registers an object to a list
     * @version 1.0
     * @author Guilherme vinicius
     * @param t
     * @return
     */
    Boolean register(T t) throws SQLException;
    List<T> show();
}
