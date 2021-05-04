package woocamp.racingcar.domain;

import woocamp.racingcar.constant.ErrorStatus;
import woocamp.racingcar.exception.EmptyCarException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {

    public static final String CAR_NAME_DELIMITER = ",";

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String input) {
        if (input.isEmpty())
            throw new EmptyCarException(ErrorStatus.EMPTY_CAR);

        String[] names = input.split(CAR_NAME_DELIMITER);
        cars = new ArrayList<>(names.length);
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public Map<String, Integer> getLocations() {
        Map<String, Integer> locations = new HashMap<>();
        for (Car car : cars) {
            locations.put(car.getName(), car.getLocation());
        }
        return locations;
    }
}