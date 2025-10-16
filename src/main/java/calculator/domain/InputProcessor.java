package calculator.domain;

import java.util.List;

public class InputProcessor {

    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");

    public static ParsedInput parseInput(String input) {
        return new ParsedInput(input, DEFAULT_DELIMITERS);
    }
}
