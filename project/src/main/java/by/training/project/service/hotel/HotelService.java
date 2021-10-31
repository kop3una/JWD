package by.training.project.service.hotel;

import by.training.project.beans.Hotel;
import by.training.project.service.exception.ServiceException;

import java.util.List;

public interface HotelService {
    List<Hotel> readAll() throws ServiceException;
    List<Hotel> read(Integer page, Integer countHotel) throws ServiceException;
}
