package by.training.project.service.user;

import by.training.project.beans.*;
import by.training.project.service.exception.ServiceException;
import javax.servlet.http.HttpSession;

public interface UserService {
    User login(String email, String password) throws ServiceException;
    boolean sendMailForRegister(HttpSession session, String email, String password, Role role, String locale);
    User register(User user, UserInfo userInfo, TourOrgInfo tourOrgInfo) throws ServiceException;
    boolean editPassword(Integer userId, String oldPassword, String newPassword);
    boolean booking (Booking booking);
}
