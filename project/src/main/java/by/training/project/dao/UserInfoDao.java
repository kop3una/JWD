package by.training.project.dao;

import by.training.project.beans.UserInfo;
import by.training.project.dao.exception.DaoException;

import java.util.List;

public interface UserInfoDao extends Dao<UserInfo>{

    @Override
    int create(UserInfo userInfo) throws DaoException;

    @Override
    UserInfo read(int identity) throws DaoException;

    @Override
    boolean update(UserInfo userInfo) throws DaoException;

    @Override
    boolean delete(int identity) throws DaoException;

    @Override
    List<UserInfo> read() throws DaoException;
}
