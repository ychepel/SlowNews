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
import java.util.List;

@WebServlet("/content/userlist")
public class UserDisplayServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserStorage storage = UserStorage.getInstance();
        List<User> users = storage.getUsers();

        request.setAttribute("users", users);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/user-list.jsp");
        dispatcher.forward(request, response);

    }
}
