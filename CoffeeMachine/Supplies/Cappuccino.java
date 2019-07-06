package Supplies;

import Supplies.Beverage;

public class Cappuccino implements Beverage {

    private static String BEVERAGE_NAME = "Cappuccino";
    private static double QUANTITY_MILK = 150;
    private static double QUANTITY_COFFEE = 18;
    private static double QUANTITY_WATER = 0;
    private static double QUANTITY_CACAO = 0;

    @Override
    public String getName() {

        return this.BEVERAGE_NAME;
    }

    @Override
    public double getMilk() {

        return this.QUANTITY_MILK;
    }

    @Override
    public double getCoffee() {

        return this.QUANTITY_COFFEE;
    }

    @Override
    public double getWater() {

        return this.QUANTITY_WATER;
    }

    @Override
    public double getCacao() {

        return this.QUANTITY_CACAO;
    }
}
