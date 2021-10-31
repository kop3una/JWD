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

<jsp:include page="components/header.jsp"/>




</body>
</html>
