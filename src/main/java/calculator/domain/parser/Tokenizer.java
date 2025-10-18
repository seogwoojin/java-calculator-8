package calculator.domain.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

class Tokenizer {
    static List<String> split(String input, Set<String> delimiters) {
        if (input.isBlank()) {
            return List.of();
        }

        String regex = String.join("|", delimiters);
        return Arrays.asList(input.split(regex));
    }
}
