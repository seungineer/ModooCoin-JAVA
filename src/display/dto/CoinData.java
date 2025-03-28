package display.dto;

public class CoinData {
    private String coinName;
    private Long currentPrice;
    private Long changePrice;

    public CoinData() {

    }

    public CoinData(String coinName, Long currentPrice, Long changePrice) {
        this.coinName = coinName;
        this.currentPrice = currentPrice;
        this.changePrice = changePrice;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
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
}
