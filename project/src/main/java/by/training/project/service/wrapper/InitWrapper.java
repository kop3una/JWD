package by.training.project.service.wrapper;

import by.training.project.dao.exception.DaoException;
import by.training.project.dao.pool.ConnectionPool;
import by.training.project.service.exception.ServiceException;

public class InitWrapper {
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final InitWrapper instance = new InitWrapper();

    private InitWrapper(){}

    public static InitWrapper getInstance() {
        return instance;
    }

    public void init () throws ServiceException{
        try {
            connectionPool.init();
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }
}
