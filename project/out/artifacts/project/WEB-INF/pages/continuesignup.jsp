<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.training.project.beans.Role" %>
<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : initParam['defaultLocale']}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <jsp:include page="components/head-tags.jsp"/>
    <title><fmt:message key="signup.name-of-Web-Site"/></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/controller?command=CONTINUE_SIGN_UP" method="POST">
    <input type="text" class="form-control" name="name"
           oninvalid="this.setCustomValidity('<fmt:message key="warning.mustfieled"/>')"
           onchange="this.setCustomValidity('')" required placeholder="<fmt:message key="signup.name"/>">
    <input type="text" class="form-control" name="surname"
           oninvalid="this.setCustomValidity('<fmt:message key="warning.mustfieled"/>')"
           onchange="this.setCustomValidity('')" required placeholder="<fmt:message key="signup.surname"/>">
    <input type="text" class="form-control" name="middleName"
           oninvalid="this.setCustomValidity('<fmt:message key="warning.mustfieled"/>')"
           onchange="this.setCustomValidity('')" placeholder="<fmt:message key="signup.middle-name"/>">
    <input type="tel" class="form-control" name="phone"
           oninvalid="this.setCustomValidity('<fmt:message key="warning.mustfieled"/>')"
           onchange="this.setCustomValidity('')" required placeholder="<fmt:message key="signup.phone"/>">
    <input type="text" class="form-control" name="passport"
           oninvalid="this.setCustomValidity('<fmt:message key="warning.passport"/>')"
           onchange="this.setCustomValidity('')" pattern="[A-Z]{2}[0-9]{7}" required placeholder="<fmt:message key="signup.passport"/>">
    <input type="date" class="form-control" name="dateOfBirthday"
           oninvalid="this.setCustomValidity('<fmt:message key="warning.mustfieled"/>')"
           onchange="this.setCustomValidity('')" required placeholder="<fmt:message key="signup.date-of-birthday"/>">
    <jsp:include page="components/selectcountry.jsp"/>

    <c:if test="${sessionScope.signUpRole == Role.TOUROPERATOR.name()}">
        <input type="text" class="form-control" name="tourOrg"
               oninvalid="this.setCustomValidity('<fmt:message key="warning.mustfieled"/>')"
               onchange="this.setCustomValidity('')" required placeholder="<fmt:message key="signup.tourorganization"/>">
        <input type="text" class="form-control" name="licence"
               oninvalid="this.setCustomValidity('<fmt:message key="warning.mustfieled"/>')"
               onchange="this.setCustomValidity('')" required placeholder="<fmt:message key="signup.licence"/>">
    </c:if>
    
    <div class="form-check-inline">
        <span><fmt:message key="signup.sex"/></span>
        <label class="form-check-label">
            <input type="radio" class="form-check-input" name="gender" checked value="man"><fmt:message key="signup.man"/>
        </label>
        <label class="form-check-label">
            <input type="radio" class="form-check-input" name="gender" value="woman"><fmt:message key="signup.woman"/>
        </label>
    </div>

    <input type="submit" class="btn btn-primary" value="<fmt:message key="signup.btn-registration"/>">
</form>

<jsp:include page="components/footer.jsp"/>
</body>
</html>
