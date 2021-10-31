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
<form action="${pageContext.request.contextPath}/controller?command=EDIT_PASSWORD"
      oninput='confirmPassword.setCustomValidity(confirmPassword.value != password.value ? "<fmt:message key="editpassword.not-match-password"/>" : "")' method="POST">
    <input type="password" class="form-control" name="oldPassword"
           oninvalid="this.setCustomValidity('<fmt:message key="warning.field-empty"/>')"
           onchange="this.setCustomValidity('')" required placeholder="<fmt:message key="editpassword.old-password"/>">
    <input type="password" class="form-control" name="password"
           oninvalid="this.setCustomValidity('<fmt:message key="warning.field-empty"/>')"
           onchange="this.setCustomValidity('')" required placeholder="<fmt:message key="editpassword.new-password"/>">
    <input type="password" class="form-control" name="confirmPassword" placeholder="<fmt:message key="editpassword.confirm-password"/>">

    <input type="submit" class="btn btn-primary" value="<fmt:message key="editpassword.btn-edit"/>">
</form>
</body>
</html>