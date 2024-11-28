package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import lotto.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class AmountTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -4})
    void 구입_금액_범위_예외_테스트(int amount) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Amount(amount))
                .withMessageContaining(ErrorMessage.AMOUNT_NOT_POSITIVE_ERROR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 100, 5001})
    void 구입_금액_단위_예외_테스트(int amount) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Amount(amount))
                .withMessageContaining(ErrorMessage.AMOUNT_UNIT_ERROR.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"1000, 1", "5000, 5"})
    void 로또_발행_수_계산_테스트(int amount, int expected) {
        Amount purchasedAmount = new Amount(amount);
        Assertions.assertThat(purchasedAmount.getCount())
                .isEqualTo(expected);
    }
}
