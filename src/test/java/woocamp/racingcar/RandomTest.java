package woocamp.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RandomTest {
    @RepeatedTest(1000)
    @DisplayName("랜덤 숫자가 0에서 9사이에 있는지 확인")
    void random_number_between_zero_and_nine() {
        int number = RandomUtils.random();
        assertThat(number).isBetween(0, 9);
    }

    @Test
    @DisplayName("범위 내 숫자가 모두 존재하는지 확인")
    void check_numbers_exactly_in_range() {
        Set<Integer> numbers = new HashSet<>();
        IntStream.range(0, 1000).forEach(e -> numbers.add(RandomUtils.random()));
        assertThat(numbers).containsExactly(0,1,2,3,4,5,6,7,8,9);
    }
}