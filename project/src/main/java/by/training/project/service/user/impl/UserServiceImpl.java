package by.training.project.service.user.impl;

import by.training.project.beans.Role;
import by.training.project.beans.User;
import by.training.project.dao.DaoFactory;
import by.training.project.dao.UserDao;
import by.training.project.dao.exception.DaoException;
import by.training.project.service.ServiceFactory;
import by.training.project.service.exception.ServiceException;
import by.training.project.service.hashing.HashingService;
import by.training.project.service.mail.MailService;
import by.training.project.service.reader.ReaderFactory;
import by.training.project.service.reader.UserReader;
import by.training.project.service.user.UserService;
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

    public boolean register(String email, String password, Role role, String locale) { // TODO locale
        MailService mailService = ServiceFactory.getInstance().getMailService();
        HashingService sha256 = ServiceFactory.getInstance().getSHA256Hashing();
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        User user;
        try {
            user = userDao.read(email);
        } catch (DaoException e) {
            return false;
        }

        if (!email.equals(mailService.getEmail()) && user == null) {
            if (mailService.sendApprovalRegistration(email, sha256.hashing(password), role.toString(), locale)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
