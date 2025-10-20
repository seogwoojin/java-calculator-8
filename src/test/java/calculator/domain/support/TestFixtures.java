package calculator.domain.support;

import calculator.domain.input.CustomDelimiterRule;
import calculator.domain.input.InputProcessor;
import java.util.List;

public class TestFixtures {
    public static InputProcessor defaultProcessor() {
        return new InputProcessor(List.of(new CustomDelimiterRule()));
    }
}