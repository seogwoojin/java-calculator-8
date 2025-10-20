package calculator.domain.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CustomDelimiterRuleTest {

    private final CustomDelimiterRule rule = new CustomDelimiterRule();

    @Test
    @DisplayName("supports: 커스텀 구분자 패턴을 만족하면 true를 반환한다")
    void supportsValidPattern() {
        // given
        String input1 = "//;\\n1;2;3";
        String input2 = "//*\\n4*5";

        // when & then
        assertThat(rule.supports(input1)).isTrue();
        assertThat(rule.supports(input2)).isTrue();
    }

    @Test
    @DisplayName("supports: 커스텀 구분자를 만족하지 않는 패턴은 false를 반환한다")
    void supportsInvalidPattern() {
        // given
        String noDelimiter = "//\\n1;2;3";
        String multiDelimiter = "//;;\\n1;2;3";
        String defaultInput = "1,2,3";
        String empty = "";

        // when & then
        assertThat(rule.supports(noDelimiter)).isFalse();
        assertThat(rule.supports(multiDelimiter)).isFalse();
        assertThat(rule.supports(defaultInput)).isFalse();
        assertThat(rule.supports(empty)).isFalse();
    }

    @Test
    @DisplayName("parse: 커스텀 구분자를 추출하고 기본 구분자에 추가한다")
    void parseValidInput() {
        // given
        String input = "//;\\n1;2;3";

        // when
        ParsedInput result = rule.parse(input);

        // then
        assertThat(result.numbers()).isEqualTo("1;2;3");
        assertThat(result.delimiters()).containsExactlyInAnyOrder(",", ":", ";");
    }

    @Test
    @DisplayName("parse: 기본 구분자와 겹치는 커스텀 구분자는 추가되지 않는다")
    void parseIgnoresDuplicateCustomDelimiter() {
        // given
        String input = "//,\\n1;2;3";

        // when
        ParsedInput result = rule.parse(input);

        // then
        assertThat(result.numbers()).isEqualTo("1;2;3");
        assertThat(result.delimiters()).containsExactlyInAnyOrder(",", ":");
    }

    @Test
    @DisplayName("parse: 잘못된 입력은 예외를 발생시킨다")
    void parseInvalidInput() {
        // given
        String invalid1 = "//\\n1;2;3";
        String invalid2 = "//;";

        // when & then
        assertThatThrownBy(() -> rule.parse(invalid1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 커스텀 구분자 입력");

        assertThatThrownBy(() -> rule.parse(invalid2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
