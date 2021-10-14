package by.training.project.service.user;

import by.training.project.beans.Role;
import by.training.project.beans.User;
import by.training.project.dao.exception.DaoException;
import by.training.project.service.exception.ServiceException;

import java.util.Locale;

public interface UserService {
    User login(String email, String password) throws ServiceException;
    boolean register(String email, String password, Role role, String locale);
}
