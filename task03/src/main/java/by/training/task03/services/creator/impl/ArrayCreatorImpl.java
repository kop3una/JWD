package by.training.task03.services.creator.impl;

import by.training.task03.beans.Array;
import by.training.task03.beans.exception.ArrayException;
import by.training.task03.dao.ArrayDao;
import by.training.task03.dao.exception.DaoException;
import by.training.task03.dao.impl.FileArrayDao;
import by.training.task03.services.creator.ArrayCreator;
import by.training.task03.services.exception.ServicesException;

public class ArrayCreatorImpl implements ArrayCreator {
    public void fillRandomized(Array array, int minValue, int maxValue) {
        for (int i = 0; i < array.length(); i++) {
            array.setValue(((int) ((Math.random() * (maxValue - minValue)) + minValue)), i);
        }
    }

    @Override
    public Array createFromFile(String fileName) throws ServicesException {
        ArrayDao arrayDao = new FileArrayDao();
        try {
            return new Array(arrayDao.readArray(fileName));
        } catch (DaoException | ArrayException e) {
            throw new ServicesException(e);
        }
    }

}
