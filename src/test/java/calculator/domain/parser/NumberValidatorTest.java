package calculator.domain.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberValidatorTest {

    @Test
    @DisplayName("양수는 정상적으로 변환된다")
    void givenPositiveNumber_whenValidateAndParse_thenReturnValue() {
        // given
        String token = "123";

        // when
        int result = NumberValidator.validateAndParse(token);

        // then
        assertThat(result).isEqualTo(123);
    }

    @Test
    @DisplayName("0은 예외를 던진다")
    void givenZero_whenValidateAndParse_thenThrowException() {
        // given
        String token = "0";

        // when & then
        assertThatThrownBy(() -> NumberValidator.validateAndParse(token))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 이하의 숫자는 허용되지 않습니다");
    }

    @Test
    @DisplayName("음수는 예외를 던진다")
    void givenNegativeNumber_whenValidateAndParse_thenThrowException() {
        // given
        String token = "-5";

        // when & then
        assertThatThrownBy(() -> NumberValidator.validateAndParse(token))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 이하의 숫자는 허용되지 않습니다");
    }

    @Test
    @DisplayName("선행 0이 있는 숫자는 예외를 던진다")
    void givenLeadingZero_whenValidateAndParse_thenThrowException() {
        // given
        String token = "01";

        // when & then
        assertThatThrownBy(() -> NumberValidator.validateAndParse(token))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("선행 0은 허용되지 않습니다");
    }

    @Test
    @DisplayName("숫자가 아닌 값은 예외를 던진다")
    void givenNonNumber_whenValidateAndParse_thenThrowException() {
        // given
        String token = "abc";

        // when & then
        assertThatThrownBy(() -> NumberValidator.validateAndParse(token))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 숫자 입력");
    }

    @Test
    @DisplayName("빈 문자열은 예외를 던진다")
    void givenEmptyString_whenValidateAndParse_thenThrowException() {
        // given
        String token = "";

        // when & then
        assertThatThrownBy(() -> NumberValidator.validateAndParse(token))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 숫자 입력");
    }
}
