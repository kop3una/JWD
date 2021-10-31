package by.training.project.dao;

import by.training.project.beans.Entity;
import by.training.project.dao.exception.DaoException;

import java.sql.Connection;
import java.util.List;

public interface Dao <Type extends Entity> {
    Integer create (Type entity) throws DaoException;

    Type read (Integer ... identity) throws DaoException;

    boolean update (Type entity) throws DaoException;

    boolean delete (Integer ... identity) throws DaoException;

    List<Type> read() throws DaoException;

    void setConnection(Connection connection);
}
