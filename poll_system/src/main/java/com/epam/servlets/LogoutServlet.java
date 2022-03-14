package com.epam.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

@WebServlet(urlPatterns ="/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session=req.getSession(false);
        if(session!= null){
        session.invalidate();
        req.setAttribute("logout_error", "You are successfully logged out!");
        }
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
}
