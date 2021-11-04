package by.training.project.service.creator.writer;

import by.training.project.beans.Order;
import by.training.project.dao.Transaction;
import by.training.project.service.exception.ServiceException;

public interface OrderWriter {
    boolean booking (Order order, Transaction transaction) throws ServiceException;
    boolean update (Order order, Transaction transaction) throws  ServiceException;
}
