<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : initParam['defaultLocale']}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <jsp:include page="components/head-tags.jsp"/>
    <title><fmt:message key="main.name-of-Web-Site"/></title>
</head>
<body>
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
                </div>
                <a role="button" class="btn btn-outline-primary"
                   href="${pageContext.request.contextPath}/controller?command=SHOW_SIGN_UP"><fmt:message
                        key="main.signup"/></a>
                <a role="button" class="btn btn-outline-primary"
                   href="${pageContext.request.contextPath}/controller?command=SHOW_SIGN_IN"><fmt:message
                        key="main.signin"/></a>
            </div>
        </div>
    </div>
</header>

<div class="container mt-5">
        <table class="table table-bordered">
            <tbody>
            <c:forEach var="hotel" items="${requestScope.hotelList}">
                <tr>
                    <th class="col-sm-10">
                        <p>${hotel.name}</p>
                    </th>
                    <th class="col-sm-2">
                        <a role="button" class="btn btn-outline-primary"
                           href="${pageContext.request.contextPath}/controller?command=MAIN"><fmt:message
                                key="main.booking"/></a>
                    </th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
</div>

<jsp:include page="components/footer.jsp"/>
</body>
</html>
