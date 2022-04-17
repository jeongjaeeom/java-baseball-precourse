package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SecretNumbersGenerator {

  protected static final int MIN_VALUE = 1;
  protected static final int MAX_VALUE = 9;
  protected static final int SIZE = 3;

  public static List<Integer> generate() {
    final Set<Integer> numbers = new LinkedHashSet<>(SIZE);
    while (numbers.size() < SIZE) {
      numbers.add(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE));
    }
    return new ArrayList<>(numbers);
  }

}
