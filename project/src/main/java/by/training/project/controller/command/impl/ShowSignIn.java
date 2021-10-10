package by.training.project.controller.command.impl;

import by.training.project.controller.command.Command;
import by.training.project.controller.command.PagePath;
import by.training.project.controller.command.rout.Rout;
import by.training.project.controller.command.rout.RoutingType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowSignIn implements Command {
    @Override
    public Rout execute(HttpServletRequest request, HttpServletResponse response) {
        return new Rout(PagePath.SIGN_IN_PAGE, RoutingType.FORWARD);
    }
}
