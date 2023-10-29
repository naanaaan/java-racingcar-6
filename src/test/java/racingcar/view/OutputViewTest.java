package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.domain.Cars;
import racingcar.service.CreateCarsService;

public class OutputViewTest extends NsTest {

	@DisplayName("현재 자동차들의 위치 상황의 메세지 출력을 확인한다.")
	@Test
	void checkPrintExecutionResult() {
		OutputView outputView = new OutputView();
		CreateCarsService createService = new CreateCarsService();

		Cars cars = createService.createCars("car1,car2,car3");
		
		outputView.printCarLocationCurrentSituation(cars.printCarsStatus());

		assertThat(output()).contains("car1 :", "car2 :", "car3 :");
	}
	
	@DisplayName("최종우승자 메세지 출력을 확인한다.")
	@Test
	void checkPrintWinner() {
		OutputView outputView = new OutputView();
		
		outputView.printWinner("car1, car2, car3");
		
		assertThat(output()).contains("최종 우승자 : car1, car2, car3");
	}
	
	@Override protected void runMain() {}
}