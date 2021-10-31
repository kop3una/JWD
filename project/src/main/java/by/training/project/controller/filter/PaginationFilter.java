package by.training.project.controller.filter;

import by.training.project.controller.command.RequestParameter;
import by.training.project.controller.command.SessionAttribute;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@WebFilter( urlPatterns = "/*")
public class PaginationFilter implements Filter {
    private static final String DEFAULT_PAGE = "defaultPage";
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if (session.getAttribute(SessionAttribute.PAGE) == null || request.getSession().getAttribute(SessionAttribute.PAGE).equals("")) {
            session.setAttribute(SessionAttribute.PAGE, request.getServletContext().getInitParameter(DEFAULT_PAGE));
        }

        Optional<String> requestedPage = Optional.ofNullable(request.getParameter(RequestParameter.PAGE_PAGINATION));
        if (requestedPage.isPresent()) {
            session.setAttribute(SessionAttribute.PAGE, requestedPage.get());
            String requestString = removeLocaleParameter(request);
            response.sendRedirect(requestString);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String removeLocaleParameter(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        StringBuilder requestString = new StringBuilder(request.getContextPath() + "/controller?");
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            if (!entry.getKey().equals(RequestParameter.PAGE_PAGINATION)){
                requestString.append(entry.getKey()).append("=").append(entry.getValue()[0]).append("&");
            }
        }
        requestString.deleteCharAt(requestString.length()-1);
        return requestString.toString();
    }
}
