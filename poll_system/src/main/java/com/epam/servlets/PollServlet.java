package com.epam.servlets;

import com.epam.db.model.Users;
import com.epam.db.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@WebServlet(urlPatterns = "/poll")
public class PollServlet extends HttpServlet {
    int today = 0;
    int day = 7;
    Date d = new Date(0000,00,00);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        HttpSession session = req.getSession(true);
        Users user = (Users) session.getAttribute("user");
        int id = user.getId();
        Date result_date = user.getResult_date();

       if (result_date == null || result_date.toLocalDate().getDayOfMonth() + 7 < today) {
            userService.updateDate(id,d);
            PollService pollService = new PollServiceImpl();
            List all = pollService.findAll();
            session.setAttribute("poll", all);
            req.getRequestDispatcher("poll.jsp").forward(req, resp);
        }
       if (result_date != null) {
            int resultDate = result_date.toLocalDate().getDayOfMonth();
            today = LocalDate.now().getDayOfMonth();
            day += resultDate;
            if (day >= today) {
                Users byId = userService.findById(id);
                req.setAttribute("poll_error", "Вы можете снова принять участие в опросе через неделю");
                req.setAttribute("poll_result", byId);
                req.getRequestDispatcher("/results.jsp").forward(req, resp);
            }
        }
    }
}