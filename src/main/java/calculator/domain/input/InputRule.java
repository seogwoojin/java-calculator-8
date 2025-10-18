package calculator.domain.input;

public interface InputRule {
    boolean supports(String input);

    ParsedInput parse(String input);
}