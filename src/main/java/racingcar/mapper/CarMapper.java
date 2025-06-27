package racingcar.mapper;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.CarDto;

public class CarMapper {
    private CarMapper() {};

    public static List<CarDto> toCarDtos(List<Car> cars) {
        return cars.stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .toList();
    }
}