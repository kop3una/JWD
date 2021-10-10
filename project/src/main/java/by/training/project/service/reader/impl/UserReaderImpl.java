package by.training.project.service.reader.impl;

import by.training.project.beans.Role;
import by.training.project.beans.TourOrgInfo;
import by.training.project.beans.User;
import by.training.project.beans.UserInfo;
import by.training.project.dao.DaoFactory;
import by.training.project.dao.TourOrgInfoDao;
import by.training.project.dao.UserDao;
import by.training.project.dao.UserInfoDao;
import by.training.project.dao.exception.DaoException;
import by.training.project.service.exception.ServiceException;
import by.training.project.service.reader.UserReader;
import by.training.project.service.search.TourOrgInfoSearch;
import by.training.project.service.search.UserInfoSearch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class UserReaderImpl implements UserReader { // TODO check if userInfo ==  null
    private final Logger logger = LogManager.getLogger(UserReaderImpl.class);
    @Override
    public User read(Integer identity) throws ServiceException {
        User user;
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        UserInfoDao userInfoDao = DaoFactory.getInstance().getUserInfoDao();
        TourOrgInfoDao tourOrganizationInfoDao = DaoFactory.getInstance().getTourOrganizationInfoDao();
        try {
            user = userDao.read(identity);
            UserInfo userInfo = userInfoDao.read(identity);
            user.setUserInfo(userInfo);
            if (user.getRole() == Role.TOUROPERATOR){
                TourOrgInfo tourOrganizationInfo = tourOrganizationInfoDao.read(identity);
                user.setTourOrgInfo(tourOrganizationInfo);
            }
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e);
        }
        return user;
    }

    @Override
    public List<User> readAll() throws ServiceException {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        UserInfoDao userInfoDao = DaoFactory.getInstance().getUserInfoDao();
        TourOrgInfoDao tourOrganizationInfoDao = DaoFactory.getInstance().getTourOrganizationInfoDao();
        List<User> userList = new ArrayList<>();
        try {
            userList = userDao.read();
            List<UserInfo> userInfoList = userInfoDao.read();
            List<TourOrgInfo> tourOrganizationInfoList = tourOrganizationInfoDao.read();
            UserInfoSearch userInfoSearch = new UserInfoSearch(userInfoList);
            TourOrgInfoSearch tourOrgInfoSearch = new TourOrgInfoSearch(tourOrganizationInfoList);
            for (User user : userList){
               UserInfo userInfo = userInfoSearch.getById(user.getId());
               TourOrgInfo tourOrgInfo = tourOrgInfoSearch.getById(user.getId());
               if (userInfo != null){
                   user.setUserInfo(userInfo);
                   user.setTourOrgInfo(tourOrgInfo);
               }
            }
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e);
        }
        return userList;
    }

    @Override
    public User readByEmail(String email) throws ServiceException {
        User user;
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        UserInfoDao userInfoDao = DaoFactory.getInstance().getUserInfoDao();
        try {
            user = userDao.read(email);
            if (user != null){
                UserInfo userInfo = userInfoDao.read(user.getId());
                user.setUserInfo(userInfo);
            }
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e);
        }
        return user;
    }
}
