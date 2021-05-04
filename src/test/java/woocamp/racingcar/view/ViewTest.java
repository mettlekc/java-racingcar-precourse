package woocamp.racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import woocamp.racingcar.constant.Print;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ViewTest {

    ByteArrayOutputStream outSpy;

    @BeforeEach
    private void setUp() {
        outSpy = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outSpy));
    }

    @Test
    @DisplayName("자동차 등록 출력 테스트")
    void regist_car() {
         setUp();
        View.print(Print.REGIST_CAR);
        assertThat(outSpy.toString()).isEqualTo(Print.REGIST_CAR.getMessage()+ "\r\n");
    }

    @Test
    @DisplayName("자동차 회수 등록 출력 테스트")
    void regist_round() {
        View.print(Print.REGIST_ROUND);
        assertThat(outSpy.toString()).isEqualTo(Print.REGIST_ROUND.getMessage() + "\r\n");
    }

    @Test
    @DisplayName("결과 타이틀 출력 테스트")
    void print_result_title() {
        View.print(Print.RESULT_TITLE);
        assertThat(outSpy.toString()).isEqualTo(Print.RESULT_TITLE.getMessage() + "\r\n");
    }

    @Test
    @DisplayName("단일 자동차 위치 출력 테스트")
    void print_location() {
        View.printLocation("phobi", 1);
        assertThat(outSpy.toString()).isEqualTo("phobi:-" + "\r\n");
        outSpy.reset();
        View.printLocation("phobi", 3);
        assertThat(outSpy.toString()).isEqualTo("phobi:---" + "\r\n");
        outSpy.reset();
    }

    @Test
    @DisplayName("전체 자동차 위치 출력 테스트")
    void print_result() {
        Map<String, Integer> locations = new HashMap<>();
        locations.put("phobi", 1);
        locations.put("crong", 2);
        locations.put("honux", 1);

        View.printResult(locations);
        assertThat(outSpy.toString())
                .contains("crong:--","phobi:-","honux:-");
    }

    @Test
    @DisplayName("우승자 출력 테스트")
    void print_rank() {
        Set<String> winners = new HashSet<>();
        winners.add("phobi");
        winners.add("honux");

        View.printWinners(winners);
        assertThat(outSpy.toString()).contains("phobi","honux","가 최종 우승했습니다.\r\n");
    }

}
