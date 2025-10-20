package calculator.domain.input;

import java.util.Set;

/**
 * 커스텀 구분자를 충족시키지 않는 모든 문자
 */
class DefaultInputRule implements InputRule {

    private static final Set<String> DEFAULT_DELIMITERS = Set.of(",", ":");

    @Override
    public boolean supports(String input) {
        return true; // 나머지 전부 처리
    }

    @Override
    public ParsedInput parse(String input) {
        return new ParsedInput(input, DEFAULT_DELIMITERS);
    }
}
