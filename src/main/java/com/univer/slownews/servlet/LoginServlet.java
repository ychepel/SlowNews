package com.univer.slownews.servlet;

import com.univer.slownews.model.User;
import com.univer.slownews.model.UserStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Log In - Slow News");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setName(username);
        user.setPassword(password);

        UserStorage storage = UserStorage.getInstance();
        if(storage.contains(user)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            request.setAttribute("message", "You are logged!");
        }
        else {
            request.setAttribute("message", "Wrong information. Try Again.");
        }

        doGet(request, response);
    }
}
