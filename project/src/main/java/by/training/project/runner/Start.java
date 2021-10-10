package by.training.project.runner;

import by.training.project.beans.Hotel;
import by.training.project.beans.Room;
import by.training.project.dao.DaoFactory;
import by.training.project.dao.RoomDao;
import by.training.project.dao.exception.DaoException;
import by.training.project.dao.pool.ConnectionPool;
import by.training.project.service.exception.ServiceException;

public class Start {

    public static void main(String[] args) throws ServiceException, DaoException {
        ConnectionPool.getInstance().init();
//        Room room = new Room();
//        room.setNumber(45);
//        room.setHotelId(1);
//        room.setTypeComfort(4);
//        room.setTypeAllocation(16);
//        RoomDao roomDao = DaoFactory.getInstance().getRoomDao();
//        roomDao.create(room);
    }
}
