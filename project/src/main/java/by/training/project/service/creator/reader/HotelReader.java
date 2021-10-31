package by.training.project.service.creator.reader;

import by.training.project.beans.Hotel;
import by.training.project.dao.Transaction;
import by.training.project.service.exception.ServiceException;

import java.util.List;

public interface HotelReader {
    Hotel read(Integer identity, Transaction transaction) throws ServiceException;

    List<Hotel> readAll(Transaction transaction) throws ServiceException;

    List<Hotel> read(Integer page, Integer countHotelOnPage, Transaction transaction) throws ServiceException;
}
