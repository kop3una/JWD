package by.training.project.dao;

import by.training.project.beans.UserInfo;
import by.training.project.dao.exception.DaoException;

import java.util.List;

public interface UserInfoDao extends Dao<UserInfo>{

    @Override
    Integer create(UserInfo userInfo) throws DaoException;

    @Override
    UserInfo read(Integer ... identity) throws DaoException;

    @Override
    boolean update(UserInfo userInfo) throws DaoException;

    @Override
    boolean delete(Integer ... identity) throws DaoException;

    @Override
    List<UserInfo> read() throws DaoException;
}
