package com.epam.servlets;

import com.epam.db.model.Users;
import com.epam.db.service.UserService;
import com.epam.db.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class UserLogInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        Users users = new Users();

        String email = req.getParameter("email");
        String password = req.getParameter("password");


        users.setEmail(email);
        users.setPassword(password);

        Users user = (Users) userService.getByEmailAndPass(email, password);
        HttpSession session = req.getSession(true);

        session.setAttribute("email", req.getParameter("email"));
        session.setAttribute("password", req.getParameter("password"));

        if (!userService.existEmailAndPass(email, password)) {
            req.setAttribute("error", "Something wrong");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            session.setAttribute("user", user);
            resp.sendRedirect("/home.jsp");
        }
    }
}