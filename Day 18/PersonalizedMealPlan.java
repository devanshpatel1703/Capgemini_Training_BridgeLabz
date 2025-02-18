public import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getMealType();
}

class VegetarianMeal implements MealPlan {
    private String mealName;
    
    public VegetarianMeal(String mealName) {
        this.mealName = mealName;
    }
    
    public String getMealType() {
        return "Vegetarian";
    }
    
    @Override
    public String toString() {
        return mealName + " (" + getMealType() + ")";
    }
}

class VeganMeal implements MealPlan {
    private String mealName;
    
    public VeganMeal(String mealName) {
        this.mealName = mealName;
    }
    
    public String getMealType() {
        return "Vegan";
    }
    
    @Override
    public String toString() {
        return mealName + " (" + getMealType() + ")";
    }
}

class KetoMeal implements MealPlan {
    private String mealName;
    
    public KetoMeal(String mealName) {
        this.mealName = mealName;
    }
    
    public String getMealType() {
        return "Keto";
    }
    
    @Override
    public String toString() {
        return mealName + " (" + getMealType() + ")";
    }
}

class HighProteinMeal implements MealPlan {
    private String mealName;
    
    public HighProteinMeal(String mealName) {
        this.mealName = mealName;
    }
    
    public String getMealType() {
        return "High-Protein";
    }
    
    @Override
    public String toString() {
        return mealName + " (" + getMealType() + ")";
    }
}

class Meal<T extends MealPlan> {
    private List<T> meals = new ArrayList<>();
    
    public void addMeal(T meal) {
        meals.add(meal);
    }
    
    public List<T> getMeals() {
        return meals;
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(List<T> meals) {
        System.out.println("Generated Meal Plan:");
        for (T meal : meals) {
            System.out.println(meal);
        }
    }
}

public class PersonalizedMealPlan {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMeals = new Meal<>();
        vegetarianMeals.addMeal(new VegetarianMeal("Grilled Vegetable Salad"));
        vegetarianMeals.addMeal(new VegetarianMeal("Mushroom Risotto"));
        
        Meal<VeganMeal> veganMeals = new Meal<>();
        veganMeals.addMeal(new VeganMeal("Tofu Stir-Fry"));
        veganMeals.addMeal(new VeganMeal("Vegan Burrito"));
        
        Meal<KetoMeal> ketoMeals = new Meal<>();
        ketoMeals.addMeal(new KetoMeal("Keto Chicken Bowl"));
        ketoMeals.addMeal(new KetoMeal("Avocado and Egg Salad"));
        
        Meal<HighProteinMeal> highProteinMeals = new Meal<>();
        highProteinMeals.addMeal(new HighProteinMeal("Grilled Salmon"));
        highProteinMeals.addMeal(new HighProteinMeal("Protein Smoothie"));
        
        System.out.println("Vegetarian Meal Plan:");
        MealPlanGenerator.generateMealPlan(vegetarianMeals.getMeals());
        
        System.out.println("\nVegan Meal Plan:");
        MealPlanGenerator.generateMealPlan(veganMeals.getMeals());
        
        System.out.println("\nKeto Meal Plan:");
        MealPlanGenerator.generateMealPlan(ketoMeals.getMeals());
        
        System.out.println("\nHigh-Protein Meal Plan:");
        MealPlanGenerator.generateMealPlan(highProteinMeals.getMeals());
    }
}
 {
    
}
