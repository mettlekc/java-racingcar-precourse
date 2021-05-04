package woocamp.racingcar.view;

import woocamp.racingcar.constant.Print;

import java.util.Map;

public class View {
    public static void print(Print resistCar) {
        System.out.println(resistCar.getMessage());
    }

    public static void printResult(Map<String, Integer> locations) {
        for (Map.Entry<String, Integer> entry : locations.entrySet()) {
            String name = entry.getKey();
            int location = entry.getValue();
            printLocation(name, location);
        }
    }

    public static void printLocation(String name, int location) {
        System.out.println(name + ":" + location(location));
    }

    private static String location(int location) {
        String line = "";
        while (location-- > 0) {
            line += "-";
        }
        return line;
    }
}
