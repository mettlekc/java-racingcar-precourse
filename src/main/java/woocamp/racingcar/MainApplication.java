package woocamp.racingcar;

import woocamp.racingcar.constant.Print;
import woocamp.racingcar.view.View;

import java.util.Map;
import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RacingCar racingCar = new RacingCar();

        registCar(scanner, racingCar);
        registRound(scanner, racingCar);

        System.out.println();
        play(racingCar);

        View.printWinners(racingCar.rank());

        scanner.close();
    }

    private static void play(RacingCar racingCar) {
        View.print(Print.RESULT_TITLE);
        while (racingCar.isNotFinish()) {
            racingCar.play();
            Map<String, Integer> locations = racingCar.locations();
            View.printResult(locations);
            System.out.println();
        }
    }

    private static void registRound(Scanner scanner, RacingCar racingCar) {
        while (true) {
            try {
                View.print(Print.REGIST_ROUND);
                racingCar.registRound(scanner.nextInt());
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void registCar(Scanner scanner, RacingCar racingCar) {
        while (true) {
            try {
                View.print(Print.REGIST_CAR);
                racingCar.registCars(scanner.nextLine());
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
