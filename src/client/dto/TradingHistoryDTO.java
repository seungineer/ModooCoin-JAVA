package client.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TradingHistoryDTO implements Serializable {
    private String coinName; // 코인명
    private String entryTime; // 진입날짜
    private long entryPrice; // 진입가
    private String closeTime; // 청산날짜
    private long closePrice; // 청산가
    private String orderType; // 포지션 타입
    private long benefit; // 이익

    // Constructor
    public TradingHistoryDTO() {
        coinName = "";
        entryTime = LocalDateTime.now().toString();
        entryPrice = 0;
        closeTime = LocalDateTime.now().toString();
        closePrice = 0;
        orderType = "Long";
        benefit = 0;
    }

    public TradingHistoryDTO(String coinName, String entryTime, long entryPrice, String closeTime, long closePrice, String orderType, long benefit) {
        this.coinName = coinName;
        this.entryTime = entryTime;
        this.entryPrice = entryPrice;
        this.closeTime = closeTime;
        this.closePrice = closePrice;
        this.orderType = orderType;
        this.benefit = benefit;
    }

    // Getter
    public String getCoinName() {
        return coinName;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public long getEntryPrice() {
        return entryPrice;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public long getClosePrice() {
        return closePrice;
    }

    public String getOrderType() {
        return orderType;
    }

    public long getBenefit() {
        return benefit;
    }

    // Setter
    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public void setEntryPrice(long entryPrice) {
        this.entryPrice = entryPrice;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public void setClosePrice(long closePrice) {
        this.closePrice = closePrice;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public void setBenefit(long benefit) {
        this.benefit = benefit;
    }
}
