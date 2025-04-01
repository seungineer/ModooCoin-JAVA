package display.component;

import display.dto.Coin;
import display.type.CoinType;
import display.utils.JsonParser;

import java.util.HashMap;

import static java.lang.Thread.sleep;

public class CoinListHandler {
    public HashMap<CoinType, Coin> coinMap = new HashMap<>();
    public JsonParser jsonParser = new JsonParser();

    // ANSI escape code 상수 정의
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public void setCoinMap(){
        for (CoinType coinType : CoinType.values()) {
            // 초기값은 "0" 또는 "N/A" 같은 기본값
            Coin coin = new Coin(coinType, "0", "0", "EVEN");
            coinMap.put(coinType, coin);
        }
    }

    public void drawCoinList(String data){
        // 코인에 업데이트 반영 시
        if(updateCoinMap(data)){
            showCoinMap();
        }
        //clearConsole();
    }

    public boolean updateCoinMap(String data){
        CoinType coinType = CoinType.valueOf(jsonParser.extractJsonValue(data,"code").replace("-","_"));
        String curPrice = jsonParser.extractJsonValue(data,"trade_price");
        String changePrice = jsonParser.extractJsonValue(data,"change_price");
        String change = jsonParser.extractJsonValue(data,"change");

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

    public void showCoinMap(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-10s | %-23s | %-20s\n", "COINNAME", "CURPRICE", "CHANGEPRICE"));
        sb.append("---------------------------------------------\n");

        for(CoinType coinType : coinMap.keySet()){
            Coin coin = coinMap.get(coinType);
            sb.append(defineStringToCoin(coin));
        }

        System.out.println(sb.toString());
        try{
            sleep(500);;
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public String defineStringToCoin(Coin coin) {
        String change = coin.getChange();
        String color = RESET + " - ";

        if ("FALL".equals(change)) {
            color = RED + " ▼ ";
        } else if ("RISE".equals(change)) {
            color = GREEN + " ▲ ";
        }

        return String.format("%-10s | %-20s KRW| %s%-20s KRW%s\n",
                coin.getCoinName(),
                coin.getCurrentPrice(),
                color,
                coin.getChangePrice(),
                RESET
        );
    }

    public void clearConsole(){
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
}
