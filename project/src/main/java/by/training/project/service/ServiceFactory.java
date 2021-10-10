package by.training.project.service;

import by.training.project.dao.DaoFactory;
import by.training.project.service.impl.UserServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
    public UserService getUserService() {
        return userService;
    }

}
