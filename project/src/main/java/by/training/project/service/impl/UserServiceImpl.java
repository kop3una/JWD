package by.training.project.service.impl;

import by.training.project.beans.Role;
import by.training.project.beans.User;
import by.training.project.dao.DaoFactory;
import by.training.project.dao.UserDao;
import by.training.project.dao.exception.DaoException;
import by.training.project.service.UserService;
import by.training.project.service.exception.ServiceException;
import by.training.project.service.reader.ReaderFactory;
import by.training.project.service.reader.UserReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserServiceImpl implements UserService {
    private final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Override
    public User login(String email, String passwordMD5) throws ServiceException {
        User user = null;
        if (email != null || passwordMD5 != null) {
            UserReader userReader = ReaderFactory.getInstance().getUserReader();
            try {
                User userRead = userReader.readByEmail(email);
                if (userRead != null && passwordMD5.equals(userRead.getPassword())) {
                    user = userRead;
                }
            } catch (ServiceException e) {
                logger.error("Error read from DB" + e);
                throw new ServiceException("Error read from DB" + e);
            }
        }
        return user;
    }

    public boolean register(String email, String password, Role role){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        try {
            int newID = userDao.create(user);
            user.setId(newID);
        } catch (DaoException e) {
            logger.debug(e);
            return false;
        }
        return true;
    }
}
