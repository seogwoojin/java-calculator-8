package calculator.domain;

import java.util.Set;

public record ParsedInput(String numbers, Set<String> delimiters) {
}
