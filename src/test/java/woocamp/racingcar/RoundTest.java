package woocamp.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import woocamp.racingcar.exception.RoundOutOfBoundsException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    private Round third_round;

    @BeforeEach
    void setUp() {
        third_round = new Round(3);
    }

    @Test
    void create_round() {
        assertThat(third_round.getCurrentRound()).isEqualTo(3);
        assertThatThrownBy(() -> new Round(0)).isInstanceOf(RoundOutOfBoundsException.class)
                .hasMessage("시도할 회수는 %d보다 작을 수 없습니다", Round.ROUND_COUNT_MIN);
    }

    @Test
    void next_round() {
        assertThat(third_round.next()).isEqualTo(2);
        assertThat(third_round.next()).isEqualTo(1);
    }

    @Test
    void round_under_zero() {
        Round round = new Round(1);
        assertThatThrownBy(round::next)
                .isInstanceOf(RoundOutOfBoundsException.class)
                .hasMessage("진행 할 라운드가 남아 있지 않습니다");
    }
}
