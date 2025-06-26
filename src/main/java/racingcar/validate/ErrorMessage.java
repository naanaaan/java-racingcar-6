package racingcar.validate;

public enum ErrorMessage {
    TRYCOUnT_NOT_NUMERIC("시도 횟수는 숫자만 입력할 수 있습니다."),
    TRYCOUNT_NOT_POSITIVE("시도 횟수는 1 이상이어야 합니다."),
    CAR_NAME_NOT_BLANK("자동차 이름은 빈 값이나 공백일 수 없습니다."),
    CAR_NAME_LENGTH_INVALID("자동차 이름은 1자 이상 5자 이하로 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}