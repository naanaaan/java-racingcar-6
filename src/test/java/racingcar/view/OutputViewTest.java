package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.domain.MoveStrategy;
import racingcar.mapper.CarMapper;

public class OutputViewTest {
    private final MoveStrategy alwaysMove = () -> true;
    private ByteArrayOutputStream outputBuffer;

    @BeforeEach
    void setUp() {
        outputBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputBuffer));
    }

    @DisplayName("자동차 이동 결과가 콘솔 출력에 포함되어야 한다.")
    @Test
    void shoudContainCarMovementResultInConsoleOutput() {
        List<Car> cars = List.of(
                createCarMovedNTimes("pobi", 1),
                createCarMovedNTimes("bob", 2),
                createCarMovedNTimes("bom", 3));
        List<CarDto> carDtos = CarMapper.toCarDtos(cars);

        OutputView.printCarsRoundResult(carDtos);

        String result = outputBuffer.toString();
        assertThat(result).contains("pobi : -", "bob : --", "bom : ---");
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

    @DisplayName("우승자가 콘솔 출력에 포함되어야 한다.")
    @Test
    void shouldContainWinnerInConsoleOutput() {
        List<CarDto> winner = List.of(new CarDto("bom", 3));

        OutputView.printWinners(winner);

        String result = outputBuffer.toString();
        assertThat(result).contains("최종 우승자 : bom");
    }

    @DisplayName("여러 명의 우승자가 콘솔 출력에 포함되어야 한다.")
    @Test
    void shouldContainWinnersInConsoleOutput() {
        List<CarDto> winners = List.of(
                new CarDto("pobi", 3),
                new CarDto("jun", 3));

        OutputView.printWinners(winners);

        String result = outputBuffer.toString();
        assertThat(result).contains("최종 우승자 : pobi, jun");
    }
}