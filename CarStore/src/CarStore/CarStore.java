package CarStore;

import CarStore.Cars.Car;
import CarStore.Comparators.DefaultComparator;
import CarStore.Enums.Model;
import CarStore.Exceptions.CarNotFoundException;

import java.util.*;

public class CarStore implements ICarStore {
    private Map<String, Car> carsInStore;
    private double totalPrice;

    public CarStore() {
        this.carsInStore = new HashMap<>();
        this.totalPrice = 0;
    }

    @Override
    public boolean addCar(Car car) {
        if (car == null) {
            throw new CarNotFoundException("CarStore.Cars.Car not found.");
        } else {
            if (this.carsInStore.containsKey(car.getRegistrationNumber())) {
                return false;
            } else {
                this.carsInStore.put(car.getRegistrationNumber(), car);
                this.totalPrice += car.getPrice();
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<Car> cars) {
        Iterator<Car> it = cars.iterator();
        boolean flag = false;
        while (it.hasNext()) {
            Car car = it.next();
            if (car == null) {
                throw new CarNotFoundException("CarStore.Cars.Car not found.");
            } else {
                if (!this.carsInStore.containsKey(car.getRegistrationNumber())) {
                    this.carsInStore.put(car.getRegistrationNumber(), car);
                    this.totalPrice += car.getPrice();
                    flag = true;
                }
            }
        }
        return flag;
    }

    @Override
    public boolean removeCar(Car car) {
        if (car == null) {
            throw new CarNotFoundException("CarStore.Cars.Car not found.");
        } else {
            if (this.carsInStore.containsKey(car.getRegistrationNumber())) {
                this.carsInStore.remove(car.getRegistrationNumber());
                this.totalPrice -= car.getPrice();
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<Car> getCarsByModel(Model model) {
        Iterator<Car> it = this.carsInStore.values().iterator();
        List<Car> cars = new ArrayList<Car>();
        while (it.hasNext()) {
            Car car = it.next();
            if (car.getModel() == model) {
                cars.add(car);
            }
        }
        return cars;
    }

    @Override
    public Collection<Car> getCars() {
        List<Car> sortedCars = new ArrayList<>(this.carsInStore.values());
        Collections.sort(sortedCars, new DefaultComparator());
        return sortedCars;
    }

    @Override
    public Car getCarByRegistrationNumber(String registrationNumber) {
        return this.carsInStore.get(registrationNumber);
    }

    public Collection<Car> getCars(Comparator<Car> comparator) {
        List<Car> sortedCars = new ArrayList<>(this.carsInStore.values());
        Collections.sort(sortedCars, comparator);
        return sortedCars;
    }

    @Override
    public Collection<Car> getCars(Comparator<Car> comparator, boolean isReversed) {
        if (isReversed) {
            return this.getCars(Collections.reverseOrder(comparator));
        }
        return this.getCars(comparator);
    }

    @Override
    public int getNumberOfCars() {
        return this.carsInStore.size();
    }

    @Override
    public double getTotalPriceForCars() {
        return this.totalPrice;
    }
}