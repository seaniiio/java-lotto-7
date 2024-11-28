package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLotto;
import lotto.dto.LottoDto;
import lotto.machine.LottoMachine;
import lotto.parser.Parser;

public class LottoService {

    private final Parser parser;
    private final LottoMachine lottoMachine;
    private Amount purchasedAmount;
    private PurchasedLotto purchasedLotto;

    public LottoService(final Parser parser, final LottoMachine lottoMachine) {
        this.parser = parser;
        this.lottoMachine = lottoMachine;
    }

    public void setAmount(String amountInput) {
        int amount = parser.parseAmount(amountInput);
        purchasedAmount = new Amount(amount);
    }

    public List<LottoDto> issue() {
        List<Lotto> issuedLotto = new ArrayList<>();
        for (int i = 0; i < purchasedAmount.getCount(); i++) {
            issuedLotto.add(new Lotto(lottoMachine.issueLotto()));
        }
        
        purchasedLotto = new PurchasedLotto(issuedLotto);
        return toLottoDto(purchasedLotto);
    }

    private List<LottoDto> toLottoDto(PurchasedLotto purchasedLotto) {
        List<Lotto> lottoBundle = purchasedLotto.getPurchasedLotto();

        return lottoBundle.stream()
                .map(Lotto::getNumbers)
                .map(LottoDto::new)
                .toList();
    }
}
