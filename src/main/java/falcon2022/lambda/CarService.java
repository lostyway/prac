package falcon2022.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CarService {
    private final List<Car> cars;

    public CarService(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }


    public List<Car> findCars(CarIdentifier carIdentifier, Filters filters) {
        List<Car> result = new ArrayList<>();
        FilterService filterService = new FilterService();
        Predicate<Car> predicate = filterService.getFilter(carIdentifier, filters);

        for (Car car : cars) {
            if (predicate.test(car)) {
                result.add(car);
            }
        }
        return result;
    }
}
