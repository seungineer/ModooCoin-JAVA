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
        //userProfile = initUserProfile();
        System.out.println(userProfile.getUsername());

        // 롱, 숏 테스트
        System.out.println(userProfile.getUserDeposit());
        //enterPosition("KRW-BTC", 1, 1_000_000, "Short");
        //enterPosition("KRW-XRP", 3, 40_000, "LONG");
        System.out.println(userProfile.getUserDeposit());
        //getCurrentPositions();

        // 청산 테스트
        System.out.println(userProfile.getUserDeposit());
        //closePosition(0);
        //getCurrentPositions();
        System.out.println(userProfile.getUserDeposit());

        // 거래 기록 테스트
        //getTradingHistories();
    }


}
