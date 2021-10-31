package by.training.project.runner;

import by.training.project.beans.Hotel;
import by.training.project.beans.Role;
import by.training.project.beans.Room;
import by.training.project.dao.DaoFactory;
import by.training.project.dao.RoomDao;
import by.training.project.dao.exception.DaoException;
import by.training.project.dao.pool.ConnectionPool;
import by.training.project.service.exception.ServiceException;

import java.util.HashMap;

public class Start {

    public static void main(String[] args) throws ServiceException, DaoException {
        Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1==i2);
        ConnectionPool.getInstance().init();
        assert 1==1;
        HashMap<String,Integer> student = new HashMap<String,Integer>();
        student.put("Anton",25);
        Role role = Role.ADMINISTRATOR;
        switch (role){
            case TOUROPERATOR:
            case ADMINISTRATOR:
            case CLIENT:
        }
//        Room room = new Room();
//        room.setNumber(45);
//        room.setHotelId(1);
//        room.setTypeComfort(4);
//        room.setTypeAllocation(16);
//        RoomDao roomDao = DaoFactory.getInstance().getRoomDao();
//        roomDao.create(room);
    }
}
