package calculator.domain.input;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterRule implements InputRule {

    private static final Pattern CUSTOM_PATTERN = Pattern.compile("^//(.)\\\\n(.*)", Pattern.DOTALL);

    @Override
    public boolean supports(String input) {
        return CUSTOM_PATTERN.matcher(input).matches();
    }

    @Override
    public ParsedInput parse(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);

        String custom = matcher.group(1);
        if (Character.isDigit(custom.charAt(0))) {
            throw new IllegalArgumentException("숫자는 구분자로 사용할 수 없습니다: " + custom);
        }

        Set<String> delimiters = new HashSet<>(Delimiters.DEFAULT);
        delimiters.add(custom);
        return new ParsedInput(matcher.group(2), delimiters);
    }
}
