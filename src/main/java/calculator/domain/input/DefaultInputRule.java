package calculator.domain.input;

import java.util.Set;

/**
 * 커스텀 구분자를 충족시키지 않는 모든 문자
 */
public class DefaultInputRule implements InputRule {

    @Override
    public boolean supports(String input) {
        return true;
    }

    @Override
    public ParsedInput parse(String input) {
        return new ParsedInput("", Set.of());
    }
}
