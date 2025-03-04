package falcon2022.lambda;

import java.util.function.Predicate;

public class FilterService {

    public Predicate<Car> getFilter(CarIdentifier carIdentifier, Filters filters) {
        return switch (filters) {
            case NUMBER_FINDER -> car -> carIdentifier.getNumber() != null
                    && car.getNumber().equals(carIdentifier.getNumber());
            case SUBNUMBER_FINDER -> car -> carIdentifier.getNumber() != null
                    && car.getNumber().contains(carIdentifier.getNumber());
            case COLOR_FINDER -> car -> carIdentifier.getColor() != null
                    && car.getColor().equals(carIdentifier.getColor());
            case YEAR_DIAPASON_FINDER -> car -> carIdentifier.getYearStart() != -1
                    && carIdentifier.getYearFinish() != -1
                    && car.getYear() >= carIdentifier.getYearStart()
                    && car.getYear() <= carIdentifier.getYearFinish();
        };
    }
}
