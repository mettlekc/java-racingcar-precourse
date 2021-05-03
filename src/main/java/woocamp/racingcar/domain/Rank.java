package woocamp.racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rank {

    private int top = Integer.MIN_VALUE;
    private Map<Integer, List<Car>> carsByPos;

    public Rank(Cars cars) {
        carsByPos = new HashMap<>();
        for (Car car : cars.getCars()) {
            top = Math.max(top, car.getPos());
            addCarsByPos(car);
        }
    }

    private void addCarsByPos(Car car) {
        List<Car> list = getCarsByPos(car.getPos());
        list.add(car);
        carsByPos.put(car.getPos(), list);
    }

    private List<Car> getCarsByPos(int pos) {
        List<Car> list = new ArrayList<>();
        if (carsByPos.containsKey(pos)) {
            list = carsByPos.get(pos);
        }
        return list;
    }

    public List<Car> winners() {
        return carsByPos.get(top);
    }

}
