package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 보너스_번호_범위_예외_테스트(int bonusNumber) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), bonusNumber))
                .withMessageContaining(ErrorMessage.BONUS_NUMBER_BOUND_ERROR.getMessage());
    }

    @Test
    void 보너스_번호_중복_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 1))
                .withMessageContaining(ErrorMessage.BONUS_NUMBER_DUPLICATED_ERROR.getMessage());
    }
}
