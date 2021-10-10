package by.training.project.dao.impl;

import by.training.project.beans.TourOrgInfo;
import by.training.project.dao.TourOrgInfoDao;
import by.training.project.dao.exception.DaoException;
import by.training.project.dao.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TourOrgInfoDaoImpl implements TourOrgInfoDao {
    private final Logger logger = LogManager.getLogger(TourOrgInfoDaoImpl.class);
    private static final String SQL_INSERT = "INSERT INTO `tour_organization_info`(`user_id`, `tour_organization`, `license`) VALUES (?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM `tour_organization_info` WHERE `tour_organization_info`.`id` = ?";
    private static final String SQL_SELECT_ALL = "SELECT `user_id`, `tour_organization`, `license` FROM `tour_organization_info`";
    private static final String SQL_SELECT_ONE = "SELECT `user_id`, `tour_organization`, `license` FROM `tour_organization_info` WHERE `tour_organization`.`id`=?";
    private static final String SQL_UPDATE = "UPDATE `tour_organization_info` SET `tour_organization`=?,`license`=? WHERE `tour_organization`.`id` = ?";

    @Override
    public int create(TourOrgInfo tourOrgInfo) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = ConnectionPool.getInstance().getConnection().prepareStatement(SQL_INSERT, Statement.NO_GENERATED_KEYS);
            statement.setInt(1, tourOrgInfo.getId());
            statement.setString(2, tourOrgInfo.getTourOrg());
            statement.setString(3, tourOrgInfo.getLicense());
            statement.executeUpdate();
            return tourOrgInfo.getId();
        } catch (DaoException | SQLException e) {
            logger.debug(e);
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
                logger.debug(e);
                throw new DaoException(e);
            }
        }
    }

    @Override
    public TourOrgInfo read(int identity) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        TourOrgInfo tourOrganizationInfo = null;
        try {
            statement = ConnectionPool.getInstance().getConnection().prepareStatement(SQL_SELECT_ONE);
            statement.setInt(1, identity);
            if (statement.execute()) {
                resultSet = statement.getResultSet();
                if (resultSet.next()){
                    tourOrganizationInfo = new TourOrgInfo();
                    tourOrganizationInfo.setId(resultSet.getInt(1));
                    tourOrganizationInfo.setTourOrg(resultSet.getString(2));
                    tourOrganizationInfo.setLicense(resultSet.getString(3));
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
        return tourOrganizationInfo;
    }

    @Override
    public boolean update(TourOrgInfo tourOrgInfo) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = ConnectionPool.getInstance().getConnection().prepareStatement(SQL_UPDATE);
            statement.setInt(3, tourOrgInfo.getId());
            statement.setString(1, tourOrgInfo.getTourOrg());
            statement.setString(2, tourOrgInfo.getLicense());
            return statement.executeUpdate() == 1;
        } catch (DaoException | SQLException e) {
            logger.debug(e);
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
                logger.debug(e);
                throw new DaoException(e);
            }
        }
    }

    @Override
    public boolean delete(int identity) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = ConnectionPool.getInstance().getConnection().prepareStatement(SQL_DELETE);
            statement.setInt(1, identity);
            return statement.executeUpdate() == 1;
        } catch (DaoException | SQLException e) {
            logger.debug(e);
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
                logger.debug(e);
                throw new DaoException(e);
            }
        }
    }

    @Override
    public List<TourOrgInfo> read() throws DaoException {
        List<TourOrgInfo> tourOrganizationInfoList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = ConnectionPool.getInstance().getConnection().prepareStatement(SQL_SELECT_ALL);
            if (statement.execute()) {
                resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    TourOrgInfo tourOrganizationInfo = new TourOrgInfo();
                    tourOrganizationInfo.setId(resultSet.getInt(1));
                    tourOrganizationInfo.setTourOrg(resultSet.getString(2));
                    tourOrganizationInfo.setLicense(resultSet.getString(3));
                    tourOrganizationInfoList.add(tourOrganizationInfo);
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
        return tourOrganizationInfoList;
    }
}
