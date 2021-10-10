<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : initParam['defaultLocale']}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <jsp:include page="components/head-tags.jsp"/>
    <title><fmt:message key="signup.name-of-Web-Site"/></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/controller?command=SIGN_UP"
      oninput='confirmPassword.setCustomValidity(confirmPassword.value != password.value ? "<fmt:message key="signup.not-match-password"/>" : "")' method="POST">
    <input type="email" class="form-control" name="email"
           oninvalid="this.setCustomValidity('<fmt:message key="warning.email"/>')"
           onchange="this.setCustomValidity('')" required placeholder="<fmt:message key="signup.email"/>">
    <input type="password" class="form-control" name="password"
           oninvalid="this.setCustomValidity('<fmt:message key="warning.field-empty"/>')"
           onchange="this.setCustomValidity('')" required placeholder="<fmt:message key="signup.password"/>">
    <input type="password" class="form-control" name="confirmPassword" placeholder="<fmt:message key="signup.confirm-password"/>">

    <div class="form-check-inline">
        <label class="form-check-label">
            <input type="radio" class="form-check-input" name="role" value="ADMINISTRATOR"><fmt:message key="signup.role-administrator"/>
        </label>
        <label class="form-check-label">
            <input type="radio" class="form-check-input" name="role" value="TOUROPERATOR"><fmt:message key="signup.role-touroperator"/>
        </label>
        <label class="form-check-label">
            <input type="radio" class="form-check-input" name="role" value="CLIENT" checked><fmt:message key="signup.role-client"/>
        </label>
    </div>

    <input type="submit" class="btn btn-primary" value="<fmt:message key="signup.btn-registration"/>">
</form>

<jsp:include page="components/footer.jsp"/>
</body>
</html>
