package by.training.task05.services.reader.impl;

import by.training.task05.dao.DaoFactory;
import by.training.task05.dao.DataDao;
import by.training.task05.dao.exception.DaoException;
import by.training.task05.services.exception.ServicesException;
import by.training.task05.services.reader.DataReader;
import by.training.task05.services.validation.LineValidator;

import java.util.ArrayList;
import java.util.List;

public class DataReaderTestImpl implements DataReader {
    @Override
    public List<String> readFromFile(String fileName) throws ServicesException {
        DataDao dataDao = DaoFactory.getInstance().getTextTestDao();
        try {
            List <String> lineFromFile = dataDao.readFromFile(fileName);
            List <String> correctLine = new ArrayList<>();
            for (String line : lineFromFile ){
                if (LineValidator.isValid(line)){
                    correctLine.add(line);
                }
            }
            return correctLine;
        } catch (DaoException e) {
            throw new ServicesException(e);
        }
    }
}
