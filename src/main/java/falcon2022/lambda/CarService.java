package falcon2022.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarService {
    private final List<Car> cars;

    public CarService(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> findCar(CarIdentifier carIdentifier, String filter) {
        List<Car> result = new ArrayList<>();

        for (Car c : cars) {

        }
        return result;
    }
}
