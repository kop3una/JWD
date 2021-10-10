package by.training.project.service;

import by.training.project.beans.Role;
import by.training.project.beans.User;
import by.training.project.service.exception.ServiceException;

public interface UserService {
    User login(String email, String password) throws ServiceException;
    boolean register(String email, String password, Role role);
}
