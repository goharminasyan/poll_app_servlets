package com.epam.servlets;

import com.epam.db.model.Result;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/results")
public class ResultsServlet extends HttpServlet {
    List<Long> list = new ArrayList();
    AnswerServiceImpl answer = new AnswerServiceImpl();
    long sum = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] questionIds = req.getParameterValues("questionId");

        for (String questionId : questionIds) {
            String parameter = req.getParameter("marked" + questionId);
            if (parameter == null) {
                req.setAttribute("error", "You have not filled in all the fields, try again");
                req.getRequestDispatcher("/error.jsp").forward(req, resp);
            } else {
                long marked = Long.parseLong(parameter);
                sum += marked;
            }
        }
        HttpSession session = req.getSession(true);
        ResultService resultService = new ResultServiceImpl();
        Result byScore = resultService.findByScore(1, sum);

        Date now = Date.valueOf(LocalDate.now());

        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");

        UserService userService = new UserServiceImpl();
        Users user = (Users) userService.getByEmailAndPass(email, password);
        int id = user.getId();
        userService.updateDate(id, now);

        String explanation = byScore.getExplanation();
        userService.updateResult(id,explanation);
        Users byId = userService.findById(id);

        session.setAttribute("weight", byId);
        req.getRequestDispatcher("/results.jsp").forward(req, resp);
    }
}
