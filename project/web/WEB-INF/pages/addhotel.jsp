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
<form action="${pageContext.request.contextPath}/controller?command=ADD_HOTEL" method="POST">
    <input type="text" class="form-control" name="name"
           oninvalid="this.setCustomValidity('<fmt:message key="warning.field-empty"/>')"
           onchange="this.setCustomValidity('')" required placeholder="<fmt:message key="addhotel.name"/>">

    <fmt:message key="addhotel.stars"/> <select name="stars"
            oninvalid="this.setCustomValidity('<fmt:message key="warning.mustfieled"/>')"
            onchange="this.setCustomValidity('')" required>
        <option selected value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
    </select>

    <div class="checkbox-group-type-food required">
        <input type="checkbox" id="no" name="typeFood" value="16">
        <label for="no">no</label>
        <input type="checkbox" id="breakfast" name="typeFood" value="8">
        <label for="breakfast">breakfast</label>
        <input type="checkbox" id="halfBoard" name="typeFood" value="4">
        <label for="halfBoard">halfBoard</label>
        <input type="checkbox" id="fullBoard" name="typeFood" value="2">
        <label for="fullBoard">fullBoard</label>
        <input type="checkbox" id="all" name="typeFood" value="1">
        <label for="all">all</label>
    </div>

    <div class="checkbox-group-type-allocation required">
        <input type="checkbox" id="single" name="typeAllocation" value="16">
        <label for="single">single</label>
        <input type="checkbox" id="double" name="typeAllocation" value="8">
        <label for="double">double</label>
        <input type="checkbox" id="triple" name="typeAllocation" value="4">
        <label for="triple">triple</label>
        <input type="checkbox" id="extra" name="typeAllocation" value="2">
        <label for="extra">extra</label>
        <input type="checkbox" id="child" name="typeAllocation" value="1">
        <label for="child">child</label>
    </div>

    <div class="checkbox-group-type-comfort required">
        <input type="checkbox" id="standard" name="typeComfort" value="8">
        <label for="standard">standard</label>
        <input type="checkbox" id="family" name="typeComfort" value="4">
        <label for="family">family</label>
        <input type="checkbox" id="luxe" name="typeComfort" value="2">
        <label for="luxe">luxe</label>
        <input type="checkbox" id="suite" name="typeComfort" value="1">
        <label for="suite">suite</label>
    </div>

    <input type="text" class="form-control" name="priceSingle"
            placeholder="price-single">
    <input type="text" class="form-control" name="priceDouble"
           placeholder="price-double">
    <input type="text" class="form-control" name="priceTriple"
           placeholder="price-triple">
    <input type="text" class="form-control" name="priceExtra"
           placeholder="price-extra">
    <input type="text" class="form-control" name="priceChild"
           placeholder="price-child">

    <input type="text" class="form-control" name="priceFamily"
           placeholder="price-family">
    <input type="text" class="form-control" name="priceLuxe"
           placeholder="price-luxe">
    <input type="text" class="form-control" name="priceSuite"
           placeholder="price-suite">

    <input type="text" class="form-control" name="reward"
           placeholder="reward">

    <div class="checkbox-group-facilities required">
        <input type="checkbox" id="parking" name="facilities" value="8">
        <label for="parking">parking</label>
        <input type="checkbox" id="wifi" name="facilities" value="4">
        <label for="wifi">wifi</label>
        <input type="checkbox" id="pets" name="facilities" value="2">
        <label for="pets">pets</label>
        <input type="checkbox" id="businessCenter" name="facilities" value="1">
        <label for="businessCenter">businessCenter</label>
    </div>

    <jsp:include page="components/selectcountry.jsp"/>

    <input type="text" class="form-control" name="city"
           oninvalid="this.setCustomValidity('<fmt:message key="warning.field-empty"/>')"
           onchange="this.setCustomValidity('')" required placeholder="city">

    <input type="text" class="form-control" name="house"
           placeholder="house">

    <input type="text" class="form-control" name="building"
           placeholder="building">

    <input type="submit" class="btn btn-primary" value="<fmt:message key="addhotel.add"/>">
</form>

<jsp:include page="components/footer.jsp"/>
</body>
</html>
