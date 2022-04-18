package baseball.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GuessNumbers {

    public static final int GUESS_NUMBERS_SIZE = 3;

    private final List<Integer> numbers;

    public GuessNumbers(List<Integer> numbers) {
        validateEmpty(numbers);
        validateSize(numbers);
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    public Integer get(int index) {
        return numbers.get(index);
    }

    public int size() {
        return numbers.size();
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
        if (numbers.size() != GUESS_NUMBERS_SIZE) {
            throw new IllegalArgumentException("추측넘버는 3개의 숫자를 입력해야합니다.");
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != GUESS_NUMBERS_SIZE) {
            throw new IllegalArgumentException("중복값이 포함되어있습니다.");
        }
    }

}
