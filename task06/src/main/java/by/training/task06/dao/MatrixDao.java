package by.training.task06.dao;

import by.training.task06.beans.Matrix;
import by.training.task06.dao.exception.DaoException;

public interface MatrixDao {
    int[][] readMatrix(String fileName) throws DaoException;
    boolean writeMatrix(Matrix matrix, String fileName);
}
