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

<div class="container mt-5">
    <table class="table table-bordered">
        <tbody>
        <c:forEach var="hotel" items="${requestScope.entityList}">
            <tr>
                <th class="col-sm-10">
                    <p>${hotel.name} ${hotel.stars}&#9733; ${hotel.getAddress().getFullAddress()}
                        <fmt:message key="main.hotel-standart-price"/>${hotel.getPrices().getStandartPrice()}&#36;
                        <c:if test="${sessionScope.role.value == initParam['TOUROPERATOR'] && sessionScope.role != null}">
                            ${sessionScope.role}
                            <fmt:message key="main.touroperator-reward"/>${hotel.getPrices().getRewardTourOperator()}&#37;
                        </c:if>
                    </p>
                    <p>
                        <fmt:message key="main.type-of-comfort"/>${hotel.getFacilities().getStrValTypeComfort()}
                        <fmt:message key="main.type-of-food"/>${hotel.getFacilities().getStrValTypeFood()}
                        <fmt:message key="main.type-of-allocation"/>${hotel.getFacilities().getStrValTypeAllocation()}
                    </p>
                    <p>
                        <fmt:message key="main.add-facilities"/>${hotel.getFacilities().getStrValAddFacilities()}
                    </p>
                </th>
                <th class="col-sm-2">
                    <a role="button" class="btn btn-outline-primary"
                       href="${pageContext.request.contextPath}/controller?command=SHOW_BOOKING&hotelId=${hotel.id}"><fmt:message
                            key="main.booking"/></a>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <ul class="pagination">

        <%--        if not to many pages        --%>
        <c:if test="${requestScope.countAllEntities <= initParam['maxCountPagination']*initParam['paginationCountEntityOnPage']}">
            <c:forEach var="i" begin="1" end="${requestScope.countPage}" step="1">
                <c:choose>
                    <c:when test="${i == requestScope.currentPage}">
                        <li class="page-item active" aria-current="page">
                            <a class="page-link"
                               href="${pageContext.request.contextPath}/controller?command=MAIN&pageMainPagination=${i}">${i}</a>
                        </li>
                    </c:when>
                    <c:when test="${i != requestScope.currentPage}">
                        <li class="page-item">
                            <a class="page-link"
                               href="${pageContext.request.contextPath}/controller?command=MAIN&pageMainPagination=${i}">${i}</a>
                        </li>
                    </c:when>
                </c:choose>
            </c:forEach>
        </c:if>

        <%--        if too many pages--%>
        <c:if test="${requestScope.countAllEntities > initParam['maxCountPagination']*initParam['paginationCountEntityOnPage']}">

            <c:if test="${requestScope.currentPage>1}">
                <li class="page-item">
                    <a class="page-link"
                       href="${pageContext.request.contextPath}/controller?command=MAIN&pageMainPagination=${requestScope.currentPage-1}">&laquo;</a>
                </li>
            </c:if>

            <c:if test="${requestScope.currentPage+initParam['maxCountPagination']<requestScope.countPage}">
                <c:forEach var="i" begin="${requestScope.currentPage}"
                           end="${requestScope.currentPage+initParam['maxCountPagination']-2}" step="1">
                    <c:choose>
                        <c:when test="${i == requestScope.currentPage}">
                            <li class="page-item active" aria-current="page">
                                <a class="page-link"
                                   href="${pageContext.request.contextPath}/controller?command=MAIN&pageMainPagination=${i}">${i}</a>
                            </li>
                        </c:when>
                        <c:when test="${i != requestScope.currentPage}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="${pageContext.request.contextPath}/controller?command=MAIN&pageMainPagination=${i}">${i}</a>
                            </li>
                        </c:when>
                    </c:choose>
                </c:forEach>
                <li class="page-item">
                    <a class="page-link" href="">...</a>
                </li>
                <li class="page-item">
                    <a class="page-link"
                       href="${pageContext.request.contextPath}/controller?command=MAIN&pageMainPagination=${requestScope.countPage}">${requestScope.countPage}</a>
                </li>
            </c:if>

            <c:if test="${requestScope.currentPage+initParam['maxCountPagination']>=requestScope.countPage}">
                <c:forEach var="i" begin="${requestScope.countPage-initParam['maxCountPagination']}"
                           end="${requestScope.countPage}" step="1">
                    <c:choose>
                        <c:when test="${i == requestScope.currentPage}">
                            <li class="page-item active" aria-current="page">
                                <a class="page-link"
                                   href="${pageContext.request.contextPath}/controller?command=MAIN&pageMainPagination=${i}">${i}</a>
                            </li>
                        </c:when>
                        <c:when test="${i != requestScope.currentPage}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="${pageContext.request.contextPath}/controller?command=MAIN&pageMainPagination=${i}">${i}</a>
                            </li>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </c:if>

            <c:if test="${requestScope.currentPage<requestScope.countPage}">
                <li class="page-item">
                    <a class="page-link"
                       href="${pageContext.request.contextPath}/controller?command=MAIN&pageMainPagination=${requestScope.currentPage+1}">&raquo;</a>
                </li>
            </c:if>

        </c:if>
    </ul>

</div>

<jsp:include page="components/footer.jsp"/>

</body>
</html>
