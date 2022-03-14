<%@ page import="com.epam.db.model.Question" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.db.model.Answer" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/6/2022
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="css/question.css">
    <title>Questions</title>
</head>
<body>
<form action="${getContext.request.contextPath}/results" method="get">

<c:forEach var="question" items="${question}">
<input type="hidden" name="questionId" value="${question.id}">

    <p class="question">
        <c:out  value="${question.getId()}"/>
        <c:out value="${question.getText()}"/>
    </p>

    <c:forEach var="answer" items="${answer}">
        <c:if var="question.getId" test="${ question.getId() == answer.getQuestion_id()}">

            <p class="answer">
                <input type="radio" name="marked${question.id}" value="${answer.getWeight()}">
            ${answer.getText()} ️
            </p>

        </c:if>
    </c:forEach>
        </c:forEach>

        <input type="submit" name="done" class="creat" value="Done"/>
    </form>


</body>
</html>
