package woocamp.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
                .hasMessage("자동차 이름은 최대 %d자리를 넘을 수 없습니다", Car.CAR_NAME_MAX);
    }

    @Test
    void get_position() {
        assertThat(car.getPos(Move.Status.PAUSE)).isZero();
        assertThat(car.getPos(Move.Status.FORWARD)).isEqualTo(1);
        assertThat(car.getPos(Move.Status.FORWARD)).isEqualTo(2);
        assertThat(car.getPos(Move.Status.PAUSE)).isEqualTo(2);
    }

}
