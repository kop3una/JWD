package by.training.task03.services.creator.impl;

import by.training.task03.beans.Matrix;
import by.training.task03.beans.exception.MatrixExepction;
import by.training.task03.dao.MatrixDao;
import by.training.task03.dao.exception.DaoException;
import by.training.task03.dao.impl.FileMatrixDao;
import by.training.task03.services.creator.MatrixCreator;
import by.training.task03.services.exception.ServicesException;

public class MatrixCreatorImpl implements MatrixCreator {
    public void fillRandomized(Matrix matrix, int minValue, int maxValue) {
        int v = matrix.getVerticalSize();
        int h = matrix.getHorizontalSize();
        for(int i = 0; i < v; i++) {
            for(int j = 0; j < h; j++) {
                try {
                    int value = (int) ((Math.random() * (maxValue - minValue)) + minValue);
                    matrix.setElement(i, j, value);
                } catch (MatrixExepction e) {
                    // log: exception impossible
                }
            }
        }
    }

    @Override
    public Matrix createFromFile(String fileName) throws ServicesException {
        MatrixDao matrixDao = new FileMatrixDao();
        try {
            return new Matrix(matrixDao.readMatrix(fileName));
        } catch (DaoException e) {
            throw new ServicesException(e);
        }
    }
    // public int[][] createMatrix(int n, int m, int minValue, int maxValue) {/*code*/
    // public void createFromFile(Matrix matrix, File f) { /* code */ }
    // public void createFromStream(Matrix matrix, Stream stream) { /* code */ }
}
