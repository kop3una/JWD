package by.training.project.dao.impl;

import by.training.project.beans.Room;
import by.training.project.dao.RoomDao;
import by.training.project.dao.exception.DaoException;
import by.training.project.dao.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {
    private final Logger logger = LogManager.getLogger(RoomDaoImpl.class);
    private static final String SQL_INSERT = "INSERT INTO `rooms`(`number`, `hotel_id`, `type_of_allocation`, `type_of_comfort`) VALUES (?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM `rooms` WHERE `number` = ? AND `hotel_id` = ?";
    private static final String SQL_SELECT_ALL = "SELECT `number`, `hotel_id`, `type_of_allocation`, `type_of_comfort` FROM `rooms`";
    private static final String SQL_SELECT_ALL_BY_HOTEL = "SELECT `number`, `hotel_id`, `type_of_allocation`, `type_of_comfort` FROM `rooms` WHERE `hotel_id` = ?";
    private static final String SQL_SELECT_ONE = "SELECT `number`, `hotel_id`, `type_of_allocation`, `type_of_comfort` FROM `rooms` WHERE `number` = ? AND `hotel_id` = ?";
    private static final String SQL_UPDATE = "UPDATE `rooms` SET `type_of_allocation`=?,`type_of_comfort`=? WHERE `number` = ? AND `hotel_id` = ?";

    @Override
    public int[] create(Room room) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = ConnectionPool.getInstance().getConnection().prepareStatement(SQL_INSERT);
            statement.setInt(1,room.getNumber());
            statement.setInt(2,room.getHotelId());
            statement.setInt(3,room.getTypeAllocation());
            statement.setInt(4,room.getTypeComfort());
            statement.executeUpdate();
            return new int[]{room.getNumber(), room.getHotelId()};
        } catch (DaoException | SQLException e) {
            logger.debug(e);
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
                logger.debug(e);
                throw new DaoException(e);
            }
        }
    }

    @Override
    public Room read(int number, int hotelId) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Room room = null;
        try {
            statement = ConnectionPool.getInstance().getConnection().prepareStatement(SQL_SELECT_ONE);
            statement.setInt(1, number);
            statement.setInt(2,hotelId);
            if (statement.execute()) {
                resultSet = statement.getResultSet();
                if (resultSet.next()){
                    room = new Room();
                    room.setNumber(resultSet.getInt(1));
                    room.setHotelId(resultSet.getInt(2));
                    room.setTypeAllocation(resultSet.getInt(3));
                    room.setTypeComfort(resultSet.getInt(4));
                }
            }
        } catch (DaoException | SQLException e) {
            logger.debug(e);
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
                logger.debug(e);
                throw new DaoException(e);
            }
        }
        return room;
    }

    @Override
    public boolean update(Room room) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = ConnectionPool.getInstance().getConnection().prepareStatement(SQL_UPDATE);
            statement.setInt(3,room.getNumber());
            statement.setInt(4,room.getHotelId());
            statement.setInt(1,room.getTypeAllocation());
            statement.setInt(2,room.getTypeComfort());
            return statement.executeUpdate() == 1;
        } catch (DaoException | SQLException e) {
            logger.debug(e);
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
                logger.debug(e);
                throw new DaoException(e);
            }
        }
    }

    @Override
    public boolean delete(int number, int hotelId) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = ConnectionPool.getInstance().getConnection().prepareStatement(SQL_DELETE);
            statement.setInt(1, number);
            statement.setInt(2,hotelId);
            return statement.executeUpdate() == 1;
        } catch (DaoException | SQLException e) {
            logger.debug(e);
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
                logger.debug(e);
                throw new DaoException(e);
            }
        }
    }

    @Override
    public List<Room> readAllRooms() throws DaoException {
        List<Room> roomList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = ConnectionPool.getInstance().getConnection().prepareStatement(SQL_SELECT_ALL);
            if (statement.execute()) {
                resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    Room room = new Room();
                    room.setNumber(resultSet.getInt(1));
                    room.setHotelId(resultSet.getInt(2));
                    room.setTypeAllocation(resultSet.getInt(3));
                    room.setTypeComfort(resultSet.getInt(4));
                    roomList.add(room);
                }
            }
        } catch (DaoException | SQLException e) {
            logger.debug(e);
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
                logger.debug(e);
                throw new DaoException(e);
            }
        }
        return roomList;
    }

    @Override
    public List<Room> readAllRoomsByHotel(int hotelId) throws DaoException {
        List<Room> roomList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = ConnectionPool.getInstance().getConnection().prepareStatement(SQL_SELECT_ALL_BY_HOTEL);
            statement.setInt(1, hotelId);
            if (statement.execute()) {
                resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    Room room = new Room();
                    room.setNumber(resultSet.getInt(1));
                    room.setHotelId(resultSet.getInt(2));
                    room.setTypeAllocation(resultSet.getInt(3));
                    room.setTypeComfort(resultSet.getInt(4));
                    roomList.add(room);
                }
            }
        } catch (DaoException | SQLException e) {
            logger.debug(e);
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
                logger.debug(e);
                throw new DaoException(e);
            }
        }
        return roomList;
    }
}
