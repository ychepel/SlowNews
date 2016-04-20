package com.univer.slownews.servlet;

import com.univer.slownews.entity.User;
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

@WebServlet("/content/signup")
public class SignUpServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/signup.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserStorage storage = new UserStorage();
        String username = request.getParameter("username");
        try {
            if(!storage.containsUserName(username)) {
                String email = request.getParameter("email");
                String originalPassword = request.getParameter("password");
                String password = new PasswordEncryptionService().getEncryptedPassword(originalPassword);
                User user = new User(username, email, password);
                storage.addUser(user);
                request.setAttribute("message", "New user have been added successfully.");
                HttpSession session = request.getSession(true);
                session.setAttribute("username", username);
            }
            else {
                request.setAttribute("error_message", "There is already user with name `" + username + "`. Please choose another one.");
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            request.setAttribute("error_message", "Some problem with server. Please try again later.");
        }
        doGet(request, response);
    }
}
