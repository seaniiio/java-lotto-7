package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoRank;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchasedLotto;
import lotto.domain.WinningLotto;
import lotto.dto.LottoDto;
import lotto.dto.RankDto;
import lotto.machine.LottoMachine;
import lotto.parser.Parser;

public class LottoService {

    private final Parser parser;
    private final LottoMachine lottoMachine;
    private Amount purchasedAmount;
    private PurchasedLotto purchasedLotto;
    private Lotto winningLottoNumbers;
    private WinningLotto winningLotto;
    private LottoResult lottoResult;

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

    public void setWinningNumbers(String winningNumbersInput) {
        List<Integer> winningNumbers = parser.parseLottoNumber(winningNumbersInput);
        this.winningLottoNumbers = new Lotto(winningNumbers);
    }

    public void setBonusNumber(String bonusNumberInput) {
        int bonusNumber = parser.parseBonusNumber(bonusNumberInput);
        this.winningLotto = new WinningLotto(this.winningLottoNumbers, bonusNumber);
    }

    public RankDto checkLotto() {
        List<Lotto> lottoBundle = this.purchasedLotto.getPurchasedLotto();
        lottoResult = new LottoResult();

        for (Lotto lotto : lottoBundle) {
            int matchCount = winningLotto.checkLottoMatchCount(lotto);
            boolean matchBonusNumber = winningLotto.checkBonusNumberMatch(lotto);
            lottoResult.addResult(LottoRank.checkLottoRank(matchCount, matchBonusNumber));
        }

        return new RankDto(lottoResult.getResults());
    }

    public double calculateProfit() {
        return lottoResult.getTotalPrize() / purchasedAmount.getAmount();
    }

    private List<LottoDto> toLottoDto(PurchasedLotto purchasedLotto) {
        List<Lotto> lottoBundle = purchasedLotto.getPurchasedLotto();

        return lottoBundle.stream()
                .map(Lotto::getNumbers)
                .map(LottoDto::new)
                .toList();
    }
}
