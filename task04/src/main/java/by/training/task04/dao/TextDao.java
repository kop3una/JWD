package by.training.task04.dao;

import by.training.task04.beans.Text;
import by.training.task04.dao.exception.DaoException;

public interface TextDao {
    void writeInFile (Text text, String fileName) throws DaoException;
    String [][] readFromFile (String fileName) throws DaoException;
}
