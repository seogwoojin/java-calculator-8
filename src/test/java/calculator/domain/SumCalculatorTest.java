package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SumCalculatorTest {

    @Test
    @DisplayName("숫자 리스트의 합을 계산한다")
    void sumNumbers() {
        // Given
        int[] numbers = new int[]{1,2,3};

        // When
        int result = SumCalculator.sum(numbers);

        // Then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("빈 리스트는 0을 반환한다")
    void returnZeroForEmptyList() {
        // Given
        int[] numbers = new int[]{};

        // When
        int result = SumCalculator.sum(numbers);

        // Then
        assertThat(result).isEqualTo(0);
    }
}
