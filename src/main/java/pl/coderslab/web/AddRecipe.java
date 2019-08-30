package pl.coderslab.web;

import com.mysql.jdbc.StringUtils;
import pl.coderslab.dao.AdminDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Recipe;
import pl.coderslab.utils.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addrecipe")
public class AddRecipe extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

        ServletUtil.setCharset(request, response);
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        String timeString = request.getParameter("time");
        int time = Integer.parseInt(timeString);
        String prepare = request.getParameter("prepare");
        String ingredients = request.getParameter("ingredients");



        Recipe recipe = new Recipe(name, ingredients, description, time, prepare, admin);
        RecipeDao.createRecipe(recipe);

        response.sendRedirect("/app-recipeList");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       response.sendRedirect("/app-add-recipe.jsp");
    }
}
