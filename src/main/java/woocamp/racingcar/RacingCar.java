package woocamp.racingcar;

import woocamp.racingcar.domain.Cars;
import woocamp.racingcar.domain.Rank;
import woocamp.racingcar.domain.Round;

import java.util.Map;
import java.util.Set;

public class RacingCar {

    private final Cars cars;
    private final Round round;

    public RacingCar(String input, int count) {
        cars = new Cars(input);
        round = new Round(count);
    }

    public int play() {
        return round.play(cars);
    }

    public Map<String, Integer> locations() {
        return cars.getLocations();
    }

    public Set<String> rank() {
        return new Rank(cars).winners();
    }

    public boolean isNotFinish() {
        return round.getCurrentRound() != 0;
    }

}
