package by.training.project.service.creator.writer;

import by.training.project.beans.Booking;
import by.training.project.dao.Transaction;
import by.training.project.service.exception.ServiceException;

public interface BookingWriter {
    boolean booking (Booking booking, Transaction transaction) throws ServiceException;
    boolean update (Booking booking, Transaction transaction) throws ServiceException;
    boolean delete (Booking booking, Transaction transaction) throws  ServiceException;
}
