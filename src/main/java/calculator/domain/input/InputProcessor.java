package calculator.domain.input;

import java.util.ArrayList;
import java.util.List;

public class InputProcessor {
    private final List<InputRule> rules;

    public InputProcessor(List<InputRule> rules) {
        List<InputRule> copy = new ArrayList<>(rules);
        copy.add(new DefaultInputRule()); // 마지막 순서에 Default Fallback 용 클래스 추가
        this.rules = List.copyOf(copy);   // 불변화
    }

    public ParsedInput parseInput(String input) {
        return rules.stream()
                .filter(rule -> rule.supports(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 입력: " + input))
                .parse(input);
    }
}