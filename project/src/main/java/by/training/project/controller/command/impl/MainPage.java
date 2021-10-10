package by.training.project.controller.command.impl;

import by.training.project.beans.Hotel;
import by.training.project.controller.command.Command;
import by.training.project.controller.command.ErrorKey;
import by.training.project.controller.command.PagePath;
import by.training.project.controller.command.SessionAttribute;
import by.training.project.controller.command.rout.Rout;
import by.training.project.controller.command.rout.RoutingType;
import by.training.project.controller.exception.ControllerException;
import by.training.project.service.exception.ServiceException;
import by.training.project.service.reader.HotelReader;
import by.training.project.service.reader.ReaderFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MainPage implements Command {
    @Override
    public Rout execute(HttpServletRequest request, HttpServletResponse response){
        HotelReader hotelReader = ReaderFactory.getInstance().getHotelReader();
        try {
            List<Hotel> hotelList = hotelReader.readAll();
            request.setAttribute("hotelList",hotelList);
        } catch (ServiceException e) {
            request.getSession().setAttribute(SessionAttribute.ERROR, ErrorKey.ERROR_500);
            return new Rout(PagePath.ERROR_PAGE_REDIRECT, RoutingType.REDIRECT);
        }
        return new Rout(PagePath.MAIN_PAGE, RoutingType.FORWARD);
    }
}
