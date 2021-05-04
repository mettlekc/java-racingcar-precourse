package woocamp.racingcar.domain;

import java.util.*;

public class Rank {

    private int top = Integer.MIN_VALUE;
    private Map<Integer, Set<String>> carsByPos;

    public Rank(Cars cars) {
        carsByPos = new HashMap<>();
        for (Car car : cars.getCars()) {
            top = Math.max(top, car.getLocation());
            addCarsByPos(car);
        }
    }

    private void addCarsByPos(Car car) {
        Set<String> list = getCarsByPos(car.getLocation());
        list.add(car.getName());
        carsByPos.put(car.getLocation(), list);
    }

    private Set<String> getCarsByPos(int pos) {
        Set<String> list = new HashSet<>();
        if (carsByPos.containsKey(pos)) {
            list = carsByPos.get(pos);
        }
        return list;
    }

    public Set<String> winners() {
        return carsByPos.get(top);
    }

}
