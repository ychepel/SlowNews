package com.univer.slownews.servlet;

import com.univer.slownews.model.User;
import com.univer.slownews.service.ServiceException;
import com.univer.slownews.service.UserStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/content/userlist")
public class UserDisplayServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserStorage storage = new UserStorage();
        List<User> users = new ArrayList<>();
        try {
            users = storage.getUsers();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        request.setAttribute("users", users);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/user-list.jsp");
        dispatcher.forward(request, response);

    }
}
