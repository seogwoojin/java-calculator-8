package calculator.domain.parser;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NumberSplitterTest {

    @Test
    @DisplayName("기본 구분자로 숫자를 분리한다")
    void splitEmptyWithDefaultDelimiters() {
        // given
        String input = "";
        Set<String> delimiters = Set.of(",", ":");

        // when
        int[] result = NumberSplitter.parse(input, delimiters);

        // then
        assertThat(result).isEmpty();
    }


    @Test
    @DisplayName("기본 구분자로 숫자를 분리한다")
    void splitWithDefaultDelimiters() {
        // given
        String input = "1,2:3";
        Set<String> delimiters = Set.of(",", ":");

        // when
        int[] result = NumberSplitter.parse(input, delimiters);

        // then
        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("커스텀 구분자를 포함해 숫자를 분리한다")
    void splitWithCustomDelimiter() {
        // given
        String input = "1;2;3";
        Set<String> delimiters = Set.of(",", ":", ";");

        // when
        int[] result = NumberSplitter.parse(input, delimiters);

        // then
        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("잘못된 입력은 예외를 던진다")
    void invalidInputThrowsException() {
        // given
        String input = "1,-2,a";

        // when & then
        assertThatThrownBy(() -> NumberSplitter.parse(input, Set.of(",", ":")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
