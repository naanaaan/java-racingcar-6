package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> findWinners() {
        return cars.stream()
                .filter(this::hasMaxPosition)
                .toList();
    }

    private boolean hasMaxPosition(Car car) {
        return car.getPosition() == findMaxPosition();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}