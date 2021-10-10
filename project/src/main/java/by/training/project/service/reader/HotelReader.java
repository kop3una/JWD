package by.training.project.service.reader;

import by.training.project.beans.Hotel;
import by.training.project.service.exception.ServiceException;

import java.util.List;

public interface HotelReader extends Reader<Hotel> {
    @Override
    Hotel read(Integer identity) throws ServiceException;

    @Override
    List<Hotel> readAll() throws ServiceException;
}
