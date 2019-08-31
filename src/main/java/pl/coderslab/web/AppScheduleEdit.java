package pl.coderslab.web;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Plan;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/app-scheduleEdit")
public class AppScheduleEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String name = request.getParameter("planName");
        String description = request.getParameter("planDescription");
        Admin admin = (Admin) session.getAttribute("admin");
        int id = Integer.parseInt(request.getParameter("idP"));

        Plan plan = new Plan(name, description, admin);
        plan.setId(id);

        PlanDao.update(plan);

        response.sendRedirect("/planList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("editId");
        Integer integerId = Integer.parseInt(id);

        List<Plan> list = PlanDao.findAll();
        Plan plan = new Plan();

        for (Plan p : list) {
            if (p.getId() == integerId) {
                plan = p;
                break;
            }
        }

        request.setAttribute("plan", plan);

        getServletContext().getRequestDispatcher("/app-edit-schedules.jsp").forward(request, response);
    }
}
