package pl.coderslab.web;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Plan;
import pl.coderslab.model.Recipe;
import pl.coderslab.utils.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/planList")
public class PlanList extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();


        if (sess.getAttribute("admin") != null) {
            Admin admin = (Admin) sess.getAttribute("admin");
            List<Plan> list = PlanDao.readAllPlansByUserId(admin.getId());
            request.setAttribute("list", list);
        } else if (sess.getAttribute("admin") == null) {
            response.sendRedirect("/login");
        }


        getServletContext().getRequestDispatcher("/appSchedules.jsp").forward(request, response);
        //response.sendRedirect("/appSchedules.jsp");
    }
}
