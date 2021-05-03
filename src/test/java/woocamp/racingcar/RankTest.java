package woocamp.racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void create_rank() {
        Car car1 = new Car("phobi");
        Car car2 = new Car("crong");
        Car car3 = new Car("honux");

        car1.move(Move.Status.FORWARD);
        car1.move(Move.Status.FORWARD);
        car1.move(Move.Status.FORWARD);

        car2.move(Move.Status.FORWARD);
        car2.move(Move.Status.FORWARD);

        car3.move(Move.Status.FORWARD);

        Cars cars = new Cars(Arrays.asList(car1, car2, car3));
        List<Car> winners = new Rank(cars).winners();

        assertThat(winners).contains(car1, car2);
    }

}
