package lotto.view;

import java.util.LinkedHashMap;
import java.util.List;
import lotto.constant.LottoRank;
import lotto.dto.LottoDto;
import lotto.dto.RankDto;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printPurchasedLotto(List<LottoDto> purchasedLotto) {
        System.out.println(System.lineSeparator() + purchasedLotto.size() + "개를 구매했습니다.");

        purchasedLotto.stream()
                .forEach(System.out::println);
    }

    public void printLottoRanks(RankDto results) {
        System.out.println(System.lineSeparator() + "당첨 통계" + System.lineSeparator() + "---");
        LinkedHashMap<LottoRank, Integer> ranks = results.getResults();
        for (LottoRank lottoRank : ranks.keySet()) {
            if (!lottoRank.equals(LottoRank.NONE)) {
                System.out.println(lottoRank.getMessage() + " - " + ranks.get(lottoRank) + "개");
            }
        }
    }
}
