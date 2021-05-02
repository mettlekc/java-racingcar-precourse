package woocamp.racingcar.exception;

public class RoundOutOfBoundsException extends RuntimeException{
    public RoundOutOfBoundsException(String cause, int minimumRoundCount) {
        super(String.format(cause, minimumRoundCount));
    }
}
