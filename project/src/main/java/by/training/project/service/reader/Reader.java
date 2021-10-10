package by.training.project.service.reader;

import by.training.project.beans.Entity;
import by.training.project.service.exception.ServiceException;

import java.util.List;

public interface Reader <Type extends Entity> {
    Type read (Integer identity) throws ServiceException;
    List<Type> readAll() throws ServiceException;
}
