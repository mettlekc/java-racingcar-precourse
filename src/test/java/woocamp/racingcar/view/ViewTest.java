package woocamp.racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import woocamp.racingcar.constant.Print;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ViewTest {

    ByteArrayOutputStream outSpy;

    @BeforeEach
    private void setUp() {
        outSpy = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outSpy));
    }

    @Test
    void regist_car() {
         setUp();
        View.print(Print.REGIST_CAR);
        assertThat(outSpy.toString()).isEqualTo(Print.REGIST_CAR.getMessage()+ "\r\n");
    }

    @Test
    void regist_round() {
        View.print(Print.REGIST_ROUND);
        assertThat(outSpy.toString()).isEqualTo(Print.REGIST_ROUND.getMessage() + "\r\n");
    }

    @Test
    void print_result_title() {
        View.print(Print.RESULT_TITLE);
        assertThat(outSpy.toString()).isEqualTo(Print.RESULT_TITLE.getMessage() + "\r\n");
    }

    @Test
    void print_location() {
        View.printLocation("phobi", 1);
        assertThat(outSpy.toString()).isEqualTo("phobi:-" + "\r\n");
        outSpy.reset();
        View.printLocation("phobi", 3);
        assertThat(outSpy.toString()).isEqualTo("phobi:---" + "\r\n");
        outSpy.reset();
    }

    @Test
    void print_result() {
        Map<String, Integer> locations = new HashMap<>();
        locations.put("phobi", 1);
        locations.put("crong", 2);
        locations.put("honux", 1);

        View.printResult(locations);
        assertThat(outSpy.toString())
                .contains("crong:--","phobi:-","honux:-");
    }

}
