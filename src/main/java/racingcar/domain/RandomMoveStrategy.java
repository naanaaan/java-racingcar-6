package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
	private static int MIN_NUMBER = 0;
	private static int MAX_NUMBER = 9;
	private static int MOVE_CONDITION_NUMBER = 4;

	@Override
	public boolean isMovable() {
		return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER) >= MOVE_CONDITION_NUMBER;
	}
}