package by.training.project.service.creator.reader;

import by.training.project.beans.Booking;
import by.training.project.dao.Transaction;
import by.training.project.service.exception.ServiceException;

import java.util.List;

public interface BookingReader {
    List<Booking> readAllByHotel (Integer hotelId, Transaction transaction) throws ServiceException;
    Booking read(Integer number, Integer hotelId, Transaction transaction) throws ServiceException;
}
