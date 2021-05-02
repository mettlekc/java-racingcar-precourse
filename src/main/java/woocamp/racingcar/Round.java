package woocamp.racingcar;

import woocamp.racingcar.exception.RoundOutOfBoundsException;

public class Round {
    public static final int ROUND_COUNT_MIN = 1;
    private int round;

    public Round(int round) {
        if (round < ROUND_COUNT_MIN)
            throw new RoundOutOfBoundsException("시도할 회수는 %d보다 작을 수 없습니다", ROUND_COUNT_MIN);
        this.round = round;
    }

    public int getCurrentRound() {
        return round;
    }

    public int next() {
        if (round - 1 < ROUND_COUNT_MIN)
            throw new RoundOutOfBoundsException("진행 할 라운드가 남아 있지 않습니다");
        return --round;
    }
}
