package woocamp.racingcar.view;

import woocamp.racingcar.constant.Print;

import java.util.Map;
import java.util.Set;

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

    public static void printWinners(Set<String> winners) {
        String result = String.join(",", winners.toArray(new String[0]));
        System.out.println(result + Print.WINNER.getMessage());

    }

    private static String location(int location) {
        String line = "";
        while (location-- > 0) {
            line += "-";
        }
        return line;
    }
}
