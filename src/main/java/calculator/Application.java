package calculator;

import calculator.config.AppConfig;
import calculator.domain.StringCalculator;
import calculator.external.InputView;
import calculator.external.OutputView;

public class Application {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();

        StringCalculator stringCalculator = config.stringCalculator();
        InputView inputView = config.inputView();
        OutputView outputView = config.outputView();

        String input = inputView.readExpression();
        int result = stringCalculator.calculate(input);
        outputView.printResult(result);
    }
}
