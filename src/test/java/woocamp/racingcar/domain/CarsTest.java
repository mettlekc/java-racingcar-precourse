package woocamp.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import woocamp.racingcar.constant.ErrorStatus;
import woocamp.racingcar.exception.CarNameEmptyStringException;
import woocamp.racingcar.exception.CarNameOutOfLengthException;
import woocamp.racingcar.exception.EmptyCarException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    @DisplayName("자동차 리스트 생성 테스트")
    void create_cars() {
        assertThat(new Cars("pobi,crong,honux").getCars()).hasSize(3);
        assertThat(new Cars("pobi,crong,honux").getCars()).extracting(Car::getName).containsExactlyInAnyOrder("pobi", "crong", "honux");
        assertThat(new Cars("pobi ,crong, honux ").getCars()).extracting(Car::getName).containsExactlyInAnyOrder("pobi", "crong", "honux");
        assertThatThrownBy(() -> new Cars("pobicrong, honux ")).isInstanceOf(CarNameOutOfLengthException.class).hasMessage(ErrorStatus.CAR_NAME_LENGTH_EXCEEDED.getCause(), Car.CAR_NAME_MAX);
    }

    @Test
    @DisplayName("자동차 리스트가 비어 있는 경우 테스트")
    void create_empty_car() {
        assertThatThrownBy(() -> new Cars("")).isInstanceOf(EmptyCarException.class).hasMessage(ErrorStatus.EMPTY_CAR.getCause());
    }

    @Test
    @DisplayName("자동차 이름이 중간에 비어 있는 경우 테스트")
    void create_cars_by_empty_string_name() {
        assertThatThrownBy(() -> new Cars("pobi,,honux")).isInstanceOf(CarNameEmptyStringException.class).hasMessage(ErrorStatus.CAR_NAME_EMPTY.getCause());
        assertThatThrownBy(() -> new Cars("pobi, ,honux")).isInstanceOf(CarNameEmptyStringException.class).hasMessage(ErrorStatus.CAR_NAME_EMPTY.getCause());
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    void move_cars() {
        Cars cars = new Cars("pobi,crong,honux");
        cars.move();
        assertThat(cars.getCars()).extracting(Car::getLocation).allMatch(c -> c >= 0);
    }
}
