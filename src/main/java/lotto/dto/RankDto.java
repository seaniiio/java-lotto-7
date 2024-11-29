package lotto.dto;

import java.util.LinkedHashMap;
import lotto.constant.LottoRank;

public class RankDto {
    private LinkedHashMap<LottoRank, Integer> results;

    public RankDto() {
        results = new LinkedHashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            results.put(rank, 0);
        }
    }

    public void addResult(LottoRank lottoRank) {
        results.replace(lottoRank, results.get(lottoRank) + 1);
    }

    public LinkedHashMap<LottoRank, Integer> getResults() {
        return results;
    }
}
