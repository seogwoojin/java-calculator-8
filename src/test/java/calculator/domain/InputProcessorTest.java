package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputProcessorTest {

    @Test
    @DisplayName("빈 입력이면 numbers는 빈 문자열, delimiters는 기본 구분자만 가진다")
    void emptyInput() {
        ParsedInput request = InputProcessor.parseInput("");
        assertThat(request.numbers()).isEqualTo("");
        assertThat(request.delimiters()).containsExactly(",", ":");
    }

    @Test
    @DisplayName("기본 구분자만 있는 입력은 그대로 numbers에 저장된다")
    void defaultDelimiters() {
        ParsedInput request = InputProcessor.parseInput("1,2:3");
        assertThat(request.numbers()).isEqualTo("1,2:3");
        assertThat(request.delimiters()).containsExactly(",", ":");
    }

    @Test
    @DisplayName("커스텀 구분자가 있으면 기본 구분자에 추가된다")
    void customDelimiter() {
        ParsedInput request = InputProcessor.parseInput("//;\n1;2;3");
        assertThat(request.numbers()).isEqualTo("1;2;3");
        assertThat(request.delimiters()).containsExactly(",", ":", ";");
    }

    @Test
    @DisplayName("잘못된 커스텀 구분자 입력은 예외를 던진다")
    void invalidCustomDelimiter() {
        assertThatThrownBy(() -> InputProcessor.parseInput("//\n1;2;3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 커스텀 구분자 입력");
    }
}
