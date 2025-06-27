package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    private CarFactory() {};

    public static List<Car> createCars(List<String> carNames, MoveStrategy strategy) {
        return carNames.stream()
            .map(name -> new Car(name, strategy))
            .collect(Collectors.toList());
    }
}