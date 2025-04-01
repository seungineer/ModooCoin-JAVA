package client.test;

import java.util.Scanner;
import static client.service.UserService.*;
import static client.service.TradingService.*;
import client.dto.*;

import javax.swing.text.Position;

public class Test {
    public static Scanner sc = new Scanner(System.in);
    public static UserProfileDTO userProfile;

    public static void main(String[] args) {
        // 사용자 이름 입력 테스트
        userProfile = initUserProfile();
        System.out.println(userProfile.getUsername());

        // 롱, 숏 테스트
        System.out.println(userProfile.getUserDeposit());
        enterPosition("KRW-BTC", 1, 1_000_000, "Short");
        enterPosition("KRW-XRP", 3, 40_000, "LONG");
        System.out.println(userProfile.getUserDeposit());
        getCurrentPositions();

        // 청산 테스트
        System.out.println(userProfile.getUserDeposit());
        closePosition(0);
        getCurrentPositions();
        System.out.println(userProfile.getUserDeposit());

        // 거래 기록 테스트
        getTradingHistories();
    }

    // 현재 포지션 테스트용 메서드
    private static void getCurrentPositions() {
        for (int i = 0; i < userProfile.getPositions().size(); i++) {
            PositionDTO position = userProfile.getPositions().get(i);
            System.out.print(i + " 번째 포지션 | ");
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
    private static void getTradingHistories() {
        for (int i = 0; i < userProfile.getTradingHistories().size(); i++) {
            TradingHistoryDTO tradingHistory = userProfile.getTradingHistories().get(i);
            System.out.print(i + " 번째 거래 기록 | ");
            System.out.print(tradingHistory.getCoinName() + " | ");
            System.out.print(tradingHistory.getEntryTime() + " | ");
            System.out.print(tradingHistory.getEntryPrice() + " | ");
            System.out.print(tradingHistory.getCloseTime() + " | ");
            System.out.print(tradingHistory.getClosePrice() + " | ");
            System.out.print(tradingHistory.getOrderType() + " | ");
            System.out.println(tradingHistory.getBenefit());
        }
    }
}
