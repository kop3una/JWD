package by.training.project.dao;

import by.training.project.dao.exception.DaoException;

public interface Transaction {
    <T extends Dao<?>> T createDao(T dao);

    void commit() throws DaoException;

    void rollback() throws DaoException;
}
