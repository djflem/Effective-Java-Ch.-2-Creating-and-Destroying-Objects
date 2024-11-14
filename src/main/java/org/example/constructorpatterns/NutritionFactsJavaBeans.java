package org.example.constructorpatterns;

// JavaBeans Pattern - allows inconsistency, mandates mutability

// Because construction is split across multiple calls, a JavaBean may be in an inconsistent state partway through its construction.
// Along with difficult debugging, a related disadvantage is that the JavaBeans pattern precludes the possibility of making a class immutable.
public class NutritionFactsJavaBeans {
    // Parameters initialized to default values (if any)
    private int servingSize = -1; // required; no default value
    private int servings = -1; // required; no default value
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    public NutritionFactsJavaBeans() { }

    // Setters
    public void setServingSize(int val) { servingSize = val; }
    public void setServings(int val) { servings = val; }
    public void setCalories(int val) { calories = val; }
    public void setFat(int val) { fat = val; }
    public void setSodium(int val) { sodium = val; }
    public void setCarbohydrate(int val) { carbohydrate = val; }
}
