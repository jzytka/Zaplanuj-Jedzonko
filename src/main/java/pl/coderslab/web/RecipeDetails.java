package pl.coderslab.web;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Recipe;
import pl.coderslab.utils.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/recipeDetails")
public class RecipeDetails extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtil.setCharset(request, response);
//        Recipe recipe = new Recipe();

        //todo pobrać id z formularza do wyszukiwania przepisów narazie jest na sztywno wpisane 8

        String recipeId = request.getParameter("recipeId");
        int recId = Integer.parseInt(recipeId);

        Recipe recipe = RecipeDao.readRecipeById(recId);
        String[] ingredients = recipe.getIngredients().split(", ");
        //add(recipe);
        request.setAttribute("ingredients", ingredients);
        request.setAttribute("recipe", recipe);
        getServletContext().getRequestDispatcher("/recipe-details.jsp").forward(request, response);
    }
}
