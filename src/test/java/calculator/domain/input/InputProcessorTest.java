package calculator.domain.input;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputProcessorTest {

    private final InputProcessor processor = new InputProcessor(
            List.of(new CustomDelimiterRule())
    );

    @Test
    @DisplayName("빈 입력이면 numbers는 빈 문자열, delimiters는 기본 구분자만 가진다")
    void emptyInput() {
        // given
        String input = "";

        // when
        ParsedInput request = processor.parseInput(input);

        // then
        assertThat(request.numbers()).isEqualTo("");
        assertThat(request.delimiters()).isEqualTo(Set.of(",", ":"));
    }

    @Test
    @DisplayName("기본 구분자만 있는 입력은 그대로 numbers에 저장된다")
    void defaultDelimiters() {
        // given
        String input = "1,2:3";

        // when
        ParsedInput request = processor.parseInput(input);

        // then
        assertThat(request.numbers()).isEqualTo("1,2:3");
        assertThat(request.delimiters()).isEqualTo(Set.of(",", ":"));
    }

    @Test
    @DisplayName("커스텀 구분자가 있으면 기본 구분자에 추가된다")
    void customDelimiter() {
        // given
        String input = "//;\\n1;2;3";

        // when
        ParsedInput request = processor.parseInput(input);

        // then
        assertThat(request.numbers()).isEqualTo("1;2;3");
        assertThat(request.delimiters()).isEqualTo(Set.of(",", ":", ";"));
    }
}
