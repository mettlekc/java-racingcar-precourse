package woocamp.racingcar;

import woocamp.racingcar.exception.CarNameOutOfLengthException;

public class Car {
    private String name;
    private int pos;

    public Car(String name) {
        if (name.length() > 5) {
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
