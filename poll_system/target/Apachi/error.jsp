<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/13/2022
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/error.css">
    <title>Oops!!</title>
</head>
<body>
<img src="https://cdni.iconscout.com/illustration/premium/thumb/opps-4344463-3613891.png">

<div class="error"  >
    <c:if var="error" test="${ error != null}">
        <p>${"You have not filled in all the fields"}</p>
        <form action="<%= request.getContextPath() %>/poll" method="get"  >
            <input class="submit" type="submit"  value="Polls" />
        </form>
    </c:if>
</div>

</body>
</html>
