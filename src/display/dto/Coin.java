package display.dto;

import display.type.CoinType;

public class Coin {
    private CoinType coinName;
    private Long currentPrice = 0L;
    private Long changePrice = 0L;
    private String change = "EVEN";

    public Coin() {

    }

    public Coin(CoinType coinName, Long currentPrice, Long changePrice,String change) {
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

    public Long getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Long currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Long getChangePrice() {
        return changePrice;
    }

    public void setChangePrice(Long changePrice) {
        this.changePrice = changePrice;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "coinName=" + coinName +
                ", currentPrice='" + currentPrice + '\'' +
                ", changePrice='" + changePrice + '\'' +
                ", change='" + change + '\'' +
                '}';
    }
}
