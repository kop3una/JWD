package by.training.task03.dao;

import by.training.task03.beans.Array;
import by.training.task03.dao.exception.DaoException;


public interface ArrayDao {
    double [] readArray (String fileName) throws DaoException;
    boolean writeArray (Array array, String fileName);
}
