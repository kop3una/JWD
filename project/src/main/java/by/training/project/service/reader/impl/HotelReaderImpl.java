package by.training.project.service.reader.impl;

import by.training.project.beans.*;
import by.training.project.dao.*;
import by.training.project.dao.exception.DaoException;
import by.training.project.service.exception.ServiceException;
import by.training.project.service.reader.HotelReader;
import by.training.project.service.search.TourOrgInfoSearch;
import by.training.project.service.search.UserInfoSearch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class HotelReaderImpl implements HotelReader {
    private final Logger logger = LogManager.getLogger(HotelReaderImpl.class);
    @Override
    public Hotel read(Integer identity) throws ServiceException {
        Hotel hotel;
        HotelDao hotelDao = DaoFactory.getInstance().getHotelDao();
        RoomDao roomDao = DaoFactory.getInstance().getRoomDao();
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
    public List<Hotel> readAll() throws ServiceException {
        HotelDao hotelDao = DaoFactory.getInstance().getHotelDao();
        RoomDao roomDao = DaoFactory.getInstance().getRoomDao();
        List<Hotel> hotelList = new ArrayList<>();
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
}
