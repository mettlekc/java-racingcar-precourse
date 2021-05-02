package woocamp.racingcar.exception;

import woocamp.racingcar.constant.ErrorStatus;

public class CarNameEmptyStringException extends RuntimeException {
    public CarNameEmptyStringException(ErrorStatus errorStatus) {
        super(errorStatus.getCause());
    }
}
