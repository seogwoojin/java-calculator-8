package calculator.domain.input;

import java.util.Set;

public record ParsedInput(String numbers, Set<String> delimiters) {
}
