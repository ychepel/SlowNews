package com.univer.slownews.servlet;

import com.univer.slownews.model.News;
import com.univer.slownews.model.NewsInitialization;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageTitle = "Slow News";
        request.setAttribute("title", pageTitle);
        request.setAttribute("news", new NewsInitialization().getNews());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/news.jsp");
        dispatcher.forward(request, response);
    }
}
