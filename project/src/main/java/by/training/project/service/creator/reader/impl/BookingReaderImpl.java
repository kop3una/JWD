package by.training.project.service.creator.reader.impl;

import by.training.project.beans.Booking;
import by.training.project.beans.Hotel;
import by.training.project.beans.Room;
import by.training.project.dao.*;
import by.training.project.dao.exception.DaoException;
import by.training.project.service.creator.reader.BookingReader;
import by.training.project.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BookingReaderImpl implements BookingReader {
    private final Logger logger = LogManager.getLogger(BookingReaderImpl.class);

    @Override
    public List<Booking> readAllByHotel(Integer hotelId, Transaction transaction) throws ServiceException {
        BookingDao bookingDao = transaction.createDao(DaoFactory.getInstance().getBookingDao());
        try {
            return bookingDao.readAllBookingByHotel(hotelId);
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public Booking read(Integer number, Integer hotelId, Transaction transaction) throws ServiceException {
        Booking booking;
        BookingDao bookingDao = transaction.createDao(DaoFactory.getInstance().getBookingDao());
        try {
            booking = bookingDao.read(number,hotelId);
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e);
        }
        return booking;
    }
}
