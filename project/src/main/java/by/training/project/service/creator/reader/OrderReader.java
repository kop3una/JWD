package by.training.project.service.creator.reader;

import by.training.project.beans.Order;
import by.training.project.dao.Transaction;
import by.training.project.service.exception.ServiceException;

import java.util.List;

public interface OrderReader {
    Order read(Integer identity, Transaction transaction) throws ServiceException;
    List<Order> readAllOrderByUserId(Integer userId, Transaction transaction) throws ServiceException;
    List<Order> readOrderByUserId(Integer userId, Integer page, Integer countPage, Transaction transaction) throws ServiceException;
}
