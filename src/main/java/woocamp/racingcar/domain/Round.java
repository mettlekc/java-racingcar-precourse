package woocamp.racingcar.domain;

import woocamp.racingcar.constant.ErrorStatus;
import woocamp.racingcar.exception.RoundOutOfBoundsException;

public class Round {
    public static final int ROUND_COUNT_MIN = 1;
    private int round;

    public Round(int round) {
        if (round < ROUND_COUNT_MIN)
            throw new RoundOutOfBoundsException(ErrorStatus.MAX_ROUND_COUNT_EXCEEDED, ROUND_COUNT_MIN);
        this.round = round;
    }

    public int getCurrentRound() {
        return round;
    }

    public int next() {
        if (round < ROUND_COUNT_MIN)
            throw new RoundOutOfBoundsException(ErrorStatus.NO_LEFT_ROUND);
        return --round;
    }

    public int play(Cars cars) {
        cars.move();
        return next();
    }
}