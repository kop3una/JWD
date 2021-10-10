package by.training.task03.dao;

import by.training.task03.beans.Matrix;
import by.training.task03.dao.exception.DaoException;

public interface MatrixDao {
    double [][] readMatrix (String fileName) throws DaoException;
    boolean writeMatrix (Matrix matrix, String fileName);
}
