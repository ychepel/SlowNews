package com.univer.slownews.servlet;

import com.univer.slownews.entity.News;
import com.univer.slownews.service.NewsStorage;
import com.univer.slownews.service.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/content/archive")
public class ArchiveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String userName = (String) session.getAttribute("username");
        NewsStorage newsStorage = new NewsStorage();
        List<News> archiveNews = new ArrayList<>();
        try {
            archiveNews = newsStorage.getUserNews(userName);
        } catch (ServiceException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        request.setAttribute("news", archiveNews);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/archive.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Integer> removeIds = new ArrayList<>();
        for (String newsIndex : Collections.list(request.getParameterNames())) {
            int index = Integer.parseInt(newsIndex);
            removeIds.add(index);
        }

        NewsStorage newsStorage = new NewsStorage();
        try {
            newsStorage.removeNews(removeIds);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        doGet(request, response);
    }
}
