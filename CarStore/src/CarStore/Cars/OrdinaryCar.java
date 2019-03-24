package CarStore.Cars;

import CarStore.Enums.EngineType;
import CarStore.Enums.Model;

public class OrdinaryCar extends Car {
    public OrdinaryCar(int year, double price, String registrationNumber, Model model, EngineType engineType) {
        super(year, price, registrationNumber, model, engineType);
    }
}