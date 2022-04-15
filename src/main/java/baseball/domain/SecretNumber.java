package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SecretNumber {

  public static final int MIN_VALUE = 1;
  public static final int MAX_VALUE = 9;
  public static final int SIZE = 3;

  private final List<Integer> numbers;

  public SecretNumber() {
    this.numbers = generateNumbers();
  }

  private List<Integer> generateNumbers() {
    final Set<Integer> numbers = new LinkedHashSet<>(SIZE);
    while (numbers.size() < SIZE) {
      numbers.add(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE));
    }
    return new ArrayList<>(numbers);
  }

  public int get(int index) {
    return numbers.get(index);
  }

}
