package woocamp.racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void create_rank() {
        Car phobi = createSampleCar("phobi", 3);
        Car crong = createSampleCar("crong", 2);
        Car honux = createSampleCar("honux", 1);

        List<Car> list = Arrays.asList(phobi, crong, honux);
        assertThat(getWinner(list)).contains("phobi");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "phobi:3,crong:2,honux:1=phobi",
            "phobi:3,crong:3,honux:1=phobi,crong",
            "phobi:0,crong:0,honux:0=phobi,crong,honux",
            "phobi:3=phobi",
    }, delimiter = '=')
    void many_rank_Case(String samples, String expected) {
        assertThat(getWinner(getSampleCars(samples)))
                .containsExactlyInAnyOrder(expected.split(","));
    }

    private Set<String> getWinner(List<Car> list) {
        Cars cars = new Cars(list);
        return new Rank(cars).winners();
    }

    private List<Car> getSampleCars(String samples) {
        String[] split = samples.split(",");
        List<Car> list = new ArrayList<>(split.length);
        for (String info : split) {
            String[] splitInfo = info.split(":");
            list.add(createSampleCar(splitInfo[0], Integer.valueOf(splitInfo[1])));
        }
        return list;
    }

    private Car createSampleCar(String name, int move) {
        Car car = new Car(name);
        while(move-- > 0) {
            car.move(Move.Status.FORWARD);
        }
        return car;
    }

}
