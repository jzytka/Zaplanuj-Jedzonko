package pl.coderslab.web;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.RecipePlanNonObjShort;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@WebServlet("/app-planDetails")
public class AppPlanDetails extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //todo zrobiłem przechwycenie wyjątku więc w przypadku złego naciśnięcia powróci na stronę

        //request.setAttribute("planId", 6);
        //to jest do wyjebania


        String planIdS = request.getParameter("planId");
        int planId = Integer.parseInt(planIdS);

        request.setAttribute("plan", PlanDao.read(planId));


        List<RecipePlanNonObjShort> list = PlanDao.getRecipePlanByPLanId(planId);

        List<RecipePlanNonObjShort> pon = new ArrayList<>();
        List<RecipePlanNonObjShort> wt = new ArrayList<>();
        List<RecipePlanNonObjShort> sr = new ArrayList<>();
        List<RecipePlanNonObjShort> czw = new ArrayList<>();
        List<RecipePlanNonObjShort> pt = new ArrayList<>();
        List<RecipePlanNonObjShort> sob = new ArrayList<>();
        List<RecipePlanNonObjShort> ndz = new ArrayList<>();

        if (list != null) {
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


        }

        getServletContext().getRequestDispatcher("/app-planDetails.jsp").forward(request, response);
    }


}

