package com.univer.slownews.servlet;

import com.univer.slownews.model.User;
import com.univer.slownews.model.UserStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageTitle = "Sign Up - Slow News";
        request.setAttribute("title", pageTitle);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/signup.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(username, email, password);

        UserStorage storage = UserStorage.getInstance();
        storage.addUser(user);

        doGet(request, response);
    }
}
