package calculator.domain;

import java.util.List;

public record ParsedInput(String numbers, List<String> delimiters) {
}
