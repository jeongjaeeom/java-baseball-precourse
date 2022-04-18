package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GuessNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abcd", "abcde", "1ab", "a2c", "ab3", "-12", "1-2", "113", "111"})
    public void 사용자_추측값_입력_예외테스트(String input) {
        assertThatThrownBy(() -> new GuessNumbers(GuessNumbersParser.parse(input)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
