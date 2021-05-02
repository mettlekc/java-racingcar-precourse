package woocamp.racingcar.exception;

public class CarNameOutOfLengthException extends RuntimeException {
    public CarNameOutOfLengthException(String cause, int lengthMaxCount) {
        super(String.format(cause, lengthMaxCount));
    }
}
