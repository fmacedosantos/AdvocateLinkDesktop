package br.com.advocateLink.classes.interfaces;
import br.com.advocateLink.classes.exceptions.UserNotFound;
import lombok.NonNull;

import java.sql.SQLException;

public interface IDatabase<T> {
    Boolean deleteRow(T t) throws SQLException;
    T searchRow(Long id) throws SQLException, UserNotFound;
    @NonNull
    Boolean updateRow(Long id,T t) throws UserNotFound, SQLException;
    @NonNull
    Boolean insertRow(T t) throws SQLException;
}
