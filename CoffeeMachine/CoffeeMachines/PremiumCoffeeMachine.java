package CoffeeMachines;

import CoffeeMachines.CoffeeMachine;
import Containers.Container;
import Containers.PremiumContainer;
import Supplies.Beverage;
import Supplies.Product;

public class PremiumCoffeeMachine implements CoffeeMachine {
    private static int MAX_NUMBER_DRINKS = 3;
    private PremiumContainer container;

    public PremiumCoffeeMachine() {
        this.container = new PremiumContainer();
    }

    /**
     * @param autoRefill - if true, it will automatically refill the container
     *                   if there are not enough ingredients to make the coffee drink
     */
    public PremiumCoffeeMachine(boolean autoRefill) {
        this.container = new PremiumContainer();
        this.container.setAutoRefill(autoRefill);
    }

    /**
     * If quantity is <= 0 or the quantity is not supported for
     * the particular Coffee Machine the method returns null
     */
    public Product brew(Beverage beverage, int quantity) {

        if ((quantity <= 0 || quantity > MAX_NUMBER_DRINKS) || this.container.removeIngredients(beverage) == false) {
            return null;
        } else {
            return new Product(beverage, quantity, true);
        }
    }

    @Override
    public Product brew(Beverage beverage) {
        if (this.container.removeIngredients(beverage) == true) {
            return new Product(beverage, 1, true);
        } else {
            return null;
        }
    }

    @Override
    public Container getSupplies() {

        return this.container;
    }

    @Override
    public void refill() {

        this.container = new PremiumContainer();
    }
}
