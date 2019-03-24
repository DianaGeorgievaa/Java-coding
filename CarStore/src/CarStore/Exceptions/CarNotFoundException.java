package CarStore.Exceptions;

import CarStore.CarStore;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(String message) {
        super(message);
    }
}