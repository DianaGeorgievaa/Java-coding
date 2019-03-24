package CarStore;

import CarStore.Cars.Car;
import CarStore.Enums.Model;

import java.util.Collection;
import java.util.Comparator;

public interface ICarStore {
    public boolean addCar(Car car);

    public boolean addAll(Collection<Car> cars);

    public boolean removeCar(Car car);

    public Collection<Car> getCarsByModel(Model model);

    public Collection<Car> getCars();

    public Car getCarByRegistrationNumber(String registrationNumber);

    public Collection<Car> getCars(Comparator<Car> comparator);

    public Collection<Car> getCars(Comparator<Car> comparator, boolean isReversed);

    public int getNumberOfCars();

    public double getTotalPriceForCars();
}