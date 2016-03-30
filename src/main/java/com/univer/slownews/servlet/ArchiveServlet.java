package com.univer.slownews.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/archive")
public class ArchiveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Archive - Slow News");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/archive.jsp");
        dispatcher.forward(request, response);
    }
}
