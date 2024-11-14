package org.example;

import org.example.constructorpatterns.NutritionFactsBuilder;
import org.example.constructorpatterns.NutritionFactsJavaBeans;
import org.example.constructorpatterns.NutritionFactsTelescoping;

public class Main {
    public static void main(String[] args) {
        NutritionFactsTelescoping cocaCola = new NutritionFactsTelescoping(240, 8,100, 0, 35, 27);

        NutritionFactsJavaBeans pepsiCola = new NutritionFactsJavaBeans();
        pepsiCola.setServingSize(240);
        pepsiCola.setServings(8);
        pepsiCola.setCalories(100);
        pepsiCola.setSodium(35);
        pepsiCola.setCarbohydrate(27);

        NutritionFactsBuilder drPepper = new NutritionFactsBuilder.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
    }
}