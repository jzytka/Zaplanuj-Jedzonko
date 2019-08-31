package pl.coderslab.dao;

import pl.coderslab.model.Admin;
import pl.coderslab.model.Recipe;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeDao {

    private static final String CREATE_RECIPE = "insert into recipe values (null, ?, ?, ?, now(), null, ?, ?, ?)";
    private static final String READ_RECIPE_BY_ID = "select * from recipe where id = ?";
    private static final String UPDATE_RECIPE = "update recipe set name = ?, ingredients = ?, description = ?, preparation_time = ?," +
            " preparation = ?, admin_id = ?, updated = now() where id = ?";
    private static final String DELETE_RECIPE_BY_ID = "delete from recipe where id = ?";
    private static final String READ_ALL_RECIPES = "select * from recipe";
    private static final String COUNT_RECIPES_BY_USER_ID = "select count(id) from recipe where admin_id = ?";
    private static final String READ_ALL_RECIPES_BY_USER_ID = "select * from recipe where admin_id = ?";

    public static Recipe createRecipe(Recipe recipe) {

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(CREATE_RECIPE, PreparedStatement.RETURN_GENERATED_KEYS);) {

            preparedStatement.setString(1, recipe.getName());
            preparedStatement.setString(2, recipe.getIngredients());
            preparedStatement.setString(3, recipe.getDescription());
            preparedStatement.setInt(4, recipe.getPreparationTime());
            preparedStatement.setString(5, recipe.getPreparation());
            preparedStatement.setInt(6, recipe.getAdmin().getId());

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            if (rs.next()) {
                int id = rs.getInt(1);
                recipe.setId(id);
            }

            recipe.setCreated(readRecipeById(recipe.getId()).getCreated());

            return recipe;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Recipe readRecipeById(int id) {

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(READ_RECIPE_BY_ID);) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    Recipe recipe = new Recipe();
                    recipe.setId(resultSet.getInt("id"));
                    recipe.setName(resultSet.getString("name"));
                    recipe.setIngredients(resultSet.getString("ingredients"));
                    recipe.setDescription(resultSet.getString("description"));
                    recipe.setCreated(resultSet.getString("created"));
                    recipe.setUpdated(resultSet.getString("updated"));  
                    recipe.setPreparationTime(resultSet.getInt("preparation_time"));
                    recipe.setPreparation(resultSet.getString("preparation"));
                    int adminId = resultSet.getInt("admin_id");
                    Admin admin = AdminDao.read(adminId);
                    recipe.setAdmin(admin);

                    return recipe;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateRecipe(Recipe recipe) {

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_RECIPE);) {

            preparedStatement.setString(1, recipe.getName());
            preparedStatement.setString(2, recipe.getIngredients());
            preparedStatement.setString(3, recipe.getDescription());
            preparedStatement.setInt(4, recipe.getPreparationTime());
            preparedStatement.setString(5, recipe.getPreparation());
            preparedStatement.setInt(6, recipe.getAdmin().getId());

            preparedStatement.setInt(7, recipe.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deleteRecipeById(int id) {

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(DELETE_RECIPE_BY_ID);) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Recipe> readAllRecipes() {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(READ_ALL_RECIPES)) {

            List<Recipe> list = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Recipe recipe = new Recipe();
                recipe.setId(resultSet.getInt("id"));
                recipe.setName(resultSet.getString("name"));
                recipe.setIngredients(resultSet.getString("ingredients"));
                recipe.setDescription(resultSet.getString("description"));
                recipe.setCreated(resultSet.getString("created"));
                recipe.setUpdated(resultSet.getString("updated"));
              
                recipe.setPreparationTime(resultSet.getInt("preparation_time"));
                recipe.setPreparation(resultSet.getString("preparation"));
                int adminId = resultSet.getInt("admin_id");
                Admin admin = AdminDao.read(adminId);
                recipe.setAdmin(admin);

                list.add(recipe);
            }

            if (list.isEmpty()) {
                return null;
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int countRecipesByAdminId(int userId) {
        //todo przemyśleć parametr podawany do metody przez osobe tworzaca sesje

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(COUNT_RECIPES_BY_USER_ID);) {

            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {

                    int counter = resultSet.getInt("count(id)");

                    return counter;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static List<Recipe> readAllRecipesByUserId(int id) {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(READ_ALL_RECIPES_BY_USER_ID)) {

            List<Recipe> list = new ArrayList<>();

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Recipe recipe = new Recipe();
                recipe.setId(resultSet.getInt("id"));
                recipe.setName(resultSet.getString("name"));
                recipe.setIngredients(resultSet.getString("ingredients"));
                recipe.setDescription(resultSet.getString("description"));

                recipe.setCreated(resultSet.getString("created"));
                recipe.setUpdated(resultSet.getString("updated"));

                recipe.setPreparationTime(resultSet.getInt("preparation_time"));
                recipe.setPreparation(resultSet.getString("preparation"));
                int adminId = resultSet.getInt("admin_id");
                Admin admin = AdminDao.read(adminId);
                recipe.setAdmin(admin);

                list.add(recipe);
            }

            if (list.isEmpty()) {
                return null;
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
