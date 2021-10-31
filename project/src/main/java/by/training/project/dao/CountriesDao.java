package by.training.project.dao;

import by.training.project.dao.exception.DaoException;

public interface CountriesDao {
    String read (String countryCode) throws DaoException;
    char[] readCountryCode(String country) throws DaoException;
}
