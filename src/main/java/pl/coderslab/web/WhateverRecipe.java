package pl.coderslab.web;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/whateverRecipe")
public class WhateverRecipe extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Recipe> recipes = RecipeDao.readAllRecipes();



        request.setAttribute("recipe", recipes);

        getServletContext().getRequestDispatcher("/whateverRecipes.jsp").forward(request, response);

    }
}
