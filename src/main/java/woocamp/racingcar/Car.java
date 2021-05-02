package woocamp.racingcar;

import woocamp.racingcar.constant.ErrorStatus;
import woocamp.racingcar.exception.CarNameEmptyStringException;
import woocamp.racingcar.exception.CarNameOutOfLengthException;

public class Car {
    public static final int CAR_NAME_MAX = 5;

    private String name;
    private int pos;

    public Car(String name) {
        if (name.length() < 1)
            throw new CarNameEmptyStringException(ErrorStatus.CAR_NAME_EMPTY);
        if (name.length() > CAR_NAME_MAX)
            throw new CarNameOutOfLengthException(ErrorStatus.CAR_NAME_LENGTH_EXCEEDED, CAR_NAME_MAX);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int move(Move.Status status) {
        return isMoveForward(status) ? ++pos : pos;
    }

    public int move() {
        return move(Move.status());
    }

    public int getPos() {
        return this.pos;
    }

    private boolean isMoveForward(Move.Status status) {
        return status == Move.Status.FORWARD;
    }

}
