package pl.coderslab.web;

import pl.coderslab.dao.AdminDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/app-recipeList")
public class AppRecipeList extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sess = request.getSession();


        if (sess.getAttribute("admin") != null) {
            Admin admin = (Admin) sess.getAttribute("admin");
            List<Recipe> list = RecipeDao.readAllRecipesByUserId(admin.getId());
            request.setAttribute("list", list);
        } else if (sess.getAttribute("admin") == null) {
            response.sendRedirect("/login");
        }


        getServletContext().getRequestDispatcher("/app-recipes.jsp").forward(request, response);
    }
}
