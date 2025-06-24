package racingcar.domain;

public class Car {
	private static int START_POSITION = 0;

	private String name;
	private MoveStrategy strategy;
	private int position;

	public Car(String name, MoveStrategy strategy) {
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
