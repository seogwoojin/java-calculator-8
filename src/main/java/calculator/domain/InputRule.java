package calculator.domain;

public interface InputRule {
    boolean supports(String input);
    ParsedInput parse(String input);
}