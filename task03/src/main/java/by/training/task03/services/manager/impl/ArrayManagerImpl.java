package by.training.task03.services.manager.impl;

import by.training.task03.beans.Array;
import by.training.task03.dao.ArrayDao;
import by.training.task03.dao.exception.DaoException;
import by.training.task03.dao.impl.FileArrayDao;
import by.training.task03.services.manager.ArrayManager;

public class ArrayManagerImpl implements ArrayManager {
    @Override
    public void writeInFile(Array array, String fileName)  {
        ArrayDao arrayDao = new FileArrayDao();
        arrayDao.writeArray(array,fileName);
    }
}
