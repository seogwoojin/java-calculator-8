package calculator.domain;

import calculator.domain.input.InputProcessor;
import calculator.domain.input.ParsedInput;
import calculator.domain.parser.NumberSplitter;
import calculator.domain.util.CalculatorUtils;

/**
 * 문자열 계산기 오케스트레이터
 */
public class StringCalculator {

    private final InputProcessor inputProcessor;

    public StringCalculator(InputProcessor inputProcessor) {
        this.inputProcessor = inputProcessor;
    }

    public int calculate(String input) {
        ParsedInput parsedInput = inputProcessor.parseInput(input);

        int[] parse = NumberSplitter.parse(parsedInput.numbers(), parsedInput.delimiters());

        return CalculatorUtils.sum(parse);
    }
}
