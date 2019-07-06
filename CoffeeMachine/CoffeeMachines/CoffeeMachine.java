package CoffeeMachines;

import Containers.Container;
import Supplies.Beverage;
import Supplies.Product;

public interface CoffeeMachine {
    /**
     * If quantity is <= 0 or the quantity is not supported for
     * the particular Coffee Machine the method returns null
     */
    Product brew(Beverage beverage);
    /**
     * Returns the Containers.Container of the Coffee Machine
     */
    Container getSupplies();
    /**
     * Reffils the Containers.Container of the Coffee Machine with its default values
     */
    void refill();
}
