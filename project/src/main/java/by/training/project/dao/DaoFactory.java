package by.training.project.dao;

import by.training.project.dao.impl.*;

public final class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final UserDao userDaoImpl = new UserDaoImpl();
    private final UserInfoDao userInfoDaoImpl = new UserInfoDaoImpl();
    private final TourOrgInfoDao tourOrganizationInfoDaoImpl = new TourOrgInfoDaoImpl();
    private final HotelDao hotelDaoImpl = new HotelDaoImpl();
    private final CountriesDao countriesDaoImpl = new CountriesDaoImpl();
    private final RoomDao roomDaoImpl = new RoomDaoImpl();

    private DaoFactory() {}
    public static DaoFactory getInstance(){
        return instance;
    }
    public UserDao getUserDao(){
        return userDaoImpl;
    }
    public UserInfoDao getUserInfoDao() { return userInfoDaoImpl; }
    public TourOrgInfoDao getTourOrganizationInfoDao() { return tourOrganizationInfoDaoImpl; }
    public HotelDao getHotelDao() { return hotelDaoImpl; }
    public CountriesDao getCountriesDao() { return countriesDaoImpl; }
    public RoomDao getRoomDao() { return roomDaoImpl; }
}
