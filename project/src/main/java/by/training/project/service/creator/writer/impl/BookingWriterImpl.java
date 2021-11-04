package by.training.project.service.creator.writer.impl;

import by.training.project.beans.Booking;
import by.training.project.dao.BookingDao;
import by.training.project.dao.DaoFactory;
import by.training.project.dao.Transaction;
import by.training.project.dao.exception.DaoException;
import by.training.project.service.creator.writer.BookingWriter;
import by.training.project.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookingWriterImpl implements BookingWriter {
    private final Logger logger = LogManager.getLogger(BookingWriterImpl.class);

    @Override
    public boolean booking(Booking booking, Transaction transaction) throws ServiceException {
        BookingDao bookingDao = transaction.createDao(DaoFactory.getInstance().getBookingDao());
        try {
            Integer number = bookingDao.create(booking);
            if (number != null) {
                return true;
            } else {
                return false;
            }
        } catch (DaoException e) {
            logger.error("Can't booking", e);
            throw new ServiceException("Can't booking", e);
        }
    }

    @Override
    public boolean update(Booking booking, Transaction transaction) throws ServiceException {
        BookingDao bookingDao = transaction.createDao(DaoFactory.getInstance().getBookingDao());
        try {
            return bookingDao.update(booking);
        } catch (DaoException e) {
            logger.error("Can't update", e);
            throw new ServiceException("Can't update", e);
        }
    }

    @Override
    public boolean delete(Booking booking, Transaction transaction) throws ServiceException {
        BookingDao bookingDao = transaction.createDao(DaoFactory.getInstance().getBookingDao());
        try {
            return bookingDao.delete(booking.getNumber(),booking.getHotelId());
        } catch (DaoException e) {
            logger.error("Can't delete", e);
            throw new ServiceException("Can't delete", e);
        }
    }
}
