package Containers;

import Containers.Container;
import Supplies.Beverage;

public class PremiumContainer implements Container {

    private static double QUANTITY_MILK = 1000;
    private static double QUANTITY_COFFEE = 1000;
    private static double QUANTITY_WATER = 1000;
    private static double QUANTITY_CACAO = 300;

    private double water;
    private double coffee;
    private double milk;
    private double cacao;

    private boolean autoRefill;

    public PremiumContainer() {

        this.water = QUANTITY_WATER;
        this.coffee = QUANTITY_COFFEE;
        this.milk = QUANTITY_MILK;
        this.cacao = QUANTITY_CACAO;
    }

    public PremiumContainer(double water, double coffee, double milk, double cacao) {

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
        if (milk > QUANTITY_MILK) {
            this.milk = QUANTITY_MILK;
        } else {
            this.milk = milk;
        }
        if (cacao > QUANTITY_CACAO) {
            this.cacao = QUANTITY_CACAO;
        } else {
            this.cacao = cacao;
        }
    }

    public double getCurrentWater() {
        return this.water;
    }

    public double getCurrentMilk() {
        return this.milk;
    }

    public double getCurrentCoffee() {
        return this.coffee;
    }

    public double getCurrentCacao() {
        return this.cacao;
    }

    public void setAutoRefill(boolean autoRefill) {
        this.autoRefill = autoRefill;
    }

    public boolean removeIngredients(Beverage beverage) {

        if (autoRefill == true) {
            return true;
        } else {

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

}
