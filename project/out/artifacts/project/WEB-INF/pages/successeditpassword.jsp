<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : initParam['defaultLocale']}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <jsp:include page="components/head-tags.jsp"/>
    <title><fmt:message key="main.name-of-Web-Site"/></title>
</head>
<body>
<div class="container">
    <h1 class="text-center">
        <fmt:message key="successeditpassword.success-edit"/>
    </h1>
    <div>
        <a href="${pageContext.request.contextPath}/controller?command=MAIN" class="btn btn-primary btn-lg mt-5">
            <fmt:message key="return-main"/>
        </a>
    </div>
</div>

<jsp:include page="components/footer.jsp"/>

</body>
</html>
