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

<form action="${pageContext.request.contextPath}/controller?command=CONTINUE_BOOKING" method="POST">

    <input type="date" class="form-control" name="dateArrival"
           oninvalid="this.setCustomValidity('<fmt:message key="warning.mustfieled"/>')"
           onchange="this.setCustomValidity('')" required placeholder="<fmt:message key="booking.date-arrival"/>">
    <input type="date" class="form-control" name="dateDepartment"
           oninvalid="this.setCustomValidity('<fmt:message key="warning.mustfieled"/>')"
           onchange="this.setCustomValidity('')" required placeholder="<fmt:message key="booking.date-department"/>">

    <select name="typeOfComfort"
            oninvalid="this.setCustomValidity('<fmt:message key="warning.mustfieled"/>')"
            onchange="this.setCustomValidity('')" required placeholder="<fmt:message key="booking.type-of-comfort"/>">
        <option selected value="8"><fmt:message key="booking.standart"/></option>
        <option value="4"><fmt:message key="booking.family"/></option>
        <option value="2"><fmt:message key="booking.luxe"/></option>
        <option value="1"><fmt:message key="booking.suite"/></option>
    </select>

    <span>
        <fmt:message key= "booking.info-guests"/>
    </span>

    <select name="adults"
            oninvalid="this.setCustomValidity('<fmt:message key="warning.mustfieled"/>')"
            onchange="this.setCustomValidity('')" required placeholder="<fmt:message key="booking.adults"/>">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
    </select>

    <select name="child"
            oninvalid="this.setCustomValidity('<fmt:message key="warning.mustfieled"/>')"
            onchange="this.setCustomValidity('')" required placeholder="<fmt:message key="booking.child"/>">
        <option value="0">0</option>
        <option value="1">1</option>
    </select>

    <input type="submit" class="btn btn-primary" value="<fmt:message key="booking.btn-search"/>">
</form>

<jsp:include page="components/footer.jsp"/>


</body>
</html>
