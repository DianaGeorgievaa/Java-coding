package Supplies;

public class Product {
    private static final int MAX_NUMBER_LUCKS = 4;
    private Beverage beverage;
    private int quantity;
    private static int luckNumber = 0;
    private boolean hasLuck = false;
    String[] luck = {
            "If at first you don't succeed call it version 1.0.",
            "Today you will make magic happen!",
            "Have you tried turning it off and on again?",
            "Life would be much more easier if you had the source code."
    };

    public Product(Beverage bevarage, int quantity, boolean hasLuck) {
        this.beverage = bevarage;
        this.quantity = quantity;
        this.hasLuck = hasLuck;
    }

    public String getName() {
        return this.beverage.getName();
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getLuck() {
        if (hasLuck) {
            Product.luckNumber++;

            if (Product.luckNumber % MAX_NUMBER_LUCKS == 0) {
                return luck[3];
            }

            return luck[(Product.luckNumber % MAX_NUMBER_LUCKS) - 1];
        }

        return null;
    }
}
