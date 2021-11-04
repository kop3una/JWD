<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : initParam['defaultLocale']}"/>
<fmt:setBundle basename="resources"/>
<header class="header">
    <div class="container">
        <div class="row">
            <div class="col-sm-4" id="header_name"><fmt:message key="main.name-of-Web-Site"/></div>
            <div class="col-sm-8" id="header_menu">
                <div class="d-inline-flex">
                    <div class="dropdown">
                        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                            ${sessionScope.locale}
                        </button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item"
                               href="${pageContext.request.contextPath}/controller?${pageContext.request.queryString}&locale=ru">RU</a>
                            <a class="dropdown-item"
                               href="${pageContext.request.contextPath}/controller?${pageContext.request.queryString}&locale=be">BY</a>
                            <a class="dropdown-item"
                               href="${pageContext.request.contextPath}/controller?${pageContext.request.queryString}&locale=en">EN</a>
                            <a class="dropdown-item"
                               href="${pageContext.request.contextPath}/controller?${pageContext.request.queryString}&locale=de">DE</a>
                        </div>
                    </div>
                    <c:if test="${sessionScope.userId != null}">
                        <div class="dropdown">
                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                                    ${sessionScope.userName}
                            </button>
                            <div class="dropdown-menu">
                                <a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/controller?command=SHOW_EDIT"><fmt:message key="user.edit"/></a>
                                <a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/controller?command=SHOW_PERSONAL_AREA"><fmt:message key="user.personal-area"/></a>
                                <a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/controller?command=LOG_OUT"><fmt:message key="user.logout"/></a>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${sessionScope.userId == null}">
                        <a role="button" class="btn btn-outline-primary"
                           href="${pageContext.request.contextPath}/controller?command=SHOW_SIGN_UP"><fmt:message
                                key="main.signup"/></a>
                        <a role="button" class="btn btn-outline-primary"
                           href="${pageContext.request.contextPath}/controller?command=SHOW_SIGN_IN"><fmt:message
                                key="main.signin"/></a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</header>
