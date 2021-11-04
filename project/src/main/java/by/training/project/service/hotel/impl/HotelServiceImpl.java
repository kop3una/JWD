package by.training.project.service.hotel.impl;

import by.training.project.beans.Booking;
import by.training.project.beans.EntityConstant;
import by.training.project.beans.Hotel;
import by.training.project.beans.Room;
import by.training.project.dao.Transaction;
import by.training.project.dao.TransactionCreator;
import by.training.project.dao.exception.DaoException;
import by.training.project.service.creator.CreatorFactory;
import by.training.project.service.creator.reader.BookingReader;
import by.training.project.service.creator.reader.HotelReader;
import by.training.project.service.creator.reader.RoomReader;
import by.training.project.service.exception.ServiceException;
import by.training.project.service.hotel.HotelService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

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
            hotelList = hotelReader.read(page, countPage, transaction);
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
    public List<Room> roomListForBooking(Integer hotelId, Date dateArrival, Date dateDepartment, Integer typeOfComfort, Integer typeOfAllocation) throws ServiceException {
        HotelReader hotelReader = CreatorFactory.getInstance().getHotelReader();
        RoomReader roomReader = CreatorFactory.getInstance().getRoomReader();
        BookingReader bookingReader = CreatorFactory.getInstance().getBookingReader();
        List<Room> roomList = new ArrayList<>();
        try {
            transaction = createTransaction();
            Hotel hotel = hotelReader.read(hotelId, transaction);
            if (hotel != null && !hotel.getListRoom().isEmpty()) {
                List<Room> roomListByHotel = roomReader.readAllByHotel(hotelId, transaction);
                List<Booking> bookingList = bookingReader.readAllByHotel(hotelId, transaction);
                roomList = createListRoom(roomListByHotel,bookingList, dateArrival,dateDepartment,typeOfComfort,typeOfAllocation);
            }
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
        return roomList;
    }

    private List<Room> createListRoom(List<Room> roomListByHotel, List<Booking> bookingList, Date dateArrival, Date dateDepartment, Integer typeOfComfort, Integer typeOfAllocation) {
        List<Room> roomListSort = new ArrayList<>();
        for (Room room : roomListByHotel) {
            if ((room.getTypeComfort() == typeOfComfort) &&
                    (( (room.getTypeAllocation() <= typeOfAllocation)) || (room.getTypeAllocation()==17 && typeOfAllocation==16)) ) {
                roomListSort.add(room);
            }
        }
        for (Booking booking : bookingList) {
            if ( ( (dateArrival.compareTo(booking.getDateArrival()) >= 0) && (dateArrival.compareTo(booking.getDateDepartment()) <= 0) )
                    || ( (dateDepartment.compareTo(booking.getDateArrival()) >= 0) && (dateDepartment.compareTo(booking.getDateDepartment()) <= 0) ) )  {
                removeRoom(roomListSort,booking);
            }
        }
        return roomListSort;
    }

    private void removeRoom(List<Room> roomListSort, Booking booking) {
        Room room;
        for (int i = 0; i < roomListSort.size()-1; i++){
            room = roomListSort.get(i);
            if (room.getNumber() == booking.getNumber() && room.getHotelId() == booking.getHotelId()){
                roomListSort.remove(room);
            }
        }
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
