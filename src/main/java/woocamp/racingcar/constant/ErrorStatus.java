package woocamp.racingcar.constant;

public enum ErrorStatus {
    MAX_ROUND_COUNT_EXCEEDED("시도할 회수는 %d보다 작을 수 없습니다"),
    NO_LEFT_ROUND("진행 할 라운드가 남아 있지 않습니다"),
    CAR_NAME_LENGTH_EXCEEDED("자동차 이름은 최대 %d자리를 넘을 수 없습니다"),
    CAR_NAME_EMPTY("입력 된 자동차 이름이 없습니다"),
    EMPTY_CAR("입력 된 자동차가 없습니다");


    private String cause;

    ErrorStatus(String cause) {
        this.cause = cause;
    }

    public String getCause() {
        return this.cause;
    }
}
