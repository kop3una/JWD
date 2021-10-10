package by.training.task06.dao;

import by.training.task06.dao.exception.DaoException;

public interface InfoDataDao {
    int[] readData(String fileName) throws DaoException;
    //boolean writeMatrix(Matrix matrix, String fileName);
}
