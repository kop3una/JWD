package by.training.project.service.creator.reader;
import by.training.project.beans.Room;
import by.training.project.dao.Transaction;
import by.training.project.service.exception.ServiceException;

import java.util.List;

public interface RoomReader {
    List<Room> readAllByHotel (Integer hotelId, Transaction transaction) throws ServiceException;
}
