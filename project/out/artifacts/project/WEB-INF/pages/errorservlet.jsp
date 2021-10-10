<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : initParam['defaultLocale']}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <jsp:include page="components/head-tags.jsp"/>
    <title><fmt:message key="error.name-of-Web-Site"/></title>
</head>

<body>
<div class="container">
    <h1 class="text-center">
        <fmt:message key="error.servlet-not-created"/>
    </h1>
</div>

<jsp:include page="components/footer.jsp"/>

</body>
</html>