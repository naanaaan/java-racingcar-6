package racingcar.validate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryCountValidatorTest {
    @DisplayName("시도 횟수가 숫자가 아닌 경우 IllegalArgumentException  발생한다.")
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
}