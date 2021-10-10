package by.training.task03.services.manager.impl;

import by.training.task03.beans.Matrix;
import by.training.task03.dao.MatrixDao;
import by.training.task03.dao.impl.FileMatrixDao;
import by.training.task03.services.manager.MatrixManager;

public class MatrixManagerImpl implements MatrixManager {
    @Override
    public void writeInFile(Matrix matrix, String dirName) {
        MatrixDao matrixDao = new FileMatrixDao();
        matrixDao.writeMatrix(matrix, dirName);
    }
}
