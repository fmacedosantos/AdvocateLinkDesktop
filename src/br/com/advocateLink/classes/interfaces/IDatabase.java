package br.com.advocateLink.classes.interfaces;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IDatabase<T> {
    Boolean deleteRow(T t) throws SQLException;
    Boolean searchRow(T t);
    Boolean updateRow(T t);
    Boolean insertRow(T t) throws SQLException;
}
