package lotto.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    private Parser parser = new Parser();

    @ParameterizedTest
    @ValueSource(strings = {"1000원", "", " ", "\n"})
    void 구입_금액_형식_예외_테스트(String inputAmount) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> parser.parseAmount(inputAmount))
                .withMessageContaining(ErrorMessage.AMOUNT_FORMAT_ERROR.getMessage());
    }

    @Test
    void 당첨_번호_파싱_테스트() {
        String winningNumbersInput = "1,2,3,4,5,6";
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        Assertions.assertThat(parser.parseLottoNumber(winningNumbersInput))
                .containsAll(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1번,2번,3번,4번,5번,6번", "", " ", "\n"})
    void 당첨_번호_형식_예외_테스트(String winningNumbersInput) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> parser.parseLottoNumber(winningNumbersInput))
                .withMessageContaining(ErrorMessage.LOTTO_FORMAT_ERROR.getMessage());
    }
}
