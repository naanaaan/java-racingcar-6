package racingcar.validate;

import java.util.regex.Pattern;

public class TryCountValidator {
    private static final int MIN_TRY_COUNT = 1;
    private static final Pattern NUMERIC_REGEX = Pattern.compile("-?\\d+");

    public static void validatePositiveNumeric(String tryCountInput) {
        validateNumeric(tryCountInput);
        validatePositive(tryCountInput);
    }

    private static void validateNumeric(String tryCountInput) {
        if (!isNumeric(tryCountInput)) {
            throw new IllegalArgumentException(ErrorMessage.TRYCOUnT_NOT_NUMERIC.getMessage());
        }
    }

    private static boolean isNumeric(String tryCountInput) {
        return NUMERIC_REGEX.matcher(tryCountInput).matches();
    }

    private static void validatePositive(String tryCountInput) {
        if (!isPositive(tryCountInput)) {
            throw new IllegalArgumentException(ErrorMessage.TRYCOUNT_NOT_POSITIVE.getMessage());
        }
    }

    private static boolean isPositive(String tryCountInput) {
        int value = Integer.parseInt(tryCountInput);
        return value >= MIN_TRY_COUNT;
    }
}