package woocamp.racingcar.exception;

import woocamp.racingcar.constant.ErrorStatus;

public class EmptyCarException extends RuntimeException {
    public EmptyCarException(ErrorStatus errorStatus) {
        super(errorStatus.getCause());
    }
}
