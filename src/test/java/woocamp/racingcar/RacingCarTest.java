package woocamp.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import woocamp.racingcar.exception.RoundOutOfBoundsException;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarTest {

    private RacingCar racingCar;
    private int round;

    @BeforeEach
    void setUp() {
        round = 5;
        racingCar = new RacingCar("pobi,crong,honux", round);
    }

    @Test
    void create_cars_by_name() {
        assertThat(racingCar).isInstanceOf(RacingCar.class);
    }

    @Test
    void single_round_play() {
        assertThat(racingCar.play()).isEqualTo(4);
    }

    @Test
    void many_round_play() {
        assertThat(racingCar.play()).isEqualTo(4);
        Map<String, Integer> locations1 = racingCar.locations();

        assertThat(racingCar.play()).isEqualTo(3);
        Map<String, Integer> locations2 = racingCar.locations();

        assertThat(locations1).isNotEqualTo(locations2);
    }

    @Test
    void finish_round_play() {
        assertEquals(racingCar.play(), 4);
        assertEquals(racingCar.play(), 3);
        assertEquals(racingCar.play(), 2);
        assertEquals(racingCar.play(), 1);
        assertEquals(racingCar.play(), 0);

        assertThatThrownBy(() -> racingCar.play()).isInstanceOf(RoundOutOfBoundsException.class);
    }
}

