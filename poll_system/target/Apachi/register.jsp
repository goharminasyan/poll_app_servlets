
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head> <link rel="stylesheet" href="../css/register.css">
<title>Register</title>
</head>
<body>
<div class="user">

    <header class="user__header">
        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/3219/logo.svg" alt="" />
        <h1 class="user__title" > Please fill in this form to create an account. </h1>
        </header>

    <form   class="form" method="post" action="/register">
       <div class="form__group">
        <input class="form__input"  type="text" placeholder="Name" name="name" id="name" required>
       </div>


        <div class="form__group">
        <input class="form__input" type="text" placeholder=" Lastname" name="lastname" id="lastname" required>
        </div>

        <div class="form__group">
        <input class="form__input"  type="text" placeholder="Age" name="age" id="age" required>
        </div>

        <div class="form__group">
        <input class="form__input"  type="text" placeholder="Email" name="email" id="email" required>
        </div>

        <div class="form__group">
        <input class="form__input"  type="text" placeholder="Enter Username" name="uname" id="uname" required>
       </div>

        <div class="form__group">
        <input class="form__input"  type="password" placeholder="Enter Password" name="password" id="password" required>
        </div>


        <button type="submit" class="btn" >Register</button>
    </form>
    </div>

</body>
</html>
