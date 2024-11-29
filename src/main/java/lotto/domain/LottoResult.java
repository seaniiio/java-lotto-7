package lotto.domain;

import java.util.LinkedHashMap;
import lotto.constant.LottoRank;

public class LottoResult {
    private LinkedHashMap<LottoRank, Integer> results;

    public LottoResult() {
        results = new LinkedHashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            results.put(rank, 0);
        }
    }

    public void addResult(LottoRank lottoRank) {
        results.replace(lottoRank, results.get(lottoRank) + 1);
    }

    public LinkedHashMap<LottoRank, Integer> getResults() {
        return new LinkedHashMap<>(results);
    }

    public double getTotalPrize() {
        double totalPrize = 0;

        for (LottoRank lottoRank : results.keySet()) {
            totalPrize += lottoRank.getPrize(results.get(lottoRank));
        }

        return totalPrize;
    }

}
