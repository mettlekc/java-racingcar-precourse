package woocamp.racingcar;

import woocamp.racingcar.constant.Print;
import woocamp.racingcar.view.View;

import java.util.Map;
import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RacingCar racingCar = new RacingCar(registCar(scanner), registRound(scanner));

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

    private static int registRound(Scanner scanner) {
        View.print(Print.REGIST_ROUND);
        return scanner.nextInt();
    }

    private static String registCar(Scanner scanner) {
        View.print(Print.REGIST_CAR);
        return scanner.nextLine();
    }

}
