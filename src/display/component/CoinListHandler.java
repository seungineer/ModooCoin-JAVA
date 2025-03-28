package display.component;

import display.dto.CoinData;
import display.type.Coin;
import display.utils.JsonParser;

import java.util.HashMap;

public class CoinListHandler {
    public HashMap<Coin, CoinData> coinList = new HashMap<>();
    public JsonParser jsonParser = new JsonParser();

    // ANSI escape code 상수 정의
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public void drawCoinList(String data){
        System.out.println(defineStringToCoin(data));
    }

    public String defineStringToCoin(String data){
        String coinName = jsonParser.extractJsonValue(data,"code");
        String curPrice = jsonParser.extractJsonValue(data,"trade_price");
        String changePrice = jsonParser.extractJsonValue(data,"change_price");
        String change = jsonParser.extractJsonValue(data,"change");
        String color;
        if(change.equals("RISE")){
            color = GREEN;
        }else if(change.equals("FALL")){
            color = RED;
        }else{
            color = RESET;
        }

        String result = "COINNAME : " + coinName + ", CURPRICE : " + curPrice + ", CHANGEPRICE : " + color + changePrice + RESET;
        return result;
    }
}
