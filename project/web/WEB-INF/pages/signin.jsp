<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : initParam['defaultLocale']}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <jsp:include page="components/head-tags.jsp"/>
    <title><fmt:message key="singin.name-of-Web-Site"/></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/controller?command=LOG_IN" method="POST">
    <input type="email" class="form-control" name="email"
           oninvalid="this.setCustomValidity('<fmt:message key="warning.email"/>')"
           onchange="this.setCustomValidity('')" required placeholder="<fmt:message key="signin.email"/>">
    <input type="password" class="form-control" name="password"
           oninvalid="this.setCustomValidity('<fmt:message key="warning.field-empty"/>')"
           onchange="this.setCustomValidity('')" required placeholder="<fmt:message key="signin.password"/>">
    <input type="submit" class="btn btn-primary" value="<fmt:message key="signin.log-in"/>">
</form>

<jsp:include page="components/footer.jsp"/>
</body>
</html>


