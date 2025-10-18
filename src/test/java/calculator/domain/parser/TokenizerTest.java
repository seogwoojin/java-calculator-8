package calculator.domain.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class TokenizerTest {

    @Test
    @DisplayName("빈 입력이면 빈 리스트를 반환한다")
    void givenEmptyInput_whenSplit_thenReturnEmptyList() {
        // given
        String input = "";
        Set<String> delimiters = Set.of(",", ":");

        // when
        List<String> result = Tokenizer.split(input, delimiters);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("기본 구분자로 분리한다")
    void givenDefaultDelimiters_whenSplit_thenReturnTokens() {
        // given
        String input = "1,2:3";
        Set<String> delimiters = Set.of(",", ":");

        // when
        List<String> result = Tokenizer.split(input, delimiters);

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("여러 구분자가 섞여 있어도 올바르게 분리된다")
    void givenMixedDelimiters_whenSplit_thenReturnTokens() {
        // given
        String input = "1,2:3;4";
        Set<String> delimiters = Set.of(",", ":", ";");

        // when
        List<String> result = Tokenizer.split(input, delimiters);

        // then
        assertThat(result).containsExactly("1", "2", "3", "4");
    }

    @Test
    @DisplayName("구분자가 연속되면 빈 문자열 토큰이 생긴다")
    void givenConsecutiveDelimiters_whenSplit_thenReturnEmptyToken() {
        // given
        String input = "1,,2";
        Set<String> delimiters = Set.of(",", ":");

        // when
        List<String> result = Tokenizer.split(input, delimiters);

        // then
        assertThat(result).containsExactly("1", "", "2");
    }
}
