package by.training.project.controller.command.impl;

import by.training.project.beans.Role;
import by.training.project.controller.command.*;
import by.training.project.controller.command.rout.Rout;
import by.training.project.controller.command.rout.RoutingType;
import by.training.project.service.ServiceFactory;
import by.training.project.service.hashing.HashingService;
import by.training.project.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class EditPassword implements Command {
    @Override
    public Rout execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Optional<Integer> userId = Optional.ofNullable((Integer) session.getAttribute(SessionAttribute.USER_ID));
        Optional<Role> role = Optional.ofNullable((Role) session.getAttribute(SessionAttribute.ROLE));
        Optional<String> password = Optional.ofNullable(request.getParameter(RequestParameter.PASSWORD));
        Optional<String> oldPassword = Optional.ofNullable(request.getParameter(RequestParameter.OLD_PASSWORD));

        if ( role.isEmpty() || userId.isEmpty() || password.isEmpty() || oldPassword.isEmpty()) {
            request.getSession().setAttribute(SessionAttribute.ERROR, ErrorKey.INVALID_DATA);
            return new Rout(PagePath.ERROR_PAGE_REDIRECT, RoutingType.REDIRECT);
        }

        UserService userService = ServiceFactory.getInstance().getUserService();
        HashingService hashingService = ServiceFactory.getInstance().getSHA256Hashing();
        if(userService.editPassword(userId.get(),hashingService.hashing(oldPassword.get()), hashingService.hashing(password.get()))){
            return new Rout(PagePath.SUCCESS_EDIT_PASSWORD_REDIRECT, RoutingType.REDIRECT);
        } else {
            request.getSession().setAttribute(SessionAttribute.ERROR, ErrorKey.ERROR_EDIT_PASSWORD);
            return new Rout(PagePath.ERROR_PAGE_REDIRECT, RoutingType.REDIRECT);
        }
    }
}
