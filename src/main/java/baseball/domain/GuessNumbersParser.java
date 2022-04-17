package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class GuessNumbersParser {

  public static List<Integer> parse(final String value) {
    if (value == null || value.isEmpty()) {
      throw new IllegalArgumentException("입력값이 잘못되었습니다.");
    }

    final List<Integer> numbers = new ArrayList<>(value.length());
    for (Character character : value.toCharArray()) {
      numbers.add(parseInt(character));
    }
    return numbers;
  }

  private static int parseInt(Character number) {
    if (!Character.isDigit(number)) {
      throw new IllegalArgumentException("숫자가 아닙니다.");
    }
    return Character.getNumericValue(number);
  }

}
