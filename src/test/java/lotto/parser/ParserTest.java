package lotto.parser;

import static org.junit.jupiter.api.Assertions.*;

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
}
