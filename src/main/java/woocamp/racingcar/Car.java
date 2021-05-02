package woocamp.racingcar;

import woocamp.racingcar.exception.CarNameOutOfLengthException;

public class Car {
    public static final int CAR_NAME_MAX = 5;
    private String name;
    private int pos;

    public Car(String name) {
        if (name.length() > CAR_NAME_MAX) {
            throw new CarNameOutOfLengthException();
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPos(Move.Status status) {
        return isMoveForward(status) ? ++pos : pos;
    }

    private boolean isMoveForward(Move.Status status) {
        return status == Move.Status.FORWARD;
    }
}
