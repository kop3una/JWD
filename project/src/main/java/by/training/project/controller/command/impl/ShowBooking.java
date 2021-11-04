package by.training.project.controller.command.impl;

import by.training.project.beans.Role;
import by.training.project.controller.command.*;
import by.training.project.controller.command.rout.Rout;
import by.training.project.controller.command.rout.RoutingType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class ShowBooking implements Command {
    @Override
    public Rout execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute(SessionAttribute.PAGE_MAIN);
        session.removeAttribute(SessionAttribute.PAGE_ROOMS);
        session.removeAttribute(SessionAttribute.PAGE_PERSONAL_AREA);
        Optional<Role> role = Optional.ofNullable((Role) session.getAttribute(SessionAttribute.ROLE));
        if (role.isEmpty()){
            request.getSession().setAttribute(SessionAttribute.ERROR, ErrorKey.INVALID_ROLE_BOOKING);
            return new Rout(PagePath.ERROR_PAGE_REDIRECT, RoutingType.REDIRECT);
        } else {
            return new Rout(PagePath.SHOW_BOOKING, RoutingType.FORWARD);
        }
    }
}
