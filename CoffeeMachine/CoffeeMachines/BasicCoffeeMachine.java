package CoffeeMachines;

import Containers.BasicContainer;
import Containers.Container;
import Supplies.Beverage;
import Supplies.Product;

public class BasicCoffeeMachine implements CoffeeMachine {

    private Container container;

    public BasicCoffeeMachine() {
        this.container = new BasicContainer();
    }

    @Override
    public Product brew(Beverage beverage) {

        if (this.container.removeIngredients(beverage) == true) {
            return new Product(beverage, 1, false);
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

        this.container = new BasicContainer();
    }

}
