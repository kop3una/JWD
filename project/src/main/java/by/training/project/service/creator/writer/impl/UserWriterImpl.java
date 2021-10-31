package by.training.project.service.creator.writer.impl;

import by.training.project.beans.Role;
import by.training.project.beans.TourOrgInfo;
import by.training.project.beans.User;
import by.training.project.beans.UserInfo;
import by.training.project.dao.*;
import by.training.project.dao.exception.DaoException;
import by.training.project.service.creator.BaseCreator;
import by.training.project.service.creator.writer.UserWriter;
import by.training.project.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserWriterImpl extends BaseCreator implements UserWriter {
    private final Logger logger = LogManager.getLogger(UserWriterImpl.class);

    @Override
    public User register(User user, UserInfo userInfo, TourOrgInfo tourOrgInfo, Transaction transaction) throws ServiceException {
        UserDao userDao = transaction.createDao(DaoFactory.getInstance().getUserDao());
        UserInfoDao userInfoDao = transaction.createDao(DaoFactory.getInstance().getUserInfoDao());
        TourOrgInfoDao tourOrgInfoDao = transaction.createDao(DaoFactory.getInstance().getTourOrganizationInfoDao());

        try {
            Integer userId = userDao.create(user);
            user.setId(userId);
            userInfo.setId(userId);
            readCodeCountry(userInfo);
            userInfoDao.create(userInfo);
            user.setUserInfo(userInfo);
            if (user.getRole().equals(Role.TOUROPERATOR)){
                tourOrgInfo.setId(userId);
                tourOrgInfoDao.create(tourOrgInfo);
                user.setTourOrgInfo(tourOrgInfo);
            }
            return user;
        } catch (DaoException e) {
            logger.error("Can't register user",e);
            throw new ServiceException("Can't register user",e);
        }

    }

    @Override
    public boolean changePassword(User user, Transaction transaction) {
        UserDao userDao = transaction.createDao(DaoFactory.getInstance().getUserDao());
        try {
            return userDao.update(user);
        } catch (DaoException e) {
            logger.error("Can't edit password",e);
            return false;
        }
    }

    private void readCodeCountry(UserInfo userInfo) throws DaoException {
        CountriesDao countriesDao = DaoFactory.getInstance().getCountriesDao();
        char [] countryCode = countriesDao.readCountryCode(userInfo.getCountry());
        userInfo.setCodeCountry(countryCode);
    }
}
