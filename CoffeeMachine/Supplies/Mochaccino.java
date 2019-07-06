package Supplies;

import Supplies.Beverage;

public class Mochaccino implements Beverage {

    private static String BEVERAGE_NAME = "Mochaccino";
    private static double QUANTITY_MILK = 150;
    private static double QUANTITY_COFFEE = 18;
    private static double QUANTITY_WATER = 0;
    private static double QUANTITY_CACAO = 0;

    public String getName() {

        return this.BEVERAGE_NAME;
    }

    public double getMilk() {

        return this.QUANTITY_MILK;
    }

    public double getCoffee() {

        return this.QUANTITY_COFFEE;
    }

    public double getWater() {

        return QUANTITY_WATER;
    }

    public double getCacao() {

        return this.QUANTITY_CACAO;
    }

}
