package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SecretNumbersTest {

    @RepeatedTest(10)
    public void 시크릿넘버_생성() {
        SecretNumbers secretNumbers = new SecretNumbers(SecretNumbersGenerator.generate());
        assertThat(secretNumbers.size()).isEqualTo(3);
    }

    @Test
    public void 시크릿넘버_EmptyList_예외() {
        assertThatThrownBy(() -> new SecretNumbers(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Numbers 값이 비어있습니다.");
    }

    @Test
    public void 시크릿넘버_사이즈_예외() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        assertThatThrownBy(() -> new SecretNumbers(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시크릿넘버는 3개만 가능합니다.");
    }

    @Test
    public void 시크릿넘버_중복값_예외() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        assertThatThrownBy(() -> new SecretNumbers(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복값");
    }

}