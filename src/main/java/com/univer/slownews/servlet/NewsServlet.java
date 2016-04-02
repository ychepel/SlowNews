package com.univer.slownews.servlet;

import com.univer.slownews.model.NewsGenerator;
import com.univer.slownews.model.NewsReader;
import com.univer.slownews.model.WireNewsReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsReader newsReader = new NewsGenerator(getServletContext().getRealPath("/WEB-INF/classes"));
        request.setAttribute("news", newsReader.getNews());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/news.jsp");
        dispatcher.forward(request, response);
    }
}
