package utils;

import display.dto.Coin;
import display.type.CoinType;

import java.util.HashMap;

public class CoinUpdater {
    public JsonParser jsonParser = new JsonParser();

    public void setCoinMap(HashMap<CoinType, Coin> coinMap){
        for (CoinType coinType : CoinType.values()) {
            // 초기값은 "0" 또는 "N/A" 같은 기본값
            Coin coin = new Coin(coinType, 0L, 0L, "EVEN");
            coinMap.put(coinType, coin);
        }
    }

    public boolean updateCoinMap(String data,HashMap<CoinType, Coin> coinMap){
        String codeValue = jsonParser.extractJsonValue(data, "code");
        if (codeValue == null) {
            return false;
        }

        CoinType coinType = CoinType.valueOf(jsonParser.extractJsonValue(data,"code").replace("-","_"));
        String curPriceStr = jsonParser.extractJsonValue(data,"trade_price");
        String changePriceStr = jsonParser.extractJsonValue(data,"change_price");
        String change = jsonParser.extractJsonValue(data,"change");

        // 👉 소수점 이하 제거하고 Long으로 변환
        long curPrice = parseToLong(curPriceStr);
        long changePrice = parseToLong(changePriceStr);

        Coin existCoin = coinMap.get(coinType);


        if(!existCoin.getCurrentPrice().equals(curPrice) ||
                !existCoin.getChangePrice().equals(changePrice) ||
                !existCoin.getChange().equals(change))
        {

            Coin updatedCoin = new Coin(coinType,curPrice,changePrice,change);
            coinMap.put(coinType,updatedCoin);

            return true;
        }

        return false;
    }

    private long parseToLong(String value) {
        if (value == null || value.trim().isEmpty()) {
            return 0;
        }

        try {
            double doubleValue = Double.parseDouble(value);
            return (long) doubleValue;
        } catch (NumberFormatException e) {
            System.err.println("숫자 파싱 실패: " + value);
            return 0;
        }
    }
}
