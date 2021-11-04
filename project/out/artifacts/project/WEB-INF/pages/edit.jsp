<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : initParam['defaultLocale']}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <jsp:include page="components/head-tags.jsp"/>
    <title><fmt:message key="edit.name-of-Web-Site"/></title>
</head>
<body>
<div class="container">
    <a role="button" class="btn btn-primary btn-lg mt-5"
       href="${pageContext.request.contextPath}/controller?command=SHOW_EDIT_PASSWORD"><fmt:message
            key="edit.password"/></a>
    <a role="button" class="btn btn-primary btn-lg mt-5"
       href="${pageContext.request.contextPath}/controller?command=EDIT_INFO"><fmt:message
            key="edit.profile"/></a>

    <c:if test="${sessionScope.role.value == initParam['ADMINISTRATOR'] && sessionScope.role != null}">
        <a role="button" class="btn btn-primary btn-lg mt-5"
           href="${pageContext.request.contextPath}/controller?command=SHOW_ADD_HOTEL"><fmt:message
                key="edit.add-hotel"/></a>
    </c:if>

    <a href="${pageContext.request.contextPath}/controller?command=MAIN" class="btn btn-primary btn-lg mt-5">
        <fmt:message key="return-main"/>
    </a>
</div>
</body>
</html>
