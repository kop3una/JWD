package by.training.project.service.hotel;

import by.training.project.beans.Hotel;
import by.training.project.beans.Room;
import by.training.project.service.exception.ServiceException;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface HotelService {
    List<Hotel> readAll() throws ServiceException;
    List<Hotel> read(Integer page, Integer countHotel) throws ServiceException;
    List<Room> roomListForBooking(Integer hotelId, Date dateArrival, Date dateDepartment, Integer typeOfComfort, Integer typeOfAllocation) throws ServiceException;
}
