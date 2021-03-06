package by.training.project.controller.command.impl;

import by.training.project.beans.User;
import by.training.project.controller.command.*;
import by.training.project.controller.command.rout.Rout;
import by.training.project.controller.command.rout.RoutingType;
import by.training.project.service.ServiceFactory;
import by.training.project.service.hashing.HashingService;
import by.training.project.service.user.UserService;
import by.training.project.service.exception.ServiceException;
import org.apache.commons.validator.routines.EmailValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LogIn implements Command { // TODO do log in in page
    @Override
    public Rout execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Optional<String> email = Optional.ofNullable(request.getParameter(RequestParameter.EMAIL));
        Optional<String> password = Optional.ofNullable(request.getParameter(RequestParameter.PASSWORD));

        if (email.isEmpty() || password.isEmpty() || !EmailValidator.getInstance().isValid(email.get())) {
            request.getSession().setAttribute(SessionAttribute.ERROR, ErrorKey.INVALID_SIGNUP_DATA);
            return new Rout(PagePath.ERROR_PAGE_REDIRECT, RoutingType.REDIRECT);
        }

        HashingService sha256 = ServiceFactory.getInstance().getSHA256Hashing();
        String passwordHash = sha256.hashing(password.get());

        UserService userService = ServiceFactory.getInstance().getUserService();
        User user;
        try {
            user = userService.login(email.get(), passwordHash);
        } catch (ServiceException e) {
            request.getSession().setAttribute(SessionAttribute.ERROR, ErrorKey.ERROR_500);
            return new Rout(PagePath.ERROR_PAGE_REDIRECT, RoutingType.REDIRECT);
        }

        if (user != null) {
            String userName = user.getUserInfo().getName()+" "+user.getUserInfo().getSurname();
            session.setAttribute(SessionAttribute.USER_ID, user.getId());
            session.setAttribute(SessionAttribute.USER_NAME, userName);
            session.setAttribute(SessionAttribute.ROLE, user.getRole());
            return new Rout(PagePath.MAIN_PAGE_REDIRECT, RoutingType.REDIRECT);
        } else {
            session.setAttribute(SessionAttribute.ERROR, ErrorKey.INVALID_LOGIN_DATA);
            return new Rout(PagePath.ERROR_PAGE_REDIRECT, RoutingType.REDIRECT);
        }


    }
}
