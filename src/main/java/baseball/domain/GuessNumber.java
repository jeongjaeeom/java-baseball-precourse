package baseball.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GuessNumber {

  public static final int SIZE = 3;

  private final List<Integer> numbers;

  public GuessNumber(String guess) {
    validateInput(guess);
    this.numbers = parseNumbers(guess.toCharArray());
    validate();
  }

  private void validateInput(String guess) {
    if (guess == null || guess.length() != 3) {
      throw new IllegalArgumentException("입력값이 잘못되었습니다.");
    }
  }

  private List<Integer> parseNumbers(char[] chars) {
    final Set<Integer> numbers = new LinkedHashSet<>(SIZE);
    for (Character character : chars) {
      numbers.add(parseInt(character));
    }
    return new ArrayList<>(numbers);
  }

  private int parseInt(Character number) {
    if (!Character.isDigit(number)) {
      throw new IllegalArgumentException("숫자가 아닙니다.");
    }
    return Character.getNumericValue(number);
  }

  private void validate() {
    if (this.numbers.size() != SIZE) {
      throw new IllegalArgumentException("중복값이 포함되어있습니다.");
    }
  }

}
