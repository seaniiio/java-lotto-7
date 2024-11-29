package lotto.view;

import java.util.List;
import lotto.dto.LottoDto;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printPurchasedLotto(List<LottoDto> purchasedLotto) {
        System.out.println(System.lineSeparator() + purchasedLotto.size() + "개를 구매했습니다.");

        purchasedLotto.stream()
                .forEach(System.out::println);

        System.out.println();
    }
}
