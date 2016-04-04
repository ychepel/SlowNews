package com.univer.slownews.servlet;

import com.univer.slownews.model.News;
import com.univer.slownews.model.NewsStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/archive")
public class ArchiveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Archive - Slow News");

        HttpSession session = request.getSession(true);
        String userName = (String) session.getAttribute("username");
        NewsStorage newsStorage = NewsStorage.getInstance();
        List<News> archiveNews = newsStorage.getUserNews(userName);
        request.setAttribute("news", archiveNews);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/archive.jsp");
        dispatcher.forward(request, response);
    }
}
