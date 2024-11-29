package lotto.dto;

import java.util.LinkedHashMap;
import lotto.constant.LottoRank;

public class RankDto {
    private LinkedHashMap<LottoRank, Integer> results;

    public RankDto(LinkedHashMap<LottoRank, Integer> results) {
        this.results = results;
    }

    public LinkedHashMap<LottoRank, Integer> getResults() {
        return results;
    }
}
