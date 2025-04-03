package client.service;

import java.time.LocalDateTime;
import client.dto.PositionDTO;
import static client.service.UserService.*;

import static client.test.Test.userProfile;

public class TradingService {
    public static void enterPosition(String coinName, long quantity, long entryPrice, String orderType) {
        if (userProfile.getUserDeposit() < entryPrice * quantity) {
            System.out.println("계좌에 잔액이 부족합니다.");
            return;
        }

        PositionDTO newPosition = new PositionDTO(
                coinName,
                quantity,
                entryPrice,
                LocalDateTime.now().toString(),
                entryPrice,
                orderType,
                0
        );

        userProfile.getPositions().add(newPosition);
        userProfile.setUserDeposit(userProfile.getUserDeposit() - entryPrice * quantity);
    }

    public static void closePosition(int index) {
        PositionDTO targetPosition = userProfile.getPositions().get(index);
        addTradingHistory(targetPosition);

        userProfile.setUserDeposit(
                userProfile.getUserDeposit() +
                        targetPosition.getCurrentPrice() * targetPosition.getQuantity()
        );

        userProfile.getPositions().remove(index);
    }
}
