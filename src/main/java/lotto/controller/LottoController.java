package lotto.controller;

import java.util.List;
import lotto.dto.LottoDto;
import lotto.repeater.InputRepeater;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputRepeater inputRepeater;
    private final LottoService lottoService;

    public LottoController(final InputView inputView, final OutputView outputView, final InputRepeater inputRepeater, final LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputRepeater = inputRepeater;
        this.lottoService = lottoService;
    }

    public void run() {
        inputRepeater.continueUntilNormalInput(this::processAmountInput, outputView::printMessage);
        List<LottoDto> purchasedLotto = lottoService.issue();
//        outputView.printPurchasedLotto();

    }

    private void processAmountInput() {
        String amountInput = inputView.inputAmount();
        lottoService.setAmount(amountInput);
    }
}
