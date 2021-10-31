package by.training.project.controller.command.impl;

import by.training.project.beans.Booking;
import by.training.project.beans.Room;
import by.training.project.controller.command.*;
import by.training.project.controller.command.rout.Rout;
import by.training.project.controller.command.rout.RoutingType;
import by.training.project.service.ServiceFactory;
import by.training.project.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Optional;

public class ContinueBooking implements Command {
    @Override
    public Rout execute(HttpServletRequest request, HttpServletResponse response) {
        Optional<Integer> userId = Optional.ofNullable((Integer) request.getSession().getAttribute(SessionAttribute.USER_ID));
        Optional<Integer> hotelId = Optional.ofNullable((Integer) request.getSession().getAttribute(SessionAttribute.HOTEL_ID));
        Optional<String> dateArrival = Optional.ofNullable(request.getParameter(RequestParameter.DATE_ARRIVAL));
        Optional<String> dateDepartment = Optional.ofNullable(request.getParameter(RequestParameter.DATE_DEPARTMENT));
        Optional<String> typeOfComfort = Optional.ofNullable(request.getParameter(RequestParameter.TYPE_OF_COMFORT));
        Optional<String> adults = Optional.of(request.getParameter(RequestParameter.ADULTS));
        Optional<String> child = Optional.of(request.getParameter(RequestParameter.CHILD));

        if (userId.isEmpty() || hotelId.isEmpty() || dateArrival.isEmpty() || dateDepartment.isEmpty()
                || typeOfComfort.isEmpty() || adults.isEmpty() || child.isEmpty()){
            request.getSession().setAttribute(SessionAttribute.ERROR, ErrorKey.INVALID_DATA);
            return new Rout(PagePath.ERROR_PAGE_REDIRECT, RoutingType.REDIRECT);
        }

        UserService userService = ServiceFactory.getInstance().getUserService();

        if (userService.booking()){
            return new Rout(PagePath.MAIL_CHECK_REDIRECT, RoutingType.REDIRECT);
        } else {
            request.getSession().setAttribute(SessionAttribute.ERROR, ErrorKey.ERROR_DONT_REGISTRATION);
            return new Rout(PagePath.ERROR_PAGE_REDIRECT, RoutingType.REDIRECT);
        }

    }

    private Booking buildBooking(Integer userId, Integer hotelId, Date dateArrival, Date dateDepartment) {
        // search Booking List by Room and typeAllocation
    }

    private Room buildRoom (Integer userId, Integer hotelId, Integer typeAllocation, Integer typeOfComfort) {
        // search Room List by HotelId and typeAllocation
    }
}
