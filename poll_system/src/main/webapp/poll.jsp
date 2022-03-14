<%@ page import="com.epam.db.model.Poll" %>
<%@ page import="com.epam.servlets.PollServlet" %>
<%@ page import="com.epam.db.service.PollServiceImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/5/2022
  Time: 10:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="css/poll.css">

    <title>Poll Selection</title>
</head>
<body>

<c:forEach var="poll" items="${poll}">
    <img src="${poll.getImg_url()}" alt="img" style="width: 100%", height="150">
    <a href="/question?id=${poll.getId()}" class="title">
        <c:out value="${poll.getName()}"/> </a>

    <p class="description">
        <c:out value="${poll.getDescription()}"/></p>

    <form action="" method="get">

    </form>
</c:forEach>

</body>
</html>
