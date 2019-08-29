package pl.coderslab.web;

import com.mysql.jdbc.StringUtils;
import pl.coderslab.dao.AdminDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Recipe;
import pl.coderslab.utils.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class Add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtil.setCharset(request, response);
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        String timeString = request.getParameter("time");
        int time = Integer.parseInt(timeString);
        String prepare = request.getParameter("prepare");
        String ingredients = request.getParameter("ingredients");

        //todo pobrać id usera(admina) z sesji i przypisać do id poniżej
        int id = 1; //przypisana liczba tylko po to  aby kompilator się zamknął


        Recipe recipe = new Recipe(name, ingredients, description, time, prepare, AdminDao.read(id));

        response.getWriter().append(ingredients);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
