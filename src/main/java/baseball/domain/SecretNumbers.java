package baseball.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecretNumbers {

  public static final int SECRET_NUMBER_MIN_VALUE = 1;
  public static final int SECRET_NUMBER_MAX_VALUE = 9;
  public static final int SECRET_NUMBERS_SIZE = 3;

  private final List<Integer> numbers;

  public SecretNumbers(List<Integer> numbers) {
    validateEmpty(numbers);
    validateSize(numbers);
    validateDuplicated(numbers);
    this.numbers = numbers;
  }

  private void validateEmpty(List<Integer> numbers) {
    if (isEmpty(numbers)) {
      throw new IllegalArgumentException("Numbers 값이 비어있습니다.");
    }
  }

  private boolean isEmpty(Collection<?> collection) {
    return (collection == null || collection.isEmpty());
  }

  private void validateSize(List<Integer> numbers) {
    if (numbers.size() != SECRET_NUMBERS_SIZE) {
      throw new IllegalArgumentException("시크릿넘버는 3개만 가능합니다.");
    }
  }

  private void validateDuplicated(List<Integer> numbers) {
    Set<Integer> numbersSet = new HashSet<>(numbers);
    if (numbersSet.size() != SECRET_NUMBERS_SIZE) {
      throw new IllegalArgumentException("중복값이 포함되어있습니다.");
    }
  }

  public Integer get(int index) {
    return numbers.get(index);
  }

  public int size() {
    return numbers.size();
  }

  public boolean contains(int number) {
    return numbers.contains(number);
  }

}
