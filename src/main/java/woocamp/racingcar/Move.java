package woocamp.racingcar;

import woocamp.racingcar.util.RandomUtils;

import java.util.Random;

public class Move {
    public static final int PAUSE_NUMBER_MAX = 3;

    public static Status status(int number) {
        if (number <= PAUSE_NUMBER_MAX) {
            return Status.PAUSE;
        }
        return Status.FORWARD;
    }

    public static Status status() {
        return status(RandomUtils.random(new Random()));
    }

    enum Status {
        PAUSE, FORWARD
    }
}
