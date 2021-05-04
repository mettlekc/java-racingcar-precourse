package woocamp.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class MoveTest {
    private Move move;

    @BeforeEach
    void setUp() {
        move = new Move();
    }

    @Test
    @DisplayName("자동차 이동 상태 테스트")
    void move_forward() {
        assertThat(move.status(4)).isEqualTo(Move.Status.FORWARD);
    }

    @Test
    @DisplayName("자동차 멈춤 상태 테스트")
    void move_pause() {
        assertThat(move.status(3)).isEqualTo(Move.Status.PAUSE);
    }

    @Test
    @DisplayName("자동차 랜덤 이동 테스트")
    void move_random() {
        assertThat(move.status()).isIn(Move.Status.FORWARD, Move.Status.PAUSE);

        Set<Move.Status> moves = new HashSet<>();
        IntStream.range(0, 1000).forEach(e -> moves.add(move.status()));
        assertThat(moves).contains(Move.Status.FORWARD, Move.Status.PAUSE);
    }
}
