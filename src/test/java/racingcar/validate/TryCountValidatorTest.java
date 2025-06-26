package racingcar.validate;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryCountValidatorTest {
    @DisplayName("시도 횟수가 숫자가 아닌 경우 IllegalArgumentException 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = { "?", " ", "a" })
    void trowsIllegalArgumentExceptionIfNotNummeric(String tryCount) {
        assertThatThrownBy(() -> TryCountValidator.validatePositiveNumeric(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.TRYCOUnT_NOT_NUMERIC.getMessage());
    }

    @DisplayName("시도 횟수가 1 미만일 경우 IllegalArgumentException 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = { "0", "-1", "-3" })
    void throwsIllegalArgumentExceptionIfNotPositiveNumeric(String tryCount) {
        assertThatThrownBy(() -> TryCountValidator.validatePositiveNumeric(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.TRYCOUNT_NOT_POSITIVE.getMessage());
    }

    @DisplayName("옳바른 시도 횟수 입력 시, 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = { "1", "5", "10" })
    void notThrowExceptionIfValidTryCount(String carName) {
        assertThatCode(() -> TryCountValidator.validatePositiveNumeric(carName))
                .doesNotThrowAnyException();
    }
}