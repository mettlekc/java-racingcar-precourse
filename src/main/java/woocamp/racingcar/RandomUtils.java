package woocamp.racingcar;

import java.util.Random;

public class RandomUtils {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    public static int random() {
        Random random = new Random();
        return random.nextInt((RANDOM_MAX - RANDOM_MIN) + 1) + RANDOM_MIN;
    }
}
