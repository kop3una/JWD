package by.training.task06.services.creator.impl;


import by.training.task06.beans.Matrix;
import by.training.task06.dao.DaoFactory;
import by.training.task06.dao.MatrixDao;
import by.training.task06.dao.exception.DaoException;
import by.training.task06.services.creator.MatrixCreator;
import by.training.task06.services.exception.ServicesException;

public class MatrixCreatorImpl implements MatrixCreator {
    @Override
    public Matrix createFromFile(String fileName) throws ServicesException {
        MatrixDao matrixDao = DaoFactory.getInstance().getMatrixDao();
        try {
            return new Matrix(matrixDao.readMatrix(fileName));
        } catch (DaoException e) {
            throw new ServicesException(e);
        }
    }
}
