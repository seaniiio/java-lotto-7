package lotto.service;

import lotto.domain.Amount;
import lotto.parser.Parser;

public class LottoService {

    private final Parser parser;
    private Amount purchasedAmount;

    public LottoService(final Parser parser) {
        this.parser = parser;
    }

    public void setAmount(String amountInput) {
        int amount = parser.parseAmount(amountInput);
        purchasedAmount = new Amount(amount);
    }
}
