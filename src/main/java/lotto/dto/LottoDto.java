package lotto.dto;

import java.util.List;

public class LottoDto {

    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";

    private final List<Integer> numbers;

    public LottoDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
