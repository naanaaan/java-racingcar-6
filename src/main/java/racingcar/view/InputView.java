package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validate.CarNameValidator;
import racingcar.validate.TryCountValidator;

public class InputView {
    private static final String CAR_NAME_DELIMITER = ",";

    private InputView() {};

    public static List<String> readCarNames() {
        String carNames = Console.readLine();
        List<String> parsedCarNames = Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .toList();
        parsedCarNames.forEach(CarNameValidator::validate);
        return parsedCarNames;
    }

    public static int readTryCount() {
        String tryTiems = Console.readLine();
        TryCountValidator.validatePositiveNumeric(tryTiems);
        return Integer.parseInt(tryTiems);
    }
}