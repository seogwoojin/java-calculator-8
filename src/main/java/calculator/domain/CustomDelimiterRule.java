package calculator.domain;

import java.util.Set;

public class CustomDelimiterRule implements InputRule {

    @Override
    public boolean supports(String input) {
        return false;
    }

    @Override
    public ParsedInput parse(String input) {
        return new ParsedInput("", Set.of());
    }
}
