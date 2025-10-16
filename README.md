# java-calculator-precourse

# 문자열 덧셈 계산기

## 구현할 기능 목록 (Feature List)

### [계산기 기능]

### 1. **구분자 파싱 (Delimiter Parsing)**

- [ ] 쉼표(`,`) 또는 콜론(`:`)을 기본 구분자로 사용해 숫자를 분리한다.
- [ ] 분리된 숫자들을 정수로 변환하고 합산한다.
- [ ] 문자열이 `"//[구분자]\n[숫자들]"` 형태일 경우, 지정된 커스텀 구분자를 추출한다.
- [ ] 커스텀 구분자가 있는 경우, 기본 구분자에 커스텀 구분자를 추가한다.

### 2. **숫자 추출 (Number Extraction)**

- [ ] 입력 문자열을 구분자로 분리한다.
- [ ] 각 토큰이 올바른 정수인지 검증
    - [ ] 음수가 포함될 경우 `IllegalArgumentException`을 발생시킨다.
    - [ ] 숫자가 아닌 값이 들어오면 `IllegalArgumentException`을 발생시킨다.

### 3. **계산 (Calculation)**

- [ ] 추출된 숫자들을 모두 더해서 반환한다.

<br/>

### [입출력 처리 기능]

### 1. **입력 처리 (Input Handling)**

- [ ] 콘솔로부터 문자열 입력을 받는다.
- [ ] 입력이 비어있는 경우(`""`) 0을 반환한다.
- [ ] 입력 문자열이 잘못된 형식일 경우 `IllegalArgumentException`을 발생시킨다.

### 2. **출력 처리 (Output Handling)**

- [ ] 계산된 합을 `"결과 : [합]"` 형태로 출력한다.

---

## +) 이번 주차 추가 목표

- [ ] TDD로 구현해보기

- [ ] 우아한 테크코스 커밋, [컨벤션](https://github.com/woowacourse/woowacourse-docs/blob/main/cleancode/pr_checklist.md) 지키기