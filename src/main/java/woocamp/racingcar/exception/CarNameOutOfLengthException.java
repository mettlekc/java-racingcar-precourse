package woocamp.racingcar.exception;

import woocamp.racingcar.constant.ErrorStatus;

public class CarNameOutOfLengthException extends RuntimeException {
    public CarNameOutOfLengthException(ErrorStatus errorStatus, int lengthMaxCount) {
        super(String.format(errorStatus.getCause(), lengthMaxCount));
    }
}
