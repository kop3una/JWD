<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'ru'}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <%@ include file="components/head-tags.jsp" %>
    <title><fmt:message key="error.name-of-Web-Site"/></title>
</head>
<body>
<div class="container">
    <h1 class="text-center">
        <fmt:message key="${sessionScope.error}"/>
    </h1>
    <div>
        <a href="${pageContext.request.contextPath}/controller?command=MAIN" class="btn btn-primary btn-lg mt-5">
            <fmt:message key="error.return-main"/>
        </a>
    </div>
</div>
</body>
</html>
