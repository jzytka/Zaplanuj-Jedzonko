package pl.coderslab.web;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Plan;
import pl.coderslab.utils.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/planList")
public class PlanList extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtil.setCharset(request, response);
        List<Plan> plans = PlanDao.findAll();
        request.setAttribute("list", plans);


        getServletContext().getRequestDispatcher("/appSchedules.jsp").forward(request, response);
        //response.sendRedirect("/appSchedules.jsp");
    }
}
