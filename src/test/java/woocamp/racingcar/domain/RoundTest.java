package woocamp.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import woocamp.racingcar.constant.ErrorStatus;
import woocamp.racingcar.exception.RoundOutOfBoundsException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    private Round three_round;
    private Round one_round;
    private Cars cars;

    @BeforeEach
    void setUp() {
        three_round = new Round(3);
        one_round = new Round(1);
        cars = new Cars("pobi,crong,honux");
    }

    @Test
    @DisplayName("라운드 생성 테스트")
    void create_round() {
        assertThat(three_round.getCurrentRound()).isEqualTo(3);
        assertThatThrownBy(() -> new Round(0)).isInstanceOf(RoundOutOfBoundsException.class)
                .hasMessage(ErrorStatus.MAX_ROUND_COUNT_EXCEEDED.getCause(), Round.ROUND_COUNT_MIN);
    }

    @Test
    @DisplayName("다음 라운드 처리 테스트")
    void next_round() {
        assertThat(three_round.next()).isEqualTo(2);
        assertThat(three_round.next()).isEqualTo(1);
    }

    @Test
    @DisplayName("많은 라운드 소진 시 예외 처리 테스트")
    void round_under_zero() {
        Round round = new Round(1);
        round.next();
        assertThatThrownBy(round::next)
                .isInstanceOf(RoundOutOfBoundsException.class)
                .hasMessage(ErrorStatus.NO_LEFT_ROUND.getCause());
    }

    @Test
    @DisplayName("싱글 라운드 소진 테스트")
    void round_play() {
        one_round.play(cars);
        assertThat(cars.getCars()).extracting(Car::getLocation).allMatch(c -> c >= 0);
    }

    @Test
    @DisplayName("싱글 라운드 모든 횟수 소진시 예외 처리 테스트")
    void round_over_play() {
        one_round.play(cars);
        assertThatThrownBy(() -> one_round.play(cars))
                .isInstanceOf(RoundOutOfBoundsException.class)
                .hasMessage(ErrorStatus.NO_LEFT_ROUND.getCause());
    }
}
