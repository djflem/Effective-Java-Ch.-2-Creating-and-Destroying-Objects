package org.example;

import org.example.constructorpatterns.*;
import org.example.enforcesingleton.ElvisEnum;
import org.example.enforcesingleton.ElvisPublicFinalField;
import org.example.enforcesingleton.ElvisStaticFactory;

public class Main {
    public static void main(String[] args) {
        //CONSTRUCTORPATTERNS
        NutritionFactsTelescoping cocaCola = new NutritionFactsTelescoping(240, 8,100, 0, 35, 27);

        NutritionFactsJavaBeans pepsiCola = new NutritionFactsJavaBeans();
        pepsiCola.setServingSize(240);
        pepsiCola.setServings(8);
        pepsiCola.setCalories(100);
        pepsiCola.setSodium(35);
        pepsiCola.setCarbohydrate(27);

        NutritionFactsBuilder drPepper = new NutritionFactsBuilder.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();

        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL).addTopping(Pizza.Topping.SAUSAGE).addTopping(Pizza.Topping.ONION).build();
        Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.HAM).sauceInside().build();

        //ENFORCESINGLETON
        ElvisPublicFinalField elvisPublicFinalField = ElvisPublicFinalField.INSTANCE;
        ElvisStaticFactory elvisStaticFactory = ElvisStaticFactory.getInstance();
        ElvisEnum elvisEnum = ElvisEnum.INSTANCE;

        elvisPublicFinalField.leaveTheBuilding();
        elvisStaticFactory.leaveTheBuilding();
        elvisEnum.leaveTheBuilding();
    }
}