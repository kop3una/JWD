package by.training.task03.services.manager;

import by.training.task03.beans.Array;
import by.training.task03.dao.exception.DaoException;

public interface ArrayManager {
    void writeInFile (Array array, String fileName) throws DaoException;
}
