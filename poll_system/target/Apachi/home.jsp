<%@ page import="com.epam.db.model.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="css/home.css">
    <title>Home</title>
</head>
<body class="user__header">

<img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/3219/logo.svg" alt="" />
<%--<%Users user = (Users) request.getAttribute("user");%>--%>
<div class="error"  >
    <c:if var="poll_error" test="${ poll_error != null}">
        <p style="font-size: 30px; color: #a81bb2" >${"You can take the test again in less than a week!"}</p>
    </c:if>
</div>

<h2 class="user__title"> User name: ${sessionScope.user.name}</h2>
<h2 class="user__title"> User lastname: ${sessionScope.user.lastName}</h2>
<h2 class="user__title">User age: ${sessionScope.user.age}</h2>
<%--<h2 class="user__title">Last time when you participated in the poll: ${sessionScope.user.result_date}</h2>--%>

<form action="/poll" method="get"  >
    <input class="submit" type="submit"  value="Polls" />
</form>
    <form action="/logout" method="post"  >
        <input class="submit" type="submit"  value="Log out" />
    </form>

</body>
</html>