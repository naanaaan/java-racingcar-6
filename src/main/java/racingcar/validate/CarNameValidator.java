package racingcar.validate;

import racingcar.domain.Car;

public class CarNameValidator {
    public static void validate(String carName) {
        validateNotBlank(carName);
        validateLength(carName);
    }

    private static void validateNotBlank(String carName) {
        if (isBlank(carName)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_NOT_BLANK.getMessage());
        }
    }

    private static boolean isBlank(String carName) {
        return carName.isEmpty() || carName.chars().anyMatch(Character::isWhitespace);
    }

    private static void validateLength(String carName) {
        if (!isValidLength(carName.length())) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_INVALID.getMessage());
        }
    }

    private static boolean isValidLength(int carNameLength) {
        return carNameLength >= Car.MIN_NAME_LENGTH && carNameLength <= Car.MAX_NAME_LENGTH;
    }
}