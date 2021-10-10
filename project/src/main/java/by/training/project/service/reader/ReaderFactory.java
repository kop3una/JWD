package by.training.project.service.reader;

import by.training.project.dao.UserDao;
import by.training.project.dao.UserInfoDao;
import by.training.project.dao.impl.UserDaoImpl;
import by.training.project.dao.impl.UserInfoDaoImpl;
import by.training.project.service.reader.impl.HotelReaderImpl;
import by.training.project.service.reader.impl.UserReaderImpl;

public final class ReaderFactory {
    private static final ReaderFactory instance = new ReaderFactory();
    private final UserReader userReaderImpl = new UserReaderImpl();
    private final HotelReader hotelReaderImpl = new HotelReaderImpl();

    private ReaderFactory() {}
    public static ReaderFactory getInstance(){
        return instance;
    }
    public UserReader getUserReader() { return userReaderImpl; }
    public HotelReader getHotelReader() { return hotelReaderImpl; }
}
