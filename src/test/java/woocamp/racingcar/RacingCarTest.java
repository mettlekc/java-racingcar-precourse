package woocamp.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
        racingCar = new RacingCar();
        racingCar.registCars("pobi,crong,honux");
        racingCar.registRound(round);
    }

    @Test
    @DisplayName("이름으로 자동차 생성 테스트")
    void create_cars_by_name() {
        assertThat(racingCar).isInstanceOf(RacingCar.class);
    }

    @Test
    @DisplayName("라운드 1회 플레이 테스트")
    void single_round_play() {
        assertThat(racingCar.play()).isEqualTo(4);
    }

    @Test
    @DisplayName("많은 라운드 수행 테스트")
    void many_round_play() {
        assertThat(racingCar.play()).isEqualTo(4);
        Map<String, Integer> locations1 = racingCar.locations();

        assertThat(racingCar.play()).isEqualTo(3);
        Map<String, Integer> locations2 = racingCar.locations();

        assertThat(locations1).isNotEqualTo(locations2);
    }

    @Test
    @DisplayName("모든 라운드 소진 시 예외처리 테스트")
    void finish_round_play() {
        assertThat(racingCar.play()).isEqualTo(4);
        assertThat(racingCar.play()).isEqualTo(3);
        assertThat(racingCar.play()).isEqualTo(2);
        assertThat(racingCar.play()).isEqualTo(1);
        assertThat(racingCar.play()).isZero();

        assertThatThrownBy(() -> racingCar.play()).isInstanceOf(RoundOutOfBoundsException.class);
    }

    @Test
    @DisplayName("라운드 종료 플래그 처리 테스트")
    void is_finish_round() {
        assertThat(racingCar.play()).isEqualTo(4);
        assertThat(racingCar.play()).isEqualTo(3);
        assertThat(racingCar.play()).isEqualTo(2);
        assertThat(racingCar.isNotFinish()).isTrue();
        assertThat(racingCar.play()).isEqualTo(1);
        assertThat(racingCar.play()).isZero();

        assertThat(racingCar.isNotFinish()).isFalse();
    }

    @Test
    @DisplayName("Winner 결과 처리 테스트")
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

