package by.training.project.service.creator.reader.impl;

import by.training.project.beans.Hotel;
import by.training.project.beans.Room;
import by.training.project.dao.DaoFactory;
import by.training.project.dao.HotelDao;
import by.training.project.dao.RoomDao;
import by.training.project.dao.Transaction;
import by.training.project.dao.exception.DaoException;
import by.training.project.service.creator.reader.BookingReader;
import by.training.project.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BookingReaderImpl implements BookingReader {
    private final Logger logger = LogManager.getLogger(BookingReaderImpl.class);

    @Override
    public List<Room> readAllByHotel(Integer hotelId, Transaction transaction) throws ServiceException {
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
}
