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
    <table border="2" cellpadding="30" cellspacing="0">
        <thead>
        <tr>
            <th>Restaurant</th>
            <th>Votes</th>
        </tr>
        </thead>
        <%--<c:forEach items="${voteList}" var="vote">--%>
            <%--&lt;%&ndash;<jsp:useBean id="vote" scope="page" type="com.projects.votingsystem.model.Vote"/>&ndash;%&gt;--%>
            <%--<tr>--%>
                <%--<td>${vote.key.name}</td>--%>
                <%--<td>${vote.value}</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
        <c:forEach items="${voteList}" var="vote" varStatus="status">
            <tr>
                <td>${vote.key.name}</td>
                <td>${vote.value}</td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
