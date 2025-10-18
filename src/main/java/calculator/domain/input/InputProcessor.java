package calculator.domain.input;

import java.util.List;

public class InputProcessor {

    private final List<InputRule> rules = List.of(
            new CustomDelimiterRule(),
            new DefaultInputRule()
    );

    public ParsedInput parseInput(String input) {
        return rules.stream()
                .filter(rule -> rule.supports(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 입력: " + input))
                .parse(input);
    }
}
