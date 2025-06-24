package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
	@DisplayName("자동차는 이동 조건이 true이면 1칸 전진한다.")
	@Test
	void moveIncrementsPositionWhenStrategyIsTrue() {
		MoveStrategy alwaysMove = () -> true;
		Car car = new Car("pobi", alwaysMove);

		car.move();

		assertThat(car.getPosition()).isEqualTo(1);
	}

	@DisplayName("자동차는 이동 조건이 false이면 정지한다.")
	@Test
	void moveDoesNotChangePositionWhenStrategyIsFalse() {
		MoveStrategy neverMove = () -> false;
		Car car = new Car("pobi", neverMove);

		car.move();

		assertThat(car.getPosition()).isZero();
	}
}