package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.CarDto;

public class OutputView {
    private static final String POSITION_INDICATOR = "-";
    private static final String WINNER_DELIMITER = ", ";

    public static void printInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printInputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResult() {
        System.out.println("실행결과");
    }

    public static void printCarsRoundResult(List<CarDto> cars) {
        for (CarDto car : cars) {
            printCarProgress(car);
        }
        System.out.println();
    }

    private static void printCarProgress(CarDto carDto) {
        System.out.printf("%s : %s\n", carDto.getName(), convertPositionToDash(carDto.getPosition()));
    }

    private static String convertPositionToDash(int position) {
        return POSITION_INDICATOR.repeat(position);
    }

    public static void printWinners(List<CarDto> winners) {
        System.out.printf("최종 우승자 : %s", formatWinnerNames(winners));
    }

    private static String formatWinnerNames(List<CarDto> winners) {
        return winners.stream()
                .map(CarDto::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }
}