package woocamp.racingcar;

import woocamp.racingcar.domain.Cars;
import woocamp.racingcar.domain.Rank;
import woocamp.racingcar.domain.Round;

import java.util.Map;
import java.util.Set;

public class RacingCar {

    private Cars cars;
    private Round round;

    public void registCars(String input) {
        cars = new Cars(input);
    }

    public void registRound(int count) {
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
