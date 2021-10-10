package by.training.project.dao;

import by.training.project.beans.User;
import by.training.project.dao.exception.DaoException;

import java.util.List;

public interface UserDao extends Dao<User> {
    @Override
    int create(User user) throws DaoException;

    @Override
    User read(int identity) throws DaoException;

    User read(String email) throws DaoException;

    @Override
    boolean update(User user) throws DaoException;

    @Override
    boolean delete(int identity) throws DaoException;

    @Override
    List<User> read() throws DaoException;
}
