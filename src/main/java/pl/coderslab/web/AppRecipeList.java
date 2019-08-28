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

        if (sess.getAttribute("user") == null) {
            response.sendRedirect("/LOGOWANIE");
            //zmienic adres
        } else {

            Admin user = (Admin) sess.getAttribute("user");

            List<Recipe> list = RecipeDao.readAllRecipesByUserId(user.getId());

            sess.setAttribute("recipeList", list);


        }


        getServletContext().getRequestDispatcher("/app-recipes.jsp").forward(request, response);
    }
}
