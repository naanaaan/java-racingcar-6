package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

    private final MoveStrategy alwaysMove = () -> true;

    @DisplayName("가장 멀리 이동한 자동차 1대를 우승자로 구한다.")
    @Test
    void singleWinnerSelectedIfSingleMaxPosition() {
        List<Car> cars = List.of(
                createCarMovedNTimes("pobi", 3),
                createCarMovedNTimes("bob", 3),
                createCarMovedNTimes("bom", 4)
                );
        List<Car> winners = new Race(cars).findWinners();

        assertThat(winners).extracting(Car::getName)
                .containsExactlyInAnyOrder("bom");
    }

    @DisplayName("동일한 거리로 가장 멀리 이동한 자동차 여러 대를 우승자로 구한다.")
    @Test
    void multipleWinnersSelectedIfMultipleMaxPositions() {
        List<Car> cars = List.of(
                createCarMovedNTimes("pobi", 3),
                createCarMovedNTimes("bob", 5),
                createCarMovedNTimes("bom", 5)
                );
        List<Car> winners = new Race(cars).findWinners();

        assertThat(winners).extracting(Car::getName)
                .containsExactlyInAnyOrder("bob", "bom");
    }

    private Car createCarMovedNTimes(String name, int times) {
        return moveCarNTimes(new Car(name, alwaysMove), times);

    }

    private Car moveCarNTimes(Car car, int times) {
        for (int i = 0; i < times; i++) {
            car.move();
        }
        return car;
    }
}
