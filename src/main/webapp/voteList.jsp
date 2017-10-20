<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Votes</title>
</head>
<body>
<h2>Vote List</h2>

<section>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Restaurant</th>
            <th>Votes</th>
        </tr>
        </thead>
        <%--<tr>--%>
        <%--${voteList.restaurant.name}--%>
        <%--</tr>--%>
        <c:forEach items="${voteList}" var="vote">
            <c:forEach items="${restList}" var="rest">
                <jsp:useBean id="vote" scope="page" type="com.projects.votingsystem.model.Vote"/>
                <jsp:useBean id="rest" scope="page" type="com.projects.votingsystem.model.Restaurant"/>
                <tr>
                    <td>${rest.name}</td>
                    <td>${vote.restaurant.name}</td>
                </tr>
            </c:forEach>
        </c:forEach>
    </table>
</section>
</body>
</html>
