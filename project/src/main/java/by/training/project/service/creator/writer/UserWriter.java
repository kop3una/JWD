package by.training.project.service.creator.writer;

import by.training.project.beans.TourOrgInfo;
import by.training.project.beans.User;
import by.training.project.beans.UserInfo;
import by.training.project.dao.Transaction;
import by.training.project.service.exception.ServiceException;

public interface UserWriter {
    User register(User user, UserInfo userInfo, TourOrgInfo tourOrgInfo, Transaction transaction) throws ServiceException;
    boolean changePassword(User user, Transaction transaction);
}
