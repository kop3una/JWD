package by.training.project.service.booking.impl;

import by.training.project.beans.Room;
import by.training.project.service.booking.Booking;
import by.training.project.service.exception.ServiceException;

import java.util.List;

public class BookingImpl implements Booking
{
    @Override
    public List<Room> listAvailableRooms(Booking booking, Room room) throws ServiceException {
        return null;
    }
}
