package CarStore.Comparators;

import CarStore.CarStore;
import CarStore.Cars.Car;

import java.util.Comparator;

public class DefaultComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        int resultOfComparison = o1.getModel().compareTo(o2.getModel());
        if (resultOfComparison == 0) {
            return Integer.compare(o1.getYear(), o1.getYear());
        }
        return resultOfComparison;
    }
}