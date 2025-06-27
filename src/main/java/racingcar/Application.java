package racingcar;

import racingcar.controller.RaceGameController;
import racingcar.domain.RandomMoveStrategy;

public class Application {
    public static void main(String[] args) {
        RaceGameController controller = new RaceGameController(new RandomMoveStrategy());
        controller.play();
    }
}