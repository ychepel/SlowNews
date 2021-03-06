package com.univer.slownews.servlet;

import com.univer.slownews.entity.*;
import com.univer.slownews.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet({"/content/news", "/content/fakenews"})
public class NewsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsProvider newsReader;

        if("/content/fakenews".equals(request.getRequestURI())) {
            newsReader = new NewsGenerator();
        }
        else {
            newsReader = new WireNewsProvider();
        }
        List<News> showNews = null;
        try {
            showNews = newsReader.getNews();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

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

        UserService userService = new UserService();
        NewsService newsService = new NewsService();
        try {
            User currentUser = userService.getByName(userName);
            for (String newsIndex : Collections.list(request.getParameterNames())) {
                int index = Integer.parseInt(newsIndex);
                News news = showNews.get(index);
                news.setUser(currentUser);
                newsService.addNews(news);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        doGet(request, response);
    }
}
