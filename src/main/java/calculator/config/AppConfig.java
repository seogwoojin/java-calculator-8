package calculator.config;

import calculator.domain.StringCalculator;
import calculator.domain.input.CustomDelimiterRule;
import calculator.domain.input.InputProcessor;
import calculator.domain.input.InputRule;
import calculator.external.InputView;
import calculator.external.OutputView;
import java.util.List;

public class AppConfig {
    public StringCalculator stringCalculator() {
        List<InputRule> rules = List.of(
                new CustomDelimiterRule()
        );
        return new StringCalculator(new InputProcessor(rules));
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}