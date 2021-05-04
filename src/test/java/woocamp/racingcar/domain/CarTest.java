package woocamp.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import woocamp.racingcar.constant.ErrorStatus;
import woocamp.racingcar.exception.CarNameOutOfLengthException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("12345");
    }

    @Test
    void create_car_test() {
        assertThat(new Car("123").getName()).hasSizeLessThanOrEqualTo(5);
        assertThat(new Car("12345").getName()).hasSizeLessThanOrEqualTo(5);
    }

    @Test
    void over_length_nammed_car() {
        assertThatThrownBy(() -> new Car("123456")).isInstanceOf(CarNameOutOfLengthException.class)
                .hasMessage(ErrorStatus.CAR_NAME_LENGTH_EXCEEDED.getCause(), Car.CAR_NAME_MAX);
    }

    @Test
    void move_position() {
        assertThat(car.move(Move.Status.PAUSE)).isZero();
        assertThat(car.move(Move.Status.FORWARD)).isEqualTo(1);
        assertThat(car.getLocation()).isEqualTo(1);
        assertThat(car.move(Move.Status.FORWARD)).isEqualTo(2);
        assertThat(car.getLocation()).isEqualTo(2);
        assertThat(car.move(Move.Status.PAUSE)).isEqualTo(2);
        assertThat(car.getLocation()).isEqualTo(2);
    }

    @RepeatedTest(100)
    void move_random() {
        assertThat(car.move() >= 0).isTrue();
    }

}
