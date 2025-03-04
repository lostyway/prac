package falcon2022.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CarService {
    private final List<Car> cars;

    public CarService(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> findCars(CarIdentifier carIdentifier, Filters filter) {
        List<Car> result = new ArrayList<>();
        Predicate<Car> predicate = switch (filter) {
            case NUMBER_FINDER -> car -> car.getNumber().equals(carIdentifier.getNumber());
            case SUBNUMBER_FINDER -> car -> car.getNumber().contains(carIdentifier.getNumber());
            case COLOR_FINDER -> car -> car.getColor().equals(carIdentifier.getColor());
            case YEAR_DIAPASON_FINDER -> car -> car.getYear() >= carIdentifier.getYearStart()
                    && car.getYear() <= carIdentifier.getYearFinish();
        };

        for (Car car : cars) {
            if (predicate.test(car)) {
                result.add(car);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Машины не найдены");
        }
        return result;
    }
}
