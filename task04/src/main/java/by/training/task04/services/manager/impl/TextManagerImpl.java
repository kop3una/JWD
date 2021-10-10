package by.training.task04.services.manager.impl;

import by.training.task04.beans.Text;
import by.training.task04.dao.DaoFactory;
import by.training.task04.dao.TextDao;
import by.training.task04.dao.exception.DaoException;
import by.training.task04.services.exception.ServicesException;
import by.training.task04.services.manager.TextManager;

public class TextManagerImpl implements TextManager {
    @Override
    public void writeInFile(Text text, String fileName) throws ServicesException {
        TextDao textDao = DaoFactory.getInstance().getTextDao();
        try {
            textDao.writeInFile(text,fileName);
        } catch (DaoException e){
            throw new ServicesException(e);
        }

    }
}
