package by.training.project.controller.command.impl;

import by.training.project.beans.Role;
import by.training.project.controller.command.*;
import by.training.project.controller.command.rout.Rout;
import by.training.project.controller.command.rout.RoutingType;
import by.training.project.service.ServiceFactory;
import by.training.project.service.UserService;
import by.training.project.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class SignUp implements Command { // TODO не забыть, что при оформлении заказа или редактировании нужно заполнить инфу о себе !!! выдавать как ошибкой
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

        if (userService.register(email.get(),password.get(), Role.valueOf(role.get()))){ //TODO PROFILE PAGE
            return new Rout(PagePath.MAIN_PAGE_REDIRECT, RoutingType.REDIRECT);
        } else {
            request.getSession().setAttribute(SessionAttribute.ERROR, ErrorKey.ERROR_DONT_REGISTRATION);
            return new Rout(PagePath.ERROR_PAGE_REDIRECT, RoutingType.REDIRECT);
        }

    }
}
