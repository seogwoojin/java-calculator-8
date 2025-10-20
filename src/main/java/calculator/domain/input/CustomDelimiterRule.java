package calculator.domain.input;

import java.util.HashSet;
import java.util.Set;

public class CustomDelimiterRule implements InputRule {

    private static final Set<String> DEFAULT_DELIMITERS = Set.of(",", ":");

    @Override
    public boolean supports(String input) {
        // "//" + (임의의 문자 1개) + "\n" 로 시작하는 경우만 지원
        return input.matches("//.{1}\\\\n.*");
    }

    @Override
    public ParsedInput parse(String input) {
        String[] parts = input.split("\\\\n", 2);
        if (parts.length < 2 || parts[0].length() < 3) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 입력입니다: " + input);
        }

        String custom = parts[0].substring(2);

        Set<String> all = new HashSet<>(DEFAULT_DELIMITERS);
        all.add(custom);
        return new ParsedInput(parts[1], all);
    }
}
