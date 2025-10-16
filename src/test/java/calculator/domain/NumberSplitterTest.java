package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberSplitterTest {

    @Test
    @DisplayName("쉼표와 콜론을 기본 구분자로 사용해 숫자를 분리한다")
    void givenDefaultDelimiters_whenParse_thenReturnNumbers() {
        // given
        String input = "1,2:3";
        List<String> delimiters = List.of(",", ":");

        // when
        int[] result = NumberSplitter.parse(input, delimiters);

        // then
        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("커스텀 구분자를 포함해 숫자를 분리한다")
    void givenCustomDelimiter_whenParse_thenReturnNumbers() {
        // given
        String input = "1;2;3";
        List<String> delimiters = List.of(",", ":", ";");

        // when
        int[] result = NumberSplitter.parse(input, delimiters);

        // then
        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("음수가 포함되면 예외를 던진다")
    void givenNegativeNumber_whenParse_thenThrowException() {
        // given
        String input = "1,-2,3";
        List<String> delimiters = List.of(",", ":");

        // when & then
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> NumberSplitter.parse(input, delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수는 허용되지 않습니다");
    }

    @Test
    @DisplayName("숫자가 아닌 값이 포함되면 예외를 던진다")
    void givenNonNumber_whenParse_thenThrowException() {
        // given
        String input = "1,a,3";
        List<String> delimiters = List.of(",", ":");

        // when & then
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> NumberSplitter.parse(input, delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 숫자 입력");
    }
}

