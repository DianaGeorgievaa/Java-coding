package Supplies;

public interface Beverage {

    /**
     * Returns the name of the beverage
     * Supplies.Espresso,Supplies.Cappuccino or Supplies.Mochaccino
     */
    public String getName();

    /**
     * Returns the quantity of milk (in milliliters) that the beverage
     * requires in order to be made
     */
    public double getMilk();

    /**
     * Returns the quantity of coffee (in grams) that the beverage
     * requires in order to be made
     */
    public double getCoffee();

    /**
     * Returns the quantity of water (in milliliters) that the beverage
     * requires in order to be made
     */
    public double getWater();

    /**
     * Returns the quantity of cacao (in grams) that the beverage
     * requires in order to be made
     */
    public double getCacao();
}
