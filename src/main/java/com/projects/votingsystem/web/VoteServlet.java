package com.projects.votingsystem.web;


import com.projects.votingsystem.service.MenuService;
import com.projects.votingsystem.service.RestaurantService;
import com.projects.votingsystem.service.VoteService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;


public class VoteServlet extends HttpServlet {
    private WebApplicationContext wac;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        VoteService voteService = wac.getBean(VoteService.class);
        RestaurantService restaurantService = wac.getBean(RestaurantService.class);
        request.setAttribute("voteList", voteService.countVotes(LocalDate.of(2015, Month.MAY, 31)));
        request.setAttribute("counts", restaurantService.getAll());
        request.getRequestDispatcher("/voteList.jsp").forward(request,response);
    }
}
