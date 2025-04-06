package client.dto;

import display.dto.Coin;
import display.type.CoinType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;

public class PositionDTO implements Serializable {
    private String coinName; // 코인명
    private long quantity; // 매수량
    private long entryPrice; // 진입가
    private String entryTime; // 진입날짜
    private long currentPrice; // 현재가
    private String orderType; // 숏, 롱 포지션 타입
    private long profit; // 현재 이익

    // Constructor
    public PositionDTO() {
        coinName = "";
        quantity = 0;
        entryPrice = 0;
        entryTime = LocalDateTime.now().toString();
        currentPrice = 0;
        orderType = "Long";
        profit = 0;
    }

    public PositionDTO(String coinName, long quantity, long entryPrice, String entryTime, long currentPrice, String orderType, long profit) {
        this.coinName = coinName;
        this.quantity = quantity;
        this.entryPrice = entryPrice;
        this.entryTime = entryTime;
        this.currentPrice = currentPrice;
        this.orderType = orderType;
        this.profit = profit;
    }

    // Getter
    public String getCoinName() {
        return coinName;
    }

    public long getQuantity() {
        return quantity;
    }

    public long getEntryPrice() {
        return entryPrice;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public long getCurrentPrice(HashMap<CoinType, Coin> coinMap) {
        return coinMap.get(CoinType.valueOf(this.coinName)).getCurrentPrice();
    }

    public String getOrderType() {
        return orderType;
    }

    public long getProfit(HashMap<CoinType, Coin> coinMap){
        return this.orderType.equals("Short") ? this.entryPrice - coinMap.get(CoinType.valueOf(this.coinName)).getCurrentPrice()
                : coinMap.get(CoinType.valueOf(this.coinName)).getCurrentPrice() - this.entryPrice;
    }

    // Setter
    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void setEntryPrice(long entryPrice) {
        this.entryPrice = entryPrice;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public void setCurrentPrice(long currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public void setProfit(long profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "PositionDTO{" +
                "coinName='" + coinName + '\'' +
                ", quantity=" + quantity +
                ", entryPrice=" + entryPrice +
                ", entryTime='" + entryTime + '\'' +
                ", currentPrice=" + currentPrice +
                ", orderType='" + orderType + '\'' +
                ", profit=" + profit +
                '}';
    }
}
