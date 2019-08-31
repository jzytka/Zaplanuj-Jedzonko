package pl.coderslab.web;

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

@WebServlet("/app-recipeEdit")
public class AppRecipeEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int preparationTime = Integer.parseInt(request.getParameter("preparationTime"));
        String preparation = request.getParameter("preparation");
        String ingredients = request.getParameter("ingredients");
        Admin admin = (Admin) session.getAttribute("admin");
        int id = Integer.parseInt(request.getParameter("idR"));


        Recipe recipe = new Recipe(name, ingredients, description, preparationTime, preparation, admin);
        recipe.setId(id);

        RecipeDao.updateRecipe(recipe);

        response.sendRedirect("/app-recipeList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Recipe> list = RecipeDao.readAllRecipes();
        Recipe rec = new Recipe();

        for (Recipe r : list) {
            if (r.getId() == id) {
                rec = r;
                break;
            }
        }

        request.setAttribute("rec", rec);

        getServletContext().getRequestDispatcher("/app-recipe-edit.jsp").forward(request, response);
    }
}
