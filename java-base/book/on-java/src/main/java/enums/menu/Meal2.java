package enums.menu;

import onjava.Enums;

/**
 * @author lh
 */
public enum Meal2 {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;

    Meal2(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }
    ;

    interface Food {
        enum Appetizer implements Food {
            SALAD,
            SOUP,
            SPRING_ROLLS;
        }

        enum MainCourse implements Food {
            LASAGNE,
            BURRITO,
            PAD_THAI,
            LENTILS,
            HUMMOUS,
            VINDALOO;
        }

        enum Dessert implements Food {
            TIRAMISU,
            GELATO,
            BLACK_FOREST_CAKE,
            FRUIT,
            CREME_CARAMEL;
        }

        enum Coffee implements Food {
            BLACK_COFEE,
            DECAF_COFFEE,
            ESPRESSO,
            LATTE,
            CAPPUCCINO,
            TEA,
            HERB_TEA;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <5; i++) {
            for (Meal2 meal : Meal2.values()) {
                Food food = meal.randomSelection();
                System.out.println(food);
            }
            System.out.println("***");
        }
    }
}
