package br.com.advocateLink.classes.interfaces;

import br.com.advocateLink.classes.exceptions.UserNotFound;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IDatabase<T> {
    Boolean deleteRow(T t) throws SQLException;
    T searchRow(T t) throws SQLException, UserNotFound;
    Boolean updateRow(T t);
    Boolean insertRow(T t) throws SQLException;
}
