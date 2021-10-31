package by.training.project.service.user.impl;

import by.training.project.beans.*;
import by.training.project.controller.command.SessionAttribute;
import by.training.project.dao.Transaction;
import by.training.project.dao.TransactionCreator;
import by.training.project.dao.exception.DaoException;
import by.training.project.service.ServiceFactory;
import by.training.project.service.creator.writer.UserWriter;
import by.training.project.service.exception.ServiceException;
import by.training.project.service.hashing.HashingService;
import by.training.project.service.mail.MailService;
import by.training.project.service.creator.CreatorFactory;
import by.training.project.service.creator.reader.UserReader;
import by.training.project.service.user.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;

public class UserServiceImpl implements UserService {
    private final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    Transaction transaction;

    @Override
    public User login(String email, String passwordMD5) throws ServiceException {
        User user = null;
        if (email != null || passwordMD5 != null) {
            UserReader userReader = CreatorFactory.getInstance().getUserReader();
            try {
                transaction = createTransaction();
                User userRead = userReader.readByEmail(email, transaction);
                transaction.commit();
                if (userRead != null && passwordMD5.equals(userRead.getPassword())) {
                    user = userRead;
                }
            } catch (ServiceException e) {
                try {
                    transaction.rollback();
                } catch (DaoException ex) {
                    logger.error("Error with rollback", e);
                    throw new ServiceException("Error with rollback");
                }
                logger.error("Error read from DB", e);
                throw new ServiceException("Error read from DB" + e);
            } catch (DaoException e) {
                logger.error("Error with commit", e);
                throw new ServiceException("Error with commit");
            }
        }
        return user;
    }

    public boolean sendMailForRegister(HttpSession session, String email, String password, Role role, String locale) {
        MailService mailService = ServiceFactory.getInstance().getMailService();
        HashingService sha256 = ServiceFactory.getInstance().getSHA256Hashing();
        UserReader userReader = CreatorFactory.getInstance().getUserReader();
        User user;
        try {
            transaction = createTransaction();
            user = userReader.readByEmail(email, transaction);
            transaction.commit();
        } catch (ServiceException e) {
            try {
                transaction.rollback();
            } catch (DaoException ex) {
                logger.error("Error with rollback", e);
                return false;
            }
            return false;
        } catch (DaoException e) {
            logger.error("Error with commit", e);
            return false;
        }

        if (user == null || !email.equals(mailService.getEmail())) {
            if (mailService.sendApprovalRegistration(email, sha256.hashing(password), role.toString(), locale)) {
                session.setAttribute(SessionAttribute.HASH_LINK, mailService.getLinkHash());
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public User register(User user, UserInfo userInfo, TourOrgInfo tourOrgInfo) throws ServiceException {
        User registerUser;
        if (user != null && userInfo != null && tourOrgInfo != null) {
            UserWriter userWriter = CreatorFactory.getInstance().getUserWriter();
            try {
                transaction = createTransaction();
                registerUser = userWriter.register(user, userInfo, tourOrgInfo, transaction);
                transaction.commit();
            } catch (ServiceException e) {
                try {
                    transaction.rollback();
                } catch (DaoException ex) {
                    logger.error("Error with rollback", e);
                    throw new ServiceException("Error with rollback");
                }
                throw new ServiceException("Error read from DB" + e);
            } catch (DaoException e) {
                logger.error("Error with commit", e);
                throw new ServiceException("Error with commit");
            }
            return registerUser;
        } else {
            return null;
        }
    }

    @Override
    public boolean editPassword(Integer userId, String oldPassword, String newPassword) {
        boolean result;
        if (userId != null){
            UserReader userReader = CreatorFactory.getInstance().getUserReader();
            UserWriter userWriter = CreatorFactory.getInstance().getUserWriter();
            try {
                transaction = createTransaction();
                User user = userReader.read(userId,transaction);
                if (user != null && user.getPassword().equals(oldPassword)){
                    user.setPassword(newPassword);
                    result = userWriter.changePassword(user,transaction);
                    if (result){
                        transaction.commit();
                    } else {
                        transaction.rollback();
                    }
                } else {
                    transaction.rollback();
                    return false;
                }
            } catch (ServiceException e) {
                try {
                    transaction.rollback();
                } catch (DaoException ex) {
                    logger.error("Error with rollback", e);
                    return false;
                }
                return false;
            } catch (DaoException e) {
                logger.error("Error with commit", e);
                return false;
            }
            return result;
        } else {
            return false;
        }

    }

    @Override
    public boolean booking(Booking booking) {
        return false;
    }

    private Transaction createTransaction() throws ServiceException {
        try {
            TransactionCreator transactionCreator = new TransactionCreator();
            return transactionCreator.create();
        } catch (DaoException e) {
            logger.error("Can't create transaction");
            throw new ServiceException("Can't create transaction");
        }
    }

}
