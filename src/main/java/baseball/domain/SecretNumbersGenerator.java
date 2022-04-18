package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SecretNumbersGenerator {

    public static final int SECRET_NUMBER_MIN_VALUE = 1;
    public static final int SECRET_NUMBER_MAX_VALUE = 9;
    public static final int SECRET_NUMBERS_SIZE = 3;

    private SecretNumbersGenerator() {
        throw new IllegalStateException("Not supported");
    }

    public static List<Integer> generate() {
        final Set<Integer> numbers = new LinkedHashSet<>(SECRET_NUMBERS_SIZE);
        while (numbers.size() < SECRET_NUMBERS_SIZE) {
            numbers.add(Randoms.pickNumberInRange(SECRET_NUMBER_MIN_VALUE, SECRET_NUMBER_MAX_VALUE));
        }
        return new ArrayList<>(numbers);
    }

}
