package racingcar.domain;

import racingcar.validate.CarNameValidator;

public class Car {
    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;

    private static final int START_POSITION = 0;

    private final String name;
    private final MoveStrategy strategy;
    private int position;

    public Car(String name, MoveStrategy strategy) {
        CarNameValidator.validate(name);
        this.name = name;
        this.position = START_POSITION;
        this.strategy = strategy;
    }

    public void move() {
        if (strategy.isMovable()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}