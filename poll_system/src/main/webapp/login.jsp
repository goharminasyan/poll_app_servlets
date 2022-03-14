<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="css/login.css">
    <title>Welcome to our page</title>
</head>
<body>

<header>
    <h1>Welcome to Poll App </h1>
</header>

<main>
    <form action="/login" method="post" class="form_class">
        <div class="form_div">
            <div style="color: #a81bb2; font-size: 20px">
                <c:if var="logout_error" test="${ logout_error != null}">
                    <p>${"You are successfully logged out!"}</p>
                </c:if>
            </div>

            <div style="color: red; font-size: 20px">
                <c:if var="error" test="${ error != null}">
                    <p>${"Something wrong"}</p>
                </c:if>
            </div>

            <div style="color: #a81bb2; font-size: 20px">
                <c:if var="registerMessage"
                      test="${ registerMessage != null}">
                    <p>${"You have successfully registered!"}</p>
                </c:if>
            </div>

            <br>
            <label><b> Login </b></label>
            <input class="field_class" type="text" placeholder="Enter email" name="email">
            <br>
            <label><b>Password</b></label>
            <input class="field_class" type="password" placeholder="Enter Password" name="password">
            <br>
            <label>
                <input type="checkbox" checked="checked" name="remember"> Remember me
            </label>

            <input class="submit_class" type="submit" value="Log In"/>

           <br>
    </form>

    <form action="register.jsp" method="post" >
        <input type="submit" class="creat" value="SIGN UP"/>
    </form>
    </div>

</main>
</body>
</html>
