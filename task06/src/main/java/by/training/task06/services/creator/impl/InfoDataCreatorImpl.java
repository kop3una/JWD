package by.training.task06.services.creator.impl;

import by.training.task06.beans.InfoData;
import by.training.task06.dao.DaoFactory;
import by.training.task06.dao.InfoDataDao;
import by.training.task06.dao.exception.DaoException;
import by.training.task06.services.creator.InfoDataCreator;
import by.training.task06.services.exception.ServicesException;

public class InfoDataCreatorImpl implements InfoDataCreator {
    @Override
    public InfoData createFromFile(String fileName) throws ServicesException {
        InfoDataDao infoDataDao = DaoFactory.getInstance().getInfoDataDao();
        try {
            int [] data = infoDataDao.readData(fileName);
            return new InfoData(data[4],data[5]);
        } catch (DaoException e) {
            throw new ServicesException(e);
        }
    }
}
