package calculator.domain.parser;

class NumberValidator {
    static int validateAndParse(String token) {
        try {
            int value = Integer.parseInt(token);

            if (value <= 0) {
                throw new IllegalArgumentException("0 이하의 숫자는 허용되지 않습니다: " + token);
            }
            if (token.length() > 1 && token.startsWith("0")) {
                throw new IllegalArgumentException("선행 0은 허용되지 않습니다: " + token);
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 입력: " + token, e);
        }
    }
}
