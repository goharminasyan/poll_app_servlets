package com.epam.servlets;

import com.epam.db.model.Users;
import com.epam.db.service.UserService;
import com.epam.db.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/register")
public class UserRegisterServlet extends HttpServlet {
    private Users user = new Users();
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        int age = Integer.parseInt(req.getParameter("age"));
        String uname = req.getParameter("uname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        user.setName(name);
        user.setLastName(lastname);
        user.setAge(age);
        user.setUserName(uname);
        user.setEmail(email);
        user.setPassword(password);
        userService.create(user);
        req.setAttribute("registerMessage", "You have successfully registered!");
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }


}
