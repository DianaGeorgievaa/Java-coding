package CarStore.Enums;

import java.util.Random;

public enum Region {
    SOFIA("CB"), BURGAS("A"), VARNA("B"), PLOVDIV("PB"), RUSE("P"), GABROVO("EB"), VIDIN("BH"), VRATSA("BP");

    private static final int NUMBER_OF_LETTERS = 26;

    private int currentNumber = 1000;
    private String prefix;
    
    public String getPrefix() {
        return this.prefix;
    }

    public String carRegistartionNumber() {
        int current = this.currentNumber;
        current++;
        return String.format("%s%d%c%c", this.prefix, current, this.getRandomChar(), this.getRandomChar());
    }
    private char getRandomChar() {
        Random randomChar = new Random();
        return (char) (randomChar.nextInt(NUMBER_OF_LETTERS) + 'A');
    }
    private Region(String prefix) {
        this.prefix = prefix;
    }

}
