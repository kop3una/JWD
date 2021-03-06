package by.training.project.service.creator.reader.impl;

import by.training.project.beans.Role;
import by.training.project.beans.TourOrgInfo;
import by.training.project.beans.User;
import by.training.project.beans.UserInfo;
import by.training.project.dao.*;
import by.training.project.dao.exception.DaoException;
import by.training.project.service.creator.BaseCreator;
import by.training.project.service.exception.ServiceException;
import by.training.project.service.creator.reader.UserReader;
import by.training.project.service.search.TourOrgInfoSearch;
import by.training.project.service.search.UserInfoSearch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.LinkedList;
import java.util.List;

public class UserReaderImpl extends BaseCreator implements UserReader {
    private final Logger logger = LogManager.getLogger(UserReaderImpl.class);

    @Override
    public User read(Integer identity, Transaction transaction) throws ServiceException {
        User user;
        UserDao userDao = transaction.createDao(DaoFactory.getInstance().getUserDao());
        UserInfoDao userInfoDao = transaction.createDao(DaoFactory.getInstance().getUserInfoDao());
        TourOrgInfoDao tourOrganizationInfoDao = transaction.createDao(DaoFactory.getInstance().getTourOrganizationInfoDao());
        try {
            user = userDao.read(identity);
            buildUser(user,userInfoDao,tourOrganizationInfoDao);
            transaction.commit();
        } catch (DaoException e) {
            logger.debug(e);
            try {
                transaction.rollback();
            } catch (DaoException ex) {}
            throw new ServiceException(e);
        }
        return user;
    }

    @Override
    public List<User> readAll(Transaction transaction) throws ServiceException {
        UserDao userDao = transaction.createDao(DaoFactory.getInstance().getUserDao());
        UserInfoDao userInfoDao = transaction.createDao(DaoFactory.getInstance().getUserInfoDao());
        TourOrgInfoDao tourOrganizationInfoDao = transaction.createDao(DaoFactory.getInstance().getTourOrganizationInfoDao());
        List<User> userList;
        List<User> checkedUsers = new LinkedList<>();
        try {
            userList = userDao.read();
            List<UserInfo> userInfoList = userInfoDao.read();
            List<TourOrgInfo> tourOrganizationInfoList = tourOrganizationInfoDao.read();
            UserInfoSearch userInfoSearch = new UserInfoSearch(userInfoList);
            TourOrgInfoSearch tourOrgInfoSearch = new TourOrgInfoSearch(tourOrganizationInfoList);
            for (User user : userList) {
                UserInfo userInfo = userInfoSearch.getById(user.getId());
                TourOrgInfo tourOrgInfo = tourOrgInfoSearch.getById(user.getId());
                if (userInfo != null) {
                    user.setUserInfo(userInfo);
                    if (user.getRole() == Role.TOUROPERATOR) {
                        if (tourOrgInfo != null){
                            user.setTourOrgInfo(tourOrgInfo);
                            checkedUsers.add(user);
                        }
                    } else {
                        checkedUsers.add(user);
                    }
                }
            }
            transaction.commit();
        } catch (DaoException e) {
            logger.debug(e);
            try {
                transaction.rollback();
            } catch (DaoException ex) {
            }
            throw new ServiceException(e);
        }
        return checkedUsers;
    }

    @Override
    public User readByEmail(String email, Transaction transaction) throws ServiceException {
        User user;
        UserDao userDao = transaction.createDao(DaoFactory.getInstance().getUserDao());
        UserInfoDao userInfoDao = transaction.createDao(DaoFactory.getInstance().getUserInfoDao());
        TourOrgInfoDao tourOrganizationInfoDao = transaction.createDao(DaoFactory.getInstance().getTourOrganizationInfoDao());
        try {
            user = userDao.read(email);
            buildUser(user,userInfoDao,tourOrganizationInfoDao);
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e);
        }
        return user;
    }

    private void buildUser (User user, UserInfoDao userInfoDao, TourOrgInfoDao tourOrgInfoDao) throws DaoException, ServiceException {
        if (user != null) {
            UserInfo userInfo = userInfoDao.read(user.getId());
            if (userInfo != null) {
                user.setUserInfo(userInfo);
                if (user.getRole() == Role.TOUROPERATOR) {
                    TourOrgInfo tourOrganizationInfo = tourOrgInfoDao.read(user.getId());
                    if (tourOrganizationInfo != null) {
                        user.setTourOrgInfo(tourOrganizationInfo);
                    } else {
                        transaction.rollback();
                        throw new ServiceException("TourOrg info can't find in DB");
                    }
                }
            } else {
                transaction.rollback();
                throw new ServiceException("User Info can't find in DB");
            }
        }
    }
}
