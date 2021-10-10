package by.training.task05.dao;

import by.training.task05.dao.exception.DaoException;

import java.util.List;

public interface DataDao {
    List <String> readFromFile (String fileName) throws DaoException;
}
