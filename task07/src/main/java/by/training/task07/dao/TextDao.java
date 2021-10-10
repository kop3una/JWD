package by.training.task07.dao;

import by.training.task07.dao.exception.DaoException;

public interface TextDao { // TODO Write In File
    //void writeInFile (Text text, String fileName) throws DaoException;
    String readFromFile (String fileName) throws DaoException;
}
