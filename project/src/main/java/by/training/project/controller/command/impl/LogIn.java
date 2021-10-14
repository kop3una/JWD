package by.training.project.controller.command.impl;

import by.training.project.beans.User;
import by.training.project.controller.command.*;
import by.training.project.controller.command.rout.Rout;
import by.training.project.controller.command.rout.RoutingType;
import by.training.project.service.ServiceFactory;
import by.training.project.service.hashing.HashingService;
import by.training.project.service.user.UserService;
import by.training.project.service.exception.ServiceException;
import by.training.project.service.hashing.impl.SHA256Hashing;

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

        if (email.isEmpty() || password.isEmpty()) {
            request.getSession().setAttribute(SessionAttribute.ERROR, ErrorKey.INVALID_SIGNUP_DATA);
            return new Rout(PagePath.ERROR_PAGE_REDIRECT, RoutingType.REDIRECT);
        }

        HashingService sha256 = ServiceFactory.getInstance().getSHA256Hashing();
        password = Optional.of(sha256.hashing(RequestParameter.PASSWORD));

        UserService userService = ServiceFactory.getInstance().getUserService();
        User user;
        try {
            user = userService.login(email.get(), password.get());
        } catch (ServiceException e) {
            request.getSession().setAttribute(SessionAttribute.ERROR, ErrorKey.ERROR_500);
            return new Rout(PagePath.ERROR_PAGE_REDIRECT, RoutingType.REDIRECT);
        }

        if (user != null) {
            // TODO session users
        } else {
            session.setAttribute(SessionAttribute.ERROR, ErrorKey.INVALID_LOGIN_DATA);
            return new Rout(PagePath.ERROR_PAGE_REDIRECT, RoutingType.REDIRECT);
        }

        return new Rout(PagePath.MAIN_PAGE, RoutingType.FORWARD);
    }
}
