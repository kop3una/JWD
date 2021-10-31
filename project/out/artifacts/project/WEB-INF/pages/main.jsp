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
        <c:forEach var="hotel" items="${requestScope.hotelList}">
            <tr>
                <th class="col-sm-10">
                    <p>${hotel.name}</p>
                </th>
                <th class="col-sm-2">
                    <a role="button" class="btn btn-outline-primary"
                       href="${pageContext.request.contextPath}/controller?command=SHOW_BOOKING"><fmt:message
                            key="main.booking"/></a>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <ul class="pagination">

        <c:if test="${requestScope.countHotels <= initParam['maxCountPagination']*initParam['paginationCountHotelOnPage']}">
            <c:forEach var="i" begin="1" end="${requestScope.countPage}" step="1">
                <c:choose>
                    <c:when test="${i == requestScope.page}">
                        <li class="page-item active" aria-current="page">
                            <a class="page-link" href="${pageContext.request.contextPath}/controller?command=MAIN&pagePagination=${i}">${i}</a>
                        </li>
                    </c:when>
                    <c:when test="${i != requestScope.page}">
                        <li class="page-item">
                            <a class="page-link" href="${pageContext.request.contextPath}/controller?command=MAIN&pagePagination=${i}">${i}</a>
                        </li>
                    </c:when>
                </c:choose>
            </c:forEach>
        </c:if>


        <c:if test="${requestScope.countHotels > initParam['maxCountPagination']*initParam['paginationCountHotelOnPage']}">

            <c:if test="${requestScope.page>1}">
                <li class="page-item">
                    <a class="page-link" href="${pageContext.request.contextPath}/controller?command=MAIN&pagePagination=${requestScope.page-1}">&laquo;</a>
                </li>
            </c:if>

            <c:if test="${requestScope.page+initParam['maxCountPagination']<requestScope.countPage}">
                <c:forEach var="i" begin="${requestScope.page}" end="${requestScope.page+initParam['maxCountPagination']-2}" step="1">
                    <c:choose>
                        <c:when test="${i == requestScope.page}">
                            <li class="page-item active" aria-current="page">
                                <a class="page-link" href="${pageContext.request.contextPath}/controller?command=MAIN&pagePagination=${i}">${i}</a>
                            </li>
                        </c:when>
                        <c:when test="${i != requestScope.page}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/controller?command=MAIN&pagePagination=${i}">${i}</a>
                            </li>
                        </c:when>
                    </c:choose>
                </c:forEach>
                <li class="page-item">
                    <a class="page-link" href="">...</a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="${pageContext.request.contextPath}/controller?command=MAIN&pagePagination=${requestScope.countPage}">${requestScope.countPage}</a>
                </li>
            </c:if>

            <c:if test="${requestScope.page+initParam['maxCountPagination']>=requestScope.countPage}">
                <c:forEach var="i" begin="${requestScope.countPage-initParam['maxCountPagination']}" end="${requestScope.countPage}" step="1">
                    <c:choose>
                        <c:when test="${i == requestScope.page}">
                            <li class="page-item active" aria-current="page">
                                <a class="page-link" href="${pageContext.request.contextPath}/controller?command=MAIN&pagePagination=${i}">${i}</a>
                            </li>
                        </c:when>
                        <c:when test="${i != requestScope.page}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/controller?command=MAIN&pagePagination=${i}">${i}</a>
                            </li>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </c:if>

            <c:if test="${requestScope.page<requestScope.countPage}">
                <li class="page-item">
                    <a class="page-link" href="${pageContext.request.contextPath}/controller?command=MAIN&pagePagination=${requestScope.page+1}">&raquo;</a>
                </li>
            </c:if>

        </c:if>
    </ul>
    <%--        <li class="page-item">--%>
    <%--            <a class="page-link" href="#" tabindex="-1">&laquo;</a>--%>
    <%--        </li>--%>
    <%--        <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
    <%--        <li class="page-item active" aria-current="page">--%>
    <%--            <a class="page-link" href="#">2</a>--%>
    <%--        </li>--%>
    <%--        <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
    <%--        <li class="page-item">--%>
    <%--            <a class="page-link" href="#">&raquo;</a>--%>
    <%--        </li>--%>
    <%--    </ul>--%>
    <%--    <script src="js/pagination.js"></script>--%>
</div>

<jsp:include page="components/footer.jsp"/>
</body>
</html>
