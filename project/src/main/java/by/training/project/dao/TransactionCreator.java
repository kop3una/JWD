package by.training.project.dao;

import by.training.project.dao.exception.DaoException;
import by.training.project.dao.impl.TransactionImpl;
import by.training.project.dao.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;


public class TransactionCreator {
    private final Logger logger = LogManager.getLogger(TransactionCreator.class);
    private Connection connection;

    public TransactionCreator() throws DaoException {
        try {
            connection = ConnectionPool.getInstance().getConnection();
            connection.setAutoCommit(false);
        } catch(SQLException e) {
            logger.error("It is impossible to turn off autocommiting for database connection", e);
            throw new DaoException(e);
        } catch (DaoException e){
            logger.error("Can't get Connection from Connection Pool",e);
            throw new DaoException(e);
        }
    }


    public Transaction create() {
        return new TransactionImpl(connection);
    }


    public void close() {
        try {
            connection.close();
        } catch(SQLException e) {}
    }
}
