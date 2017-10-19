package com.projects.votingsystem.web;


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
        VoteService service = wac.getBean(VoteService.class);
        request.setAttribute("voteList", service.getAllByDate(LocalDate.of(2015, Month.MAY, 30)));
        request.getRequestDispatcher("/voteList.jsp").forward(request,response);
    }
}
