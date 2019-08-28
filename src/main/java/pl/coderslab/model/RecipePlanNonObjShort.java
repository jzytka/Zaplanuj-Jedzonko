package pl.coderslab.model;

public class RecipePlanNonObjShort {

    //nie-obiektowo ew. pozniej pozamieniac
    private String dayName;
    private String mealName;
    private String recipeName;
    private String recipeDescription;

    public RecipePlanNonObjShort(String dayName, String mealName, String recipe_name, String recipeDescription) {
        this.dayName = dayName;
        this.mealName = mealName;
        this.recipeName = recipe_name;
        this.recipeDescription = recipeDescription;
    }

    public RecipePlanNonObjShort() {
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipe_name) {
        this.recipeName = recipe_name;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    @Override
    public String toString() {
        return "RecipePlanNonObjShort{" +
                "dayName='" + dayName + '\'' +
                ", mealName='" + mealName + '\'' +
                ", recipeName='" + recipeName + '\'' +
                ", recipeDescription='" + recipeDescription + '\'' +
                '}';
    }
}
