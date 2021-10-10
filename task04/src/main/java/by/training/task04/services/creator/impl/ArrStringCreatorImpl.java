package by.training.task04.services.creator.impl;

import by.training.task04.dao.DaoFactory;
import by.training.task04.dao.TextDao;
import by.training.task04.dao.exception.DaoException;
import by.training.task04.services.creator.ArrStringCreator;
import by.training.task04.services.exception.ServicesException;

public class ArrStringCreatorImpl implements ArrStringCreator {

    @Override
    public String[][] createFromFile(String fileName) throws ServicesException {
        TextDao textDao = DaoFactory.getInstance().getTextDao();
        try {
            String [][] dataFromFile = textDao.readFromFile(fileName);
            return dataFromFile;
        } catch (DaoException e){
            throw new ServicesException(e);
        }

    }
}
