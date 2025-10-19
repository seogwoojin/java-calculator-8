package calculator.domain.util;

import java.util.Arrays;

public class CalculatorUtils {
    public static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
