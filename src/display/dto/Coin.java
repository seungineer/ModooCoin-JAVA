package display.dto;

import display.type.CoinType;

public class Coin {
    private CoinType coinName;
    private String currentPrice = "0";
    private String changePrice = "0";
    private String change = "EVEN";

    public Coin() {

    }

    public Coin(CoinType coinName, String currentPrice, String changePrice,String change) {
        this.coinName = coinName;
        this.currentPrice = currentPrice;
        this.changePrice = changePrice;
        this.change = change;
    }

    public CoinType getCoinName() {
        return coinName;
    }

    public void setCoinName(CoinType coinName) {
        this.coinName = coinName;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getChangePrice() {
        return changePrice;
    }

    public void setChangePrice(String changePrice) {
        this.changePrice = changePrice;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }


}
