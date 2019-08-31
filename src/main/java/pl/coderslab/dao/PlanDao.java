package pl.coderslab.dao;

import pl.coderslab.exception.NotFoundException;
import pl.coderslab.model.*;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanDao {

    // ZAPYTANIA SQL
    private static final String CREATE_PLAN_QUERY = "INSERT INTO `plan` (`id`, `name`, `description`, `created`, `admin_id`)" +
            " VALUES(null, ?, ?, now(), ?) ;";
    private static final String DELETE_PLAN_QUERY = "DELETE FROM plan where id = ?;";
    private static final String FIND_ALL_PLANS_QUERY = "SELECT * FROM plan order by created desc ;";
    private static final String READ_PLAN_QUERY = "SELECT * from plan where id = ?;";
    private static final String UPDATE_PLAN_QUERY = "UPDATE	plan SET name = ?, description = ?, admin_id = ? WHERE	id = ?;";

    private static final String COUNT_PLAN_QUERY = "SELECT count(admin_id) from plan where admin_id= ?;";
    private static final String GET_LAST_RECIPE_PLAN_BU_USER_ID = "SELECT day_name.name as day_name, meal_name, recipe.id, recipe.name as recipe_name, recipe.description as recipe_description\n" +
            "FROM `recipe_plan`\n" +
            "JOIN day_name on day_name.id=day_name_id\n" +
            "JOIN recipe on recipe.id=recipe_id WHERE\n" +
            "recipe_plan.plan_id =  (SELECT MAX(id) from plan WHERE admin_id = ?)\n" +
            "ORDER by day_name.display_order, recipe_plan.display_order;";
    private static final String GET_RECIPE_PLAN_BY_PLAN_ID = "SELECT day_name.name as day_name, meal_name, recipe.id, recipe.name as recipe_name, recipe.description as recipe_description\n" +
            "FROM `recipe_plan`\n" +
            "JOIN day_name on day_name.id=day_name_id\n" +
            "JOIN recipe on recipe.id=recipe_id WHERE plan_id = ?\n" +
            "ORDER by day_name.display_order, recipe_plan.display_order;";
    private static final String GET_LAST_PLAN_BY_USER_ID = "select * from plan where id =(select max(id) from plan) and admin_id = ?;";
    private static final String GET_PLANS_BU_USER_ID = "select * from plan where admin_id = ?";


    public static Plan read(int id) {
        Plan plan = new Plan();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_PLAN_QUERY)
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    plan.setId(resultSet.getInt("id"));
                    plan.setName(resultSet.getString("name"));
                    plan.setDescription(resultSet.getString("description"));
                    plan.setCreated(resultSet.getString("created"));
                    int adminId = resultSet.getInt("admin_id");
                    Admin admin = AdminDao.read(adminId);
                    plan.setAdmin(admin);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plan;

    }


    public static List<Plan> findAll() {
        List<Plan> planList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_PLANS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Plan planToAdd = new Plan();
                planToAdd.setId(resultSet.getInt("id"));
                planToAdd.setName(resultSet.getString("name"));
                planToAdd.setDescription(resultSet.getString("description"));
                planToAdd.setCreated(resultSet.getString("created"));
                int adminId = resultSet.getInt(("admin_id"));
                Admin admin = AdminDao.read(adminId);
                planToAdd.setAdmin(admin);
                planList.add(planToAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planList;

    }


    public static Plan create(Plan plan) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_PLAN_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setString(1, plan.getName());
            insertStm.setString(2, plan.getDescription());
            insertStm.setInt(3, plan.getAdmin().getId());
            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    plan.setId(generatedKeys.getInt(1));
                    return plan;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void update(Plan plan) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PLAN_QUERY)) {
            statement.setInt(4, plan.getId());
            statement.setString(1, plan.getName());
            statement.setString(2, plan.getDescription());
            statement.setInt(3, plan.getAdmin().getId());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void delete(Integer planId) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PLAN_QUERY)) {
            statement.setInt(1, planId);
            int deleted = statement.executeUpdate();

            if (deleted == 0) {
                System.out.println(deleted);

                throw new NotFoundException("Product not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int countPlans(int userId) {
        int counter = -1;
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(COUNT_PLAN_QUERY)
        ) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    counter = resultSet.getInt("count(admin_id)");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return counter;

    }

    public static List<RecipePlanNonObjShort> getLastRecipePlanByUserId(int id) {
        List<RecipePlanNonObjShort> list = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_LAST_RECIPE_PLAN_BU_USER_ID)
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    RecipePlanNonObjShort recipePlanNonObjShort = new RecipePlanNonObjShort();
                    recipePlanNonObjShort.setDayName(resultSet.getString("day_name"));
                    recipePlanNonObjShort.setMealName(resultSet.getString("meal_name"));
                    recipePlanNonObjShort.setRecipeId(resultSet.getString("id"));
                    recipePlanNonObjShort.setRecipeName(resultSet.getString("recipe_name"));
                    recipePlanNonObjShort.setRecipeDescription(resultSet.getString("recipe_description"));
                    list.add(recipePlanNonObjShort);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list.isEmpty()) {
            return null;
        }

        return list;

    }

    public static List<RecipePlanNonObjShort> getRecipePlanByPLanId(int id) {
        List<RecipePlanNonObjShort> list = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_RECIPE_PLAN_BY_PLAN_ID)
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    RecipePlanNonObjShort recipePlanNonObjShort = new RecipePlanNonObjShort();
                    recipePlanNonObjShort.setDayName(resultSet.getString("day_name"));
                    recipePlanNonObjShort.setMealName(resultSet.getString("meal_name"));
                    recipePlanNonObjShort.setRecipeId(resultSet.getString("id"));
                    recipePlanNonObjShort.setRecipeName(resultSet.getString("recipe_name"));
                    recipePlanNonObjShort.setRecipeDescription(resultSet.getString("recipe_description"));
                    list.add(recipePlanNonObjShort);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list.isEmpty()) {
            return null;
        }

        return list;

    }

    public static Plan getLastPlanByUserId(int id) {
        Plan plan = new Plan();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_LAST_PLAN_BY_USER_ID)
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    plan.setId(resultSet.getInt("id"));
                    plan.setName(resultSet.getString("name"));
                    plan.setDescription(resultSet.getString("description"));
                    plan.setCreated(resultSet.getString("created"));
                    int adminId = resultSet.getInt("admin_id");
                    Admin admin = AdminDao.read(adminId);
                    plan.setAdmin(admin);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plan;

    }

    public static List<Plan> readAllPlansByUserId(int id) {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(GET_PLANS_BU_USER_ID)) {

            List<Plan> list = new ArrayList<>();

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Plan plan = new Plan();
                plan.setId(resultSet.getInt("id"));
                plan.setName(resultSet.getString("name"));
                plan.setDescription(resultSet.getString("description"));
                plan.setCreated(resultSet.getString("created"));
                int adminId = resultSet.getInt("admin_id");
                Admin admin = AdminDao.read(adminId);
                plan.setAdmin(admin);

                list.add(plan);
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

