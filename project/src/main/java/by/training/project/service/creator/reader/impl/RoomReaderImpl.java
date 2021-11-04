package by.training.project.service.creator.reader.impl;

import by.training.project.beans.EntityConstant;
import by.training.project.beans.Hotel;
import by.training.project.beans.Room;
import by.training.project.dao.DaoFactory;
import by.training.project.dao.HotelDao;
import by.training.project.dao.RoomDao;
import by.training.project.dao.Transaction;
import by.training.project.dao.exception.DaoException;
import by.training.project.service.creator.reader.RoomReader;
import by.training.project.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class RoomReaderImpl implements RoomReader {
    private final Logger logger = LogManager.getLogger(RoomReaderImpl.class);

    @Override
    public List<Room> readAllByHotel(Integer hotelId, Transaction transaction) throws ServiceException {
        HotelDao hotelDao = transaction.createDao(DaoFactory.getInstance().getHotelDao());
        RoomDao roomDao = transaction.createDao(DaoFactory.getInstance().getRoomDao());
        try {
            Hotel hotel = hotelDao.read(hotelId);
            List<Room> roomList= roomDao.readAllRoomsByHotel(hotelId);
            calculatePriceRoom(roomList,hotel);
            return roomList;
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e);
        }
    }

    private void calculatePriceRoom (List<Room> roomList, Hotel hotel){
        int [] priceComfort = hotel.getPrices().getPriceComfortIntArr();
        int [] priceAllocation = hotel.getPrices().getPriceAllocationIntArr();
        for (Room room: roomList){
            int typeComfort = room.getTypeComfort();
            int typeAllocation = room.getTypeAllocation();
            int price = 0;
            if ((typeAllocation & EntityConstant.HOTEL_SINGLE) != 0){
                price += priceAllocation[0];
            }
            if ((typeAllocation & EntityConstant.HOTEL_DOUBLE) != 0){
                price += priceAllocation[1];
            }
            if ((typeAllocation & EntityConstant.HOTEL_TRIPLE) !=0){
                price += priceAllocation[2];
            }
            if ((typeAllocation & EntityConstant.HOTEL_EXTRA) !=0){
                price += priceAllocation[3];
            }
            if ((typeAllocation & EntityConstant.HOTEL_CHILD) !=0){
                price += priceAllocation[4];
            }
            if ((typeComfort & EntityConstant.TYPE_ALLOCATION_FAMILY) != 0){
                price += priceComfort[2];
            }
            if ((typeComfort & EntityConstant.TYPE_ALLOCATION_LUXE) !=0){
                price += priceComfort[1];
            }
            if ((typeComfort & EntityConstant.TYPE_ALLOCATION_SUITE) !=0){
                price += priceComfort[0];
            }
            room.setPrice(price);
        }
    }
}
