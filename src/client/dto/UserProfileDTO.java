package client.dto;

import java.util.ArrayList;

public class UserProfileDTO {
    private String username; // 이름
    private int userLevel; // 레벨
    private long userDeposit; // 잔액
    private long userProfit; // 순이익
    private ArrayList<PositionDTO> positions; // 현재 포지션
    private ArrayList<TradingHistoryDTO> tradingHistories; // 과거 거래 기록

    // Constructor
    public UserProfileDTO() {
        username = "";
        userLevel = 1;
        userDeposit = 1_000_000_000;
        userProfit = 0;
        positions = new ArrayList<>();
        tradingHistories = new ArrayList<>();
    }

    public UserProfileDTO(String username, int userLevel, long userDeposit, long userProfit, ArrayList<PositionDTO> positions, ArrayList<TradingHistoryDTO> tradingHistories) {
        this.username = username;
        this.userLevel = userLevel;
        this.userDeposit = userDeposit;
        this.userProfit = userProfit;
        this.positions = positions;
        this.tradingHistories = tradingHistories;
    }

    // Getter
    public String getUsername() {
        return username;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public long getUserDeposit() {
        return userDeposit;
    }

    public long getUserProfit() {
        return userProfit;
    }

    public ArrayList<PositionDTO> getPositions() {
        return positions;
    }

    public ArrayList<TradingHistoryDTO> getTradingHistories() {
        return tradingHistories;
    }

    // Setter
    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public void setUserDeposit(long userDeposit) {
        this.userDeposit = userDeposit;
    }

    public void setUserProfit(long userProfit) {
        this.userProfit = userProfit;
    }

    public void setPositions(ArrayList<PositionDTO> positions) {
        this.positions = positions;
    }

    public void setTradingHistories(ArrayList<TradingHistoryDTO> tradingHistories) {
        this.tradingHistories = tradingHistories;
    }
}
