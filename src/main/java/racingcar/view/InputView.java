package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validate.TryCountValidator;

public class InputView {
    public static int readTryCount() {
        String tryTiems = Console.readLine();
        TryCountValidator.validatePositiveNumeric(tryTiems);
        return Integer.parseInt(tryTiems);
    }
}