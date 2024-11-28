package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import lotto.machine.LottoMachine;
import lotto.parser.Parser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @Test
    void 로또_발행_테스트() {
        LottoService lottoService = new LottoService(new Parser(), new LottoMachine());
        lottoService.setAmount("10000");

        Assertions.assertThat(lottoService.issue().size())
                .isEqualTo(10);
    }
}
