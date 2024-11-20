package org.example;

import org.example.constructorpatterns.*;
import org.example.enforcenoninstantiability.UtilityClass;
import org.example.enforcesingleton.ElvisEnum;
import org.example.enforcesingleton.ElvisPublicFinalField;
import org.example.enforcesingleton.ElvisStaticFactory;
import org.example.staticfactory.*;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;

public class Main {
    public static void main(String[] args) {
        //STATIC FACTORIES
        System.out.println();
        System.out.println("STATIC FACTORIES");
        System.out.println();
        //

        LocalDate date = DateFactory.fromEpochMillis(1692278400000L);
        System.out.println(date); // Prints the date in yyyy-MM-dd format

        Optional<String> empty = OptionalFactory.emptyOptional();
        System.out.println(empty.isPresent()); // false

        Logger logger1 = Logger.getLogger("AppLogger");
        Logger logger2 = Logger.getLogger("AppLogger");
        logger1.log("This is a log message."); // [AppLogger] This is a log message
        System.out.println(logger1 == logger2); // true

        ExecutorService executor = ExecutorFactory.newCachedThreadPool();
        executor.execute(() -> System.out.println("Task executed!"));
        executor.shutdown();

        List<String> list = ListFactory.newArrayList();
        list.add("Hello");
        list.add("World");
        System.out.println(list); // [Hello, World]

        BigDecimal valid = BigDecimalFactory.fromString("123.45");
        System.out.println(valid); // 123.45
        // BigDecimal invalid = BigDecimalFactory.fromString("abc"); // Throws IllegalArgumentException

        List<String> factoryList = ImmutableListFactory.immutableList("A", "B", "C");
        System.out.println(factoryList); // [A, B, C]
        // factoryList.add("D"); // Throws UnsupportedOperationException

        User user1 = User.fromEmail("example@example.com");
        User user2 = User.fromId(42);
        System.out.println(user1.getDescription()); // User with email: example@example.com
        System.out.println(user2.getDescription()); // User with ID: 42

        Shape circle = Shape.createShape("circle");
        Shape square = Shape.createShape("square");
        System.out.println(circle.draw()); // Drawing a Circle
        System.out.println(square.draw()); // Drawing a Square

        DataSource ds = DataSourceFactory.createDataSource();
        System.out.println(ds); // Example usage

        //ENFORCE NONINSTANTIABILITY
        System.out.println();
        System.out.println("ENFORCE NONINSTANTIABILITY");
        System.out.println();
        //

        String message = UtilityClass.createDefaultMessage();
        System.out.println("Message: " + message);

        int[] defaultArray = UtilityClass.createDefaultIntArray();
        System.out.print("Default Array: ");
        for (int num : defaultArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        //CONSTRUCTOR PATTERNS
        System.out.println();
        System.out.println("CONSTRUCTOR PATTERNS");
        System.out.println();
        //

        NutritionFactsTelescoping cocaCola = new NutritionFactsTelescoping(240, 8,100, 0, 35, 27);

        NutritionFactsJavaBeans pepsiCola = new NutritionFactsJavaBeans();
        pepsiCola.setServingSize(240);
        pepsiCola.setServings(8);
        pepsiCola.setCalories(100);
        pepsiCola.setSodium(35);
        pepsiCola.setCarbohydrate(27);

        NutritionFactsBuilder drPepper = new NutritionFactsBuilder.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();

        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL).addTopping(Pizza.Topping.SAUSAGE).addTopping(Pizza.Topping.ONION).build();
        System.out.println(pizza);
        Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.HAM).sauceInside().build();
        System.out.println(calzone);

        //ENFORCE SINGLETON
        System.out.println();
        System.out.println("ENFORCE SINGLETON");
        System.out.println();
        //

        ElvisPublicFinalField elvisPublicFinalField = ElvisPublicFinalField.INSTANCE;
        ElvisStaticFactory elvisStaticFactory = ElvisStaticFactory.getInstance();
        ElvisEnum elvisEnum = ElvisEnum.INSTANCE;

        elvisPublicFinalField.leaveTheBuilding();
        elvisStaticFactory.leaveTheBuilding();
        elvisEnum.leaveTheBuilding();
    }
}
