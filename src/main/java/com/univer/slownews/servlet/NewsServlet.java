package com.univer.slownews.servlet;

import com.univer.slownews.model.*;
import com.univer.slownews.service.ConstantNewsProvider;
import com.univer.slownews.service.NewsGenerator;
import com.univer.slownews.service.NewsProvider;
import com.univer.slownews.model.NewsStorage;
import com.univer.slownews.service.WireNewsProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet({"/news", "/fakenews"})
public class NewsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsProvider newsReader;
        if("/fakenews".equals(request.getRequestURI())) {
            newsReader = new NewsGenerator();
        }
        else {
            newsReader = new WireNewsProvider();
        }
        List<News> showNews = newsReader.getNews();
        request.setAttribute("news", showNews);

        HttpSession session = request.getSession(true);
        session.setAttribute("ShowNews", showNews);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/news.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        List<News> showNews = (List<News>) session.getAttribute("ShowNews");

        String userName = (String) session.getAttribute("username");
        NewsStorage newsStorage = NewsStorage.getInstance();

        for (String newsIndex : Collections.list(request.getParameterNames())) {
            int index = Integer.parseInt(newsIndex);
            newsStorage.addNews(userName, showNews.get(index));
        }

        doGet(request, response);
    }
}
