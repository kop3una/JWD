package by.training.project.dao;

import by.training.project.beans.TourOrgInfo;
import by.training.project.dao.exception.DaoException;

import java.util.List;

public interface TourOrgInfoDao extends Dao<TourOrgInfo>{
    @Override
    int create(TourOrgInfo tourOrgInfo) throws DaoException;

    @Override
    TourOrgInfo read(int identity) throws DaoException;

    @Override
    boolean update(TourOrgInfo tourOrgInfo) throws DaoException;

    @Override
    boolean delete(int identity) throws DaoException;

    @Override
    List<TourOrgInfo> read() throws DaoException;
}
