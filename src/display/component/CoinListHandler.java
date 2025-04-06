package display.component;

import display.dto.Coin;
import display.type.CoinType;
import utils.CoinUpdater;
import utils.JsonParser;

import java.util.HashMap;

import static java.lang.Thread.sleep;

public class CoinListHandler {
    public static HashMap<CoinType, Coin> coinMap = new HashMap<>();
    public JsonParser jsonParser = new JsonParser();
    public CoinUpdater coinUpdater = new CoinUpdater();

    // ANSI 컬러 상수 정의
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public void drawCoinList(String data){
        // 코인에 업데이트 반영 시
        if(coinUpdater.updateCoinMap(data,coinMap)){
            showCoinMap();
        }
        //clearConsole();
    }


    public void showCoinMap(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-10s | %-23s | %-20s\n", "COINNAME", "CURPRICE", "CHANGEPRICE"));
        sb.append("--------------------------------------------------------------------\n");

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


    public void startDrawing() {
        coinUpdater.setCoinMap(coinMap);
    }
}
