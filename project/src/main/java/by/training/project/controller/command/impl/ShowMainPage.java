package by.training.project.controller.command.impl;

import by.training.project.beans.Role;
import by.training.project.controller.command.Command;
import by.training.project.controller.command.ErrorKey;
import by.training.project.controller.command.PagePath;
import by.training.project.controller.command.SessionAttribute;
import by.training.project.controller.command.rout.Rout;
import by.training.project.controller.command.rout.RoutingType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowMainPage implements Command {
    @Override
    public Rout execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute(SessionAttribute.PAGE_ROOMS);
        return new Rout(PagePath.MAIN_PAGE_REDIRECT, RoutingType.REDIRECT);
    }
}
