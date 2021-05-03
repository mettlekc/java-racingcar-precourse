package woocamp.racingcar.util;

import woocamp.racingcar.constant.ErrorStatus;

import java.util.Random;

public class RandomUtils {
    private static final int RANDOM_MAX = 10;

    private RandomUtils() {
        throw new IllegalStateException(ErrorStatus.CANNOT_CREATE_THIS_INSTANCE.getCause());
    }

    public static int random(Random random) {
        return random.nextInt(RANDOM_MAX);
    }
}
