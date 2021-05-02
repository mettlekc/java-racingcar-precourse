package woocamp.racingcar;

import java.util.Random;

public class Move {
    public static final int PAUSE_MAX = 3;

    public Status status(int number) {
        if (number <= PAUSE_MAX) {
            return Status.PAUSE;
        }
        return Status.FORWARD;
    }

    public Status status() {
        return status(RandomUtils.random(new Random()));
    }

    enum Status {
        PAUSE, FORWARD
    }
}
