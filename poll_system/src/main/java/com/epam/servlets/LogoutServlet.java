package com.epam.servlets;


import java.io.IOException;


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
