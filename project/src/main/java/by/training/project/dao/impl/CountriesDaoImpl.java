package by.training.project.dao.impl;

import by.training.project.dao.CountriesDao;
import by.training.project.dao.exception.DaoException;
import by.training.project.dao.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountriesDaoImpl implements CountriesDao {
    private final Logger logger = LogManager.getLogger(CountriesDaoImpl.class);
    private static final String SQL_SELECT_ONE = "SELECT `name` FROM `countries` WHERE `code` = ?";

    @Override
    public String read(String countryCode) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String countryName = "";
        try {
            statement = ConnectionPool.getInstance().getConnection().prepareStatement(SQL_SELECT_ONE);
            statement.setString(1, countryCode);
            if (statement.execute()) {
                resultSet = statement.getResultSet();
                if (resultSet.next()){
                    countryName = resultSet.getString(1);
                }
            }
        } catch (DaoException | SQLException e) {
            logger.debug(e);
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
                logger.debug(e);
                throw new DaoException(e);
            }
        }
        return countryName;
    }
}