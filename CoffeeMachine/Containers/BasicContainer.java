package Containers;

import Supplies.Beverage;

public class BasicContainer implements Container {


    private static double QUANTITY_MILK = 0;
    private static double QUANTITY_COFFEE = 600;
    private static double QUANTITY_WATER = 600;
    private static double QUANTITY_CACAO = 0;

    private double water;
    private double coffee;
    private double milk;
    private double cacao;

    public BasicContainer() {

        this.water = QUANTITY_WATER;
        this.coffee = QUANTITY_COFFEE;
        this.milk = QUANTITY_MILK;
        this.cacao = QUANTITY_CACAO;
    }

    public BasicContainer(double water, double coffee, double milk, double cacao) {

        if (water > QUANTITY_WATER) {
            this.water = QUANTITY_WATER;
        } else {
            this.water = water;
        }
        if (coffee > QUANTITY_COFFEE) {
            this.coffee = QUANTITY_COFFEE;
        } else {
            this.coffee = coffee;
        }
        this.milk = QUANTITY_MILK;
        this.cacao = QUANTITY_CACAO;
    }

    @Override
    public double getCurrentWater() {

        return this.water;
    }

    @Override
    public double getCurrentMilk() {

        return this.milk;
    }

    @Override
    public double getCurrentCoffee() {

        return this.coffee;
    }

    @Override
    public double getCurrentCacao() {

        return this.cacao;
    }

    @Override
    public boolean removeIngredients(Beverage beverage) {

        if (this.water >= beverage.getWater()) {
            this.water -= beverage.getWater();
        } else {
            this.water = 0;
            return false;
        }

        if (this.milk >= beverage.getMilk()) {
            this.milk -= beverage.getMilk();
        } else {
            this.milk = 0;
            return false;
        }

        if (this.coffee >= beverage.getCoffee()) {
            this.coffee -= beverage.getCoffee();
        } else {
            this.coffee = 0;
            return false;
        }

        if (this.cacao >= beverage.getCacao()) {
            this.cacao -= beverage.getCacao();
        } else {
            this.cacao = 0;
            return false;
        }

        return true;
    }

}
