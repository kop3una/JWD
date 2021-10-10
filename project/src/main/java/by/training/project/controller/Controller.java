package by.training.project.controller;

import by.training.project.controller.command.*;
import by.training.project.controller.command.rout.Rout;
import by.training.project.dao.exception.DaoException;
import by.training.project.dao.pool.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/controller")
public class Controller extends HttpServlet {
    private static final CommandProvider commandProvider = new CommandProvider();

    public Controller() {
        super();
    }

    @Override
    public void init() throws ServletException { // TODO exepction;
        try {
            ConnectionPool.getInstance().init();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processCommand(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processCommand(request, response);
    }

    private static void processCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<String> commandName = Optional.ofNullable(request.getParameter(RequestParameter.COMMAND));
        if (commandName.isPresent()) {// TODO question about NullPointerException
            Command command = commandProvider.getCommand(commandName.get());
            Rout rout = command.execute(request, response);

            String pathToResource = rout.getPathToResource();
            switch (rout.getRoutingType()) {
                case FORWARD:
                    request.getRequestDispatcher(pathToResource).forward(request, response);
                    break;
                case REDIRECT:
                    response.sendRedirect(request.getContextPath() + pathToResource);
                    break;
            }
        } else {
            request.getSession().setAttribute(SessionAttribute.ERROR,ErrorKey.ERROR_404);
            request.getRequestDispatcher(PagePath.ERROR_PAGE).forward(request, response);
        }
    }
}