package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @Test
    @DisplayName("빈 문자열 입력이면 0을 반환한다")
    void givenEmptyInput_whenCalculate_thenReturnZero() {
        // given
        String input = "";

        // when
        int result = StringCalculator.calculate(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("쉼표 구분자로 숫자를 합산한다")
    void givenCommaDelimiter_whenCalculate_thenReturnSum() {
        // given
        String input = "1,2,3";

        // when
        int result = StringCalculator.calculate(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("콜론 구분자로 숫자를 합산한다")
    void givenColonDelimiter_whenCalculate_thenReturnSum() {
        // given
        String input = "1:2:3";

        // when
        int result = StringCalculator.calculate(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("쉼표와 콜론 혼합 구분자를 지원한다")
    void givenMixedDelimiters_whenCalculate_thenReturnSum() {
        // given
        String input = "1,2:3";

        // when
        int result = StringCalculator.calculate(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 지원한다")
    void givenCustomDelimiter_whenCalculate_thenReturnSum() {
        // given
        String input = "//;\n1;2;3";

        // when
        int result = StringCalculator.calculate(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 포함되면 예외를 던진다")
    void givenNegativeNumber_whenCalculate_thenThrowException() {
        // given
        String input = "1,-2,3";

        // when & then
        assertThatThrownBy(() -> StringCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수");
    }

    @Test
    @DisplayName("숫자가 아닌 값이 포함되면 예외를 던진다")
    void givenNonNumber_whenCalculate_thenThrowException() {
        // given
        String input = "1,2,a";

        // when & then
        assertThatThrownBy(() -> StringCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자");
    }
}
