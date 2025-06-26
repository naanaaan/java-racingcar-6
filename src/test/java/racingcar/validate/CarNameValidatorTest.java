package racingcar.validate;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameValidatorTest {
    @DisplayName("자동차 이름이 빈 문자열 혹은 공백일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = { "", " ", "po bi" })
    void throwsIllegalArgumentExceptionIfIsBlank(String carName) {
        assertThatThrownBy(() -> CarNameValidator.validate(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_NOT_BLANK.getMessage());
    }

    @DisplayName("자동차 이름이 1~5자를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = { "imbabo", "youtoobabo" })
    void throwsIllegalArgumentExceptionIfInvalidLength(String carName) {
        assertThatThrownBy(() -> CarNameValidator.validate(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_LENGTH_INVALID.getMessage());
    }

    @DisplayName("옳바른 자동차 이름 입력 시, 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = { "bob", "h", "steve" })
    void notThrowExceptionIfValidCarName(String carName) {
        assertThatCode(() -> CarNameValidator.validate(carName))
                .doesNotThrowAnyException();
    }
}