package calculator.domain.input;

import java.util.Set;

public class InputProcessor {

    public ParsedInput parseInput(String input) {
        return new ParsedInput(input, Set.of());
    }
}
