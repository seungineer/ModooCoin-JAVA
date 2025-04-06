package client.service;

import client.dto.PositionDTO;
import client.dto.TradingHistoryDTO;
import client.dto.UserProfileDTO;

public class HistoryService {
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
