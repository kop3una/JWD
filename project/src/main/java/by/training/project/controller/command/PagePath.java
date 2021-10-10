package by.training.project.controller.command;

public final class PagePath {
    public static final String MAIN_PAGE = "WEB-INF/pages/main.jsp";
    public static final String MAIN_PAGE_REDIRECT = "/controller?command=MAIN";

    public static final String SIGN_IN_PAGE = "WEB-INF/pages/signin.jsp";
    public static final String SIGN_IN_PAGE_REDIRECT = "/controller?command=SHOW_SIGN_IN";

    public static final String ERROR_PAGE = "WEB-INF/pages/error.jsp";
    public static final String ERROR_PAGE_REDIRECT = "/controller?command=SHOW_ERROR_PAGE";

    public static final String SIGN_UP_PAGE = "WEB-INF/pages/signup.jsp";

    private PagePath(){};
}
