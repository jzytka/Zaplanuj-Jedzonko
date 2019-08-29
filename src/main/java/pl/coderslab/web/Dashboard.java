package pl.coderslab.web;

import pl.coderslab.dao.AdminDao;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.RecipePlanNonObjShort;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        HttpSession sess = request.getSession();


        //todo W SESJI ATRYBUT user KTÓRY NIESIE OBIEKT Admin
        //DO TESTU
        sess.setAttribute("user", AdminDao.read(1));

        if (sess.getAttribute("user") == null) {
            response.sendRedirect("/LOGOWANIE");
            //zmienic adres
        } else {
            Admin user = (Admin) sess.getAttribute("user");

            request.setAttribute("recipesCount", RecipeDao.countRecipesByAdminId(user.getId()));
            request.setAttribute("plansCount", PlanDao.countPlans(user.getId()));
            request.setAttribute("lastPlan", PlanDao.getLastPlanByUserId(user.getId()));
//            request.setAttribute("lastRecipePlan", PlanDao.getRecipePlanByPLanId(PlanDao.getLastPlanByUserId(user.getId()).getId()));
            List<RecipePlanNonObjShort> list = PlanDao.getRecipePlanByPLanId(PlanDao.getLastPlanByUserId(user.getId()).getId());

            List<RecipePlanNonObjShort> pon = new ArrayList<>();
            List<RecipePlanNonObjShort> wt = new ArrayList<>();
            List<RecipePlanNonObjShort> sr = new ArrayList<>();
            List<RecipePlanNonObjShort> czw = new ArrayList<>();
            List<RecipePlanNonObjShort> pt = new ArrayList<>();
            List<RecipePlanNonObjShort> sob = new ArrayList<>();
            List<RecipePlanNonObjShort> ndz = new ArrayList<>();

            ListIterator<RecipePlanNonObjShort> listIterator = list.listIterator();


            while (listIterator.hasNext()) {
                RecipePlanNonObjShort rec = listIterator.next();
                if ("poniedziałek".equals(rec.getDayName())) {
                    pon.add(rec);
                } else if ("wtorek".equals(rec.getDayName())) {
                    wt.add(rec);
                } else if ("środa".equals(rec.getDayName())) {
                    sr.add(rec);
                } else if ("czwartek".equals(rec.getDayName())) {
                    czw.add(rec);
                } else if ("piątek".equals(rec.getDayName())) {
                    pt.add(rec);
                } else if ("sobota".equals(rec.getDayName())) {
                    sob.add(rec);
                } else if ("niedziela".equals(rec.getDayName())) {
                    ndz.add(rec);
                }
            }

            request.setAttribute("pon", pon);
            request.setAttribute("wt", wt);
            request.setAttribute("sr", sr);
            request.setAttribute("czw", czw);
            request.setAttribute("pt", pt);
            request.setAttribute("sob", sob);
            request.setAttribute("ndz", ndz);

            getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);
        }
    }
}
