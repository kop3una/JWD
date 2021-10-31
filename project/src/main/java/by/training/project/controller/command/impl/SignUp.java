package by.training.project.controller.command.impl;

import by.training.project.beans.Role;
import by.training.project.controller.command.*;
import by.training.project.controller.command.rout.Rout;
import by.training.project.controller.command.rout.RoutingType;
import by.training.project.service.ServiceFactory;
import by.training.project.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class SignUp implements Command {
    @Override
    public Rout execute(HttpServletRequest request, HttpServletResponse response) {
        Optional<String> email = Optional.ofNullable(request.getParameter(RequestParameter.EMAIL));
        Optional<String> password = Optional.ofNullable(request.getParameter(RequestParameter.PASSWORD));
        Optional<String> role = Optional.ofNullable(request.getParameter(RequestParameter.ROLE));

        if (email.isEmpty() || password.isEmpty() || role.isEmpty()){
            request.getSession().setAttribute(SessionAttribute.ERROR, ErrorKey.INVALID_SIGNUP_DATA);
            return new Rout(PagePath.ERROR_PAGE_REDIRECT, RoutingType.REDIRECT);
        }

        UserService userService = ServiceFactory.getInstance().getUserService();

        if (userService.sendMailForRegister(request.getSession(),email.get(),password.get(), Role.valueOf(role.get()), (String) request.getSession().getAttribute(SessionAttribute.LOCALE))){
               return new Rout(PagePath.MAIL_CHECK_REDIRECT, RoutingType.REDIRECT);
        } else {
            request.getSession().setAttribute(SessionAttribute.ERROR, ErrorKey.ERROR_DONT_REGISTRATION);
            return new Rout(PagePath.ERROR_PAGE_REDIRECT, RoutingType.REDIRECT);
        }

    }
}
