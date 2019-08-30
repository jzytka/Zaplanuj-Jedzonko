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

@WebServlet("/app-recipeList")
public class AppRecipeList extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sess = request.getSession();

        if (sess.getAttribute("id") != null) {
            List<Recipe> list = RecipeDao.readAllRecipesByUserId((int) sess.getAttribute("id"));
            sess.setAttribute("recipeList", list);
        }
//todo dalej w recipe app-recipes.jsp mozna zmienic zeby wyswietlalo sie prawdziwe id ale wtedy bedzie z dupe np jakis user moze miec 3, dalj 345 itd


        getServletContext().getRequestDispatcher("/app-recipes.jsp").forward(request, response);
    }
}
