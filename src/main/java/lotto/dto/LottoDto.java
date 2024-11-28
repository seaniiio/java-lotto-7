package lotto.dto;

import java.util.Collections;
import java.util.List;

public class LottoDto {

    private final List<Integer> numbers;

    public LottoDto(List<Integer> numbers) {
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
