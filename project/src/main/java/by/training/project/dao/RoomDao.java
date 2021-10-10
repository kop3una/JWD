package by.training.project.dao;

import by.training.project.beans.Room;
import by.training.project.dao.exception.DaoException;

import java.util.List;

public interface RoomDao {

    int[] create(Room room) throws DaoException;

    Room read(int number, int hotelId) throws DaoException;

    boolean update(Room room) throws DaoException;

    boolean delete(int number, int hotelId) throws DaoException;

    List<Room> readAllRooms() throws DaoException;

    List<Room> readAllRoomsByHotel (int hotelId) throws DaoException;
}
