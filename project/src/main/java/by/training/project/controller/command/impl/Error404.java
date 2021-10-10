package by.training.project.controller.command.impl;

import by.training.project.controller.command.Command;
import by.training.project.controller.command.ErrorKey;
import by.training.project.controller.command.PagePath;
import by.training.project.controller.command.SessionAttribute;
import by.training.project.controller.command.rout.Rout;
import by.training.project.controller.command.rout.RoutingType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Error404 implements Command {
    @Override
    public Rout execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute(SessionAttribute.ERROR, ErrorKey.ERROR_404);
        return new Rout(PagePath.ERROR_PAGE_REDIRECT, RoutingType.REDIRECT);
    }
}
