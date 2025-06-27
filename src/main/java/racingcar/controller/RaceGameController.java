package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.domain.CarFactory;
import racingcar.domain.MoveStrategy;
import racingcar.domain.Race;
import racingcar.mapper.CarMapper;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceGameController {
    private final MoveStrategy strategy;

    public RaceGameController(MoveStrategy strategy) {
        this.strategy = strategy;
    }

    public void play() {
        Race race = prepareRace();
        int tryCount = readTryCount();

        runRace(race, tryCount);
        showWinners(race);
    }

    private Race prepareRace() {
        return new Race(prepareCars());
    }

    private List<Car> prepareCars() {
        OutputView.printInputCarNames();
        List<String> names = InputView.readCarNames();
        return CarFactory.createCars(names, strategy);
    }

    private int readTryCount() {
        OutputView.printInputTryCount();
        return InputView.readTryCount();
    }

    private void runRace(Race race, int tryCount) {
        OutputView.printRaceResultHeader();
        for (int i = 0; i < tryCount; i++) {
            race.moveAll();
            OutputView.printCarsRoundResult(toCarDtos(race.getCars()));
        }
    }

    private void showWinners(Race race) {
        OutputView.printWinners(toCarDtos(race.findWinners()));
    }

    private List<CarDto> toCarDtos(List<Car> cars) {
        return CarMapper.toCarDtos(cars);
    }
}