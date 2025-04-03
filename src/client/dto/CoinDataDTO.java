package client.dto;

public class CoinDataDTO {
    private String coinName; // 코인명
    private long currentPrice; // 현재가
    private long changePrice; // 변동가
    private String change; // 상승, 하락 여부, 상승시 RISE
    private double changeRate; // 변동율

    // Constructor
    public CoinDataDTO() {
        coinName = "";
        currentPrice = 0;
        changePrice = 0;
        change = "RISE";
        changeRate = 0.0;
    }

    public CoinDataDTO(String coinName, long currentPrice, long changePrice, String change, double changeRate) {
        this.coinName = coinName;
        this.currentPrice = currentPrice;
        this.changePrice = changePrice;
        this.change = change;
        this.changeRate = changeRate;
    }

    // Getter
    public String getCoinName() {
        return coinName;
    }

    public long getCurrentPrice() {
        return currentPrice;
    }

    public long getChangePrice() {
        return changePrice;
    }

    public String getChange() {
        return change;
    }

    public double getChangeRate() {
        return changeRate;
    }

    // Setter
    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public void setCurrentPrice(long currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setChangePrice(long changePrice) {
        this.changePrice = changePrice;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public void setChangeRate(double changeRate) {
        this.changeRate = changeRate;
    }
}
