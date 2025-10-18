# java-calculator-precourse

# 문자열 덧셈 계산기

## 구현할 기능 목록 (Feature List)

### [계산기 기능]

#### 1. 입력 정제 (Input Processing)

- [X] 입력이 "//[구분자]\n[숫자들]" 형식이면 커스텀 구분자를 추출한다
    - [X] 커스텀 구분자가 있으면 기본 구분자에 추가한다. (중복은 제거)
    - [X] 구분자 뒤의 숫자들만 문자열로 추출한다.
- [ ] 그 외의 모든 입력 형식은 입력 문자열과, 기본 구분자를 반환한다.

### 2. **숫자 추출 (Number Extraction)**

## 2-1. 토큰화 (Tokenizer)

- [ ] 입력 문자열을 구분자로 분리한다.
- [ ] 빈 입력일 경우 빈 리스트를 반환한다.
- [ ] 여러 구분자가 섞여 있어도 모두 적용된다.

## 2-2. 숫자 검증 및 변환 (NumberValidator)

- [ ] 각 토큰이 올바른 정수인지 검증한다.
    - [ ] 음수가 포함되면 `IllegalArgumentException` 발생
    - [ ] 0이 포함되면 `IllegalArgumentException` 발생
    - [ ] 선행 0이 포함되면 `IllegalArgumentException` 발생
    - [ ] 숫자가 아닌 값이 포함되면 `IllegalArgumentException` 발생
    - [ ] 공백이 포함된 값은 `IllegalArgumentException` 발생
- [ ] 검증이 끝난 숫자를 양의 정수로 변환한다.

### 3. **계산 (Calculation)**

- [ ] 추출된 숫자들을 모두 더해서 반환한다.
- [ ] 입력 문자열이 비어있으면 합계는 0을 반환한다.

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