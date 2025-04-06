package client.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import client.dto.PositionDTO;
import client.dto.UserProfileDTO;

import static client.service.GameManager.coinMap;
import static client.service.UserService.*;


public class TradingService {
    HistoryService historyService = new HistoryService();
    UserService userService = new UserService();

    public boolean enterPosition(UserProfileDTO userProfile,String coinName, long quantity, long entryPrice, String orderType) {
        if (userProfile.getUserDeposit() < entryPrice * quantity) {
            System.out.println("계좌에 잔액이 부족합니다.");
            return false;
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
        return true;
    }

    public void closePosition(UserProfileDTO userProfile,int index) {
        PositionDTO targetPosition = userProfile.getPositions().get(index);
        userService.addTradingHistory(userProfile,targetPosition);

        userProfile.setUserDeposit(
                userProfile.getUserDeposit() +
                        targetPosition.getCurrentPrice(coinMap) * targetPosition.getQuantity()
        );

        userProfile.getPositions().remove(index);
    }

    public void getPosition(UserProfileDTO userProfileDTO){
        ArrayList<PositionDTO> positions = userProfileDTO.getPositions();
        if(positions.isEmpty()){
            System.out.println("포지션 내역이 존재하지 않습니다!");
        }
        for(PositionDTO position : positions){
            System.out.println(position);
        }
    }
}
