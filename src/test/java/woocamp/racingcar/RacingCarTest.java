package woocamp.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import woocamp.racingcar.exception.RoundOutOfBoundsException;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {

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
        assertThat(racingCar.play()).isEqualTo(4);
        assertThat(racingCar.play()).isEqualTo(3);
        assertThat(racingCar.play()).isEqualTo(2);
        assertThat(racingCar.play()).isEqualTo(1);
        assertThat(racingCar.play()).isZero();

        assertThatThrownBy(() -> racingCar.play()).isInstanceOf(RoundOutOfBoundsException.class);
    }

    @Test
    void get_rank() {
        assertThat(racingCar.play()).isEqualTo(4);
        assertThat(racingCar.play()).isEqualTo(3);
        assertThat(racingCar.play()).isEqualTo(2);
        assertThat(racingCar.play()).isEqualTo(1);
        assertThat(racingCar.play()).isZero();

        assertThat(racingCar.rank()).isNotEmpty();
        assertThat(racingCar.rank()).containsAnyOf("pobi", "crong", "honux");
    }
}

