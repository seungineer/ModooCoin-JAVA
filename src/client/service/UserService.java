package client.service;

import java.time.LocalDateTime;
import static client.test.Test.sc;
import static client.test.Test.userProfile;

import client.dto.*;

public class UserService {
    // 사용자 프로필 초기화 메서드
    public static UserProfileDTO initUserProfile() {
        // 로컬 데이터를 읽어와서 기존의 데이터가 있는지 검증
        UserProfileDTO userProfile = new UserProfileDTO();

        if (userProfile.getUsername().equals("")) {
            while (true) {
                try {
                    System.out.print("사용자 이름을 입력하세요: ");
                    String username = sc.nextLine().trim();

                    if (username.isEmpty()) {
                        System.out.println("❌ 사용자 이름은 최소 1글자 이상이어야 합니다.");
                        continue;
                    }

                    userProfile.setUsername(username);
                    break;
                } catch (Exception e) {
                    System.out.println("⚠️ 입력 중 오류가 발생하였습니다. 다시 시도해주세요.");
                    e.printStackTrace();
                }
            }
        } else {
            // 로컬 데이터를 입력한 userProfile 객체를 반환해줌
        }

        return userProfile;
    }

    public static void addTradingHistory(PositionDTO position) {
        TradingHistoryDTO newTradingHistory = new TradingHistoryDTO(
                position.getCoinName(),
                position.getEntryTime(),
                position.getEntryPrice(),
                LocalDateTime.now().toString(),
                position.getCurrentPrice(),
                position.getOrderType(),
                (position.getOrderType() == "Long" ? 1 : -1)
                        * ((position.getCurrentPrice() - position.getEntryPrice())
                        * position.getQuantity())
        );

        userProfile.getTradingHistories().add(newTradingHistory);
    }
}
