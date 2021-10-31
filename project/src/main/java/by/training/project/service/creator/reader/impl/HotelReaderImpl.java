package by.training.project.service.creator.reader.impl;

import by.training.project.beans.*;
import by.training.project.dao.*;
import by.training.project.dao.exception.DaoException;
import by.training.project.service.creator.BaseCreator;
import by.training.project.service.exception.ServiceException;
import by.training.project.service.creator.reader.HotelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class HotelReaderImpl extends BaseCreator implements HotelReader {
    private final Logger logger = LogManager.getLogger(HotelReaderImpl.class);

    @Override
    public Hotel read(Integer identity, Transaction transaction) throws ServiceException {
        Hotel hotel;
        HotelDao hotelDao = transaction.createDao(DaoFactory.getInstance().getHotelDao());
        RoomDao roomDao = transaction.createDao(DaoFactory.getInstance().getRoomDao());
        try {
            hotel = hotelDao.read(identity);
            List<Room> roomList = roomDao.readAllRoomsByHotel(hotel.getId());
            hotel.setListRoom(roomList);
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e);
        }
        return hotel;
    }

    @Override
    public List<Hotel> readAll(Transaction transaction) throws ServiceException {
        HotelDao hotelDao = transaction.createDao(DaoFactory.getInstance().getHotelDao());
        RoomDao roomDao = transaction.createDao(DaoFactory.getInstance().getRoomDao());
        List<Hotel> hotelList;
        try {
            hotelList = hotelDao.read();
            for (Hotel hotel : hotelList){
                List<Room> roomList = roomDao.readAllRoomsByHotel(hotel.getId());
                hotel.setListRoom(roomList);
            }
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e);
        }
        return hotelList;
    }

    @Override
    public List<Hotel> read(Integer page, Integer countHotelOnPage, Transaction transaction) throws ServiceException {
        HotelDao hotelDao = transaction.createDao(DaoFactory.getInstance().getHotelDao());
        RoomDao roomDao = transaction.createDao(DaoFactory.getInstance().getRoomDao());
        List<Hotel> hotelList;
        try {
            hotelList = hotelDao.read(page, countHotelOnPage);
            for (Hotel hotel : hotelList){
                List<Room> roomList = roomDao.readAllRoomsByHotel(hotel.getId());
                hotel.setListRoom(roomList);
            }
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e);
        }
        return hotelList;
    }
}
