package CarStore.Cars;

import CarStore.CarStore;
import CarStore.Enums.EngineType;
import CarStore.Enums.Model;

import java.lang.*;

public abstract class Car {

    private int year;
    private double price;
    private String registrationNumber;
    private Model model;
    private EngineType engineType;

    protected Car(int year, double price, String registrationNumber, Model model, EngineType engineType) {
        this.year = year;
        this.price = price;
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.engineType = engineType;
    }

    public int getYear() {
        return this.year;
    }

    public double getPrice() {
        return this.price;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public Model getModel() {
        return this.model;
    }

    public EngineType getEngineType() {
        return this.engineType;
    }


}
