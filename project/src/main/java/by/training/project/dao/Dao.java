package by.training.project.dao;

import by.training.project.beans.Entity;
import by.training.project.dao.exception.DaoException;

import java.util.List;

public interface Dao <Type extends Entity> { // TODO check INTEGER
    int create (Type entity) throws DaoException;

    Type read (int identity) throws DaoException;

    boolean update (Type entity) throws DaoException;

    boolean delete (int identity) throws DaoException;

    List<Type> read() throws DaoException;
}
