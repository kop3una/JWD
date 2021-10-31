package by.training.project.service.hotel.impl;

import by.training.project.beans.Hotel;
import by.training.project.dao.Transaction;
import by.training.project.dao.TransactionCreator;
import by.training.project.dao.exception.DaoException;
import by.training.project.service.creator.CreatorFactory;
import by.training.project.service.creator.reader.HotelReader;
import by.training.project.service.exception.ServiceException;
import by.training.project.service.hotel.HotelService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HotelServiceImpl implements HotelService {
    private final Logger logger = LogManager.getLogger(HotelServiceImpl.class);
    Transaction transaction;

    @Override
    public List<Hotel> readAll() throws ServiceException {
        HotelReader hotelReader = CreatorFactory.getInstance().getHotelReader();
        List<Hotel> hotelList;
        try {
             transaction = createTransaction();
             hotelList = hotelReader.readAll(transaction);
             transaction.commit();
        } catch (ServiceException e) {
            try {
                transaction.rollback();
            } catch (DaoException ex) {
                logger.error("Error with rollback", e);
                throw new ServiceException("Error with rollback");
            }
            logger.error("Error read from DB", e);
            throw new ServiceException("Error read from DB" + e);
        } catch (DaoException e) {
            logger.error("Error with commit", e);
            throw new ServiceException("Error with commit");
        }
        return hotelList;
    }

    @Override
    public List<Hotel> read(Integer page, Integer countPage) throws ServiceException {
        HotelReader hotelReader = CreatorFactory.getInstance().getHotelReader();
        List<Hotel> hotelList;
        try {
            transaction = createTransaction();
            hotelList = hotelReader.read(page,countPage,transaction);
            transaction.commit();
        } catch (ServiceException e) {
            try {
                transaction.rollback();
            } catch (DaoException ex) {
                logger.error("Error with rollback", e);
                throw new ServiceException("Error with rollback");
            }
            logger.error("Error read from DB", e);
            throw new ServiceException("Error read from DB" + e);
        } catch (DaoException e) {
            logger.error("Error with commit", e);
            throw new ServiceException("Error with commit");
        }
        return hotelList;
    }

    private Transaction createTransaction() throws ServiceException {
        try {
            TransactionCreator transactionCreator = new TransactionCreator();
            return transactionCreator.create();
        } catch (DaoException e) {
            logger.error("Can't create transaction");
            throw new ServiceException("Can't create transaction");
        }
    }
}
