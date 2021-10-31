package by.training.project.service;

import by.training.project.service.hashing.HashingService;
import by.training.project.service.hashing.impl.SHA256Hashing;
import by.training.project.service.hotel.HotelService;
import by.training.project.service.hotel.impl.HotelServiceImpl;
import by.training.project.service.mail.MailService;
import by.training.project.service.mail.impl.MailServiceImpl;
import by.training.project.service.user.UserService;
import by.training.project.service.user.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    private final HotelService hotelService = new HotelServiceImpl();
    private final MailService mailService = new MailServiceImpl();
    private final HashingService SHA256Hashing = new SHA256Hashing();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
    public UserService getUserService() {
        return userService;
    }
    public MailService getMailService() { return  mailService; }
    public HashingService getSHA256Hashing() {return SHA256Hashing;}
    public HotelService getHotelService() { return hotelService;}

}
