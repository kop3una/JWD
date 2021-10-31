package by.training.project.service.booking;

import by.training.project.beans.Room;
import by.training.project.service.exception.ServiceException;

import java.util.List;

public interface Booking {
    List<Room> listAvailableRooms (Booking booking, Room room) throws ServiceException;
}
