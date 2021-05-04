package woocamp.racingcar.constant;

public enum Print {
    REGIST_CAR("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REGIST_ROUND("시도할 회수는 몇회인가요?"),
    RESULT_TITLE("실행 결과");

    String message;

    Print(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
