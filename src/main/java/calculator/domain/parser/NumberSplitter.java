package calculator.domain.parser;

import java.util.Set;

/**
 * 문자열을 정수 배열로 파싱하는 기능의 오케스트레이션 담당
 */
public class NumberSplitter {
    public static int[] parse(String numberString, Set<String> delimiters) {
        return Tokenizer.split(numberString, delimiters).stream()
                .mapToInt(NumberValidator::validateAndParse) // 검증 + int 변환
                .toArray(); // 최종 int 배열 반환
    }
}
