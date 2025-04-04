package client.service;

import client.dto.PositionDTO;
import client.dto.TradingHistoryDTO;
import client.dto.UserProfileDTO;

public class HistoryService {
    // 현재 포지션 테스트용 메서드
    public void getCurrentPositions(UserProfileDTO userProfile) {
        
        for (int i = 0; i < userProfile.getPositions().size(); i++) {
            PositionDTO position = userProfile.getPositions().get(i);
            System.out.print((i+1) + " 번째 포지션 | ");
            System.out.print(position.getCoinName() + " | ");
            System.out.print(position.getQuantity() + " | ");
            System.out.print(position.getEntryPrice() + " | ");
            System.out.print(position.getEntryTime() + " | ");
            System.out.print(position.getCurrentPrice() + " | ");
            System.out.print(position.getOrderType() + " | ");
            System.out.println(position.getProfit());
        }
    }

    // 거래 기록 테스트용 메서드
    public void getTradingHistories(UserProfileDTO userProfile) {
        if(userProfile.getTradingHistories().isEmpty()){
            System.out.println("거래 내역이 없습니다!");
            return;
        }
        for (int i = 0; i < userProfile.getTradingHistories().size(); i++) {
            TradingHistoryDTO tradingHistory = userProfile.getTradingHistories().get(i);
            System.out.print((i+1) + " 번째 거래 기록 | ");
            System.out.print(tradingHistory.getCoinName() + " | ");
            System.out.print(tradingHistory.getEntryTime() + " | ");
            System.out.print(tradingHistory.getEntryPrice() + " | ");
            System.out.print(tradingHistory.getCloseTime() + " | ");
            System.out.print(tradingHistory.getClosePrice() + " | ");
            System.out.print(tradingHistory.getOrderType() + " | ");
            System.out.println(tradingHistory.getBenefit());
        }
    }

    // 거래 기록 테스트용 메서드
    public void deleteHistory(UserProfileDTO userProfile) {
        if(userProfile.getTradingHistories().isEmpty()){
            System.out.println("삭제할 거래 내역이 없습니다!");
            return;
        }
        userProfile.getTradingHistories().clear();
        System.out.println("거래 내역 삭제 완료.");
    }
}
