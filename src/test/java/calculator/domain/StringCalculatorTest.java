package calculator.domain;

import calculator.domain.input.CustomDelimiterRule;
import calculator.domain.input.DefaultInputRule;
import calculator.domain.input.InputProcessor;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;

class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator(new InputProcessor(
            List.of(new CustomDelimiterRule(), new DefaultInputRule())
    ));

    @Test
    @DisplayName("빈 문자열은 0을 반환한다")
    void emptyInput_returnsZero() {
        // given
        String input = "";

        // when
        int result = calculator.calculate(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("쉼표와 콜론 혼합 구분자를 지원한다 (기본 구분자)")
    void mixedDelimiters_returnsSum() {
        // given
        String input = "1,2:3";

        // when
        int result = calculator.calculate(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 지원한다")
    void customDelimiter_returnsSum() {
        // given
        String input = "//;\n1;2;3";

        // when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 포함되면 예외 발생")
    void negativeNumber_throwsException() {
        // given
        String input = "1,-2,3";

        // when & then
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 값이 포함되면 예외 발생")
    void nonNumber_throwsException() {
        // given
        String input = "1,2,a";

        // when & then
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
