package calculator.domain.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultInputRuleTest {

    private final DefaultInputRule rule = new DefaultInputRule();

    @Test
    @DisplayName("supports: 어떤 입력이든 true를 반환한다")
    void supportsAlwaysTrue() {
        // given
        String normal = "1,2,3";
        String withColon = "4:5:6";
        String empty = "";

        // when & then
        assertThat(rule.supports(normal)).isTrue();
        assertThat(rule.supports(withColon)).isTrue();
        assertThat(rule.supports(empty)).isTrue();
    }

    @Test
    @DisplayName("parse: 입력을 그대로 numbers에 담고 기본 구분자만 추가한다")
    void parseReturnsInputAndDefaultDelimiters() {
        // given
        String input = "1,2:3";

        // when
        ParsedInput result = rule.parse(input);

        // then
        assertThat(result.numbers()).isEqualTo("1,2:3");
        assertThat(result.delimiters()).isEqualTo(Set.of(",", ":"));
    }

    @Test
    @DisplayName("parse: 빈 입력도 그대로 numbers에 담고 기본 구분자만 추가한다")
    void parseEmptyInput() {
        // given
        String input = "";

        // when
        ParsedInput result = rule.parse(input);

        // then
        assertThat(result.numbers()).isEqualTo("");
        assertThat(result.delimiters()).isEqualTo(Set.of(",", ":"));
    }
}
