package Containers;

import Supplies.Beverage;

public interface Container {
    /**
     * Returns the current quantity (in milliliters) of the water in the container
     */
    double getCurrentWater();

    /**
     * Returns the current quantity (in milliliters) of the milk in the container
     */
    double getCurrentMilk();

    /**
     * Returns the current quantity (in grams) of the coffee in the container
     */
    double getCurrentCoffee();

    /**
     * Returns the current quantity (in grams) of the cacao in the container
     */
    double getCurrentCacao();

    boolean removeIngredients(Beverage beverage);
}
