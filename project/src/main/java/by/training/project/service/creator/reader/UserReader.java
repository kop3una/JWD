package by.training.project.service.creator.reader;

import by.training.project.beans.User;
import by.training.project.dao.Transaction;
import by.training.project.service.exception.ServiceException;

import java.util.List;

public interface UserReader {

    User read(Integer identity, Transaction transaction) throws ServiceException;


    List<User> readAll(Transaction transaction) throws ServiceException;

    User readByEmail(String email, Transaction transaction) throws ServiceException;
}
