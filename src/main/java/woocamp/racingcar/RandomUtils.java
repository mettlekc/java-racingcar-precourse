package woocamp.racingcar;

import java.util.Random;

public class RandomUtils {
    private static final int RANDOM_MAX = 10;

    private RandomUtils() {
        throw new IllegalStateException("Cannot create this instance");
    }

    public static int random(Random random) {
        return random.nextInt(RANDOM_MAX);
    }
}
