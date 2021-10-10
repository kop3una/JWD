package by.training.project.service.reader;

import by.training.project.beans.User;
import by.training.project.service.exception.ServiceException;

import java.util.List;

public interface UserReader extends Reader<User>{
    @Override
    User read(Integer identity) throws ServiceException;

    @Override
    List<User> readAll() throws ServiceException;

    User readByEmail(String email) throws ServiceException;
}
