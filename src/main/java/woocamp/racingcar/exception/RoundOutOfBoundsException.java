package woocamp.racingcar.exception;

import woocamp.racingcar.constant.ErrorStatus;

public class RoundOutOfBoundsException extends RuntimeException{
    public RoundOutOfBoundsException(ErrorStatus errorStatus, int minimumRoundCount) {
        this(String.format(errorStatus.getCause(), minimumRoundCount));
    }

    public RoundOutOfBoundsException(ErrorStatus errorStatus) {
        this(errorStatus.getCause());
    }

    public RoundOutOfBoundsException(String cause) {
        super(cause);
    }
}
