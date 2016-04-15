package com.univer.slownews.servlet;

import com.univer.slownews.model.User;
import com.univer.slownews.service.PasswordEncryptionService;
import com.univer.slownews.service.ServiceException;
import com.univer.slownews.service.UserStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/content/login")
public class LogInServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserStorage storage = new UserStorage();
        try {
            String username = request.getParameter("username");
            String originalPassword = request.getParameter("password");
            String password = new PasswordEncryptionService().getEncryptedPassword(originalPassword);
            User user = new User();
            user.setName(username);
            user.setPassword(password);

            if(storage.contains(user)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("username", username);
                request.setAttribute("message", "Hi, " + username + "! You are successfully logged in.");
            }
            else {
                request.setAttribute("error_message", "Wrong information. Please try again.");
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            request.setAttribute("error_message", "Some problem with server. Please try again later.");
            doGet(request, response);
        }
        doGet(request, response);
    }
}
