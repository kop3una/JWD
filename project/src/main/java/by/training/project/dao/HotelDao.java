package by.training.project.dao;

import by.training.project.beans.Hotel;
import by.training.project.dao.exception.DaoException;

import java.util.List;


public interface HotelDao extends Dao<Hotel> {
    @Override
    int create(Hotel hotel) throws DaoException;

    @Override
    Hotel read(int identity) throws DaoException;

    @Override
    boolean update(Hotel hotel) throws DaoException;

    @Override
    boolean delete(int identity) throws DaoException;

    @Override
    List<Hotel> read() throws DaoException;
}
