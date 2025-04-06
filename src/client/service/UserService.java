package client.service;

import java.io.*;
import java.time.LocalDateTime;
import static client.test.Test.sc;
import static client.test.Test.userProfile;

import client.dto.*;
import client.exception.NotValidUserNameException;
import client.exception.UserProfileNotFoundException;
import client.exception.UserProfileSaveFailedException;

public class UserService {
    public static UserProfileDTO loadUserProfile(String fileName) throws UserProfileNotFoundException, NotValidUserNameException {
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("사용자 정보를 불러오는데 실패했습니다. 신규 사용자 데이터를 생성합니다.");

            while (true) {
                try {
                    System.out.print("사용자 이름을 입력하세요: ");
                    String username = sc.nextLine().trim();

                    if (username.isEmpty()) {
                        System.out.println("사용자 이름은 최소 1글자 이상이어야 합니다.");
                        continue;
                    }
                    return new UserProfileDTO(username);
                } catch (Exception e) {
                    throw new NotValidUserNameException();
                }
            }
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            System.out.println("사용자 정보를 불러오는데 성공했습니다.");
            return (UserProfileDTO) ois.readObject();
        } catch (Exception e) {
            throw new UserProfileNotFoundException();
        }
    }

    public void addTradingHistory(UserProfileDTO userProfile,PositionDTO position) {
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

    public void getUserInfo(UserProfileDTO userProfile){
        System.out.println("유저이름 : " + userProfile.getUsername());
        System.out.println("잔고 : " + userProfile.getUserDeposit());
    }

    public static void saveUserProfile(UserProfileDTO userProfile, String fileName) throws UserProfileSaveFailedException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(userProfile);
        } catch (Exception e) {
            throw new UserProfileSaveFailedException();
        }
    }

    public static void deleteCurrentUser(UserProfileDTO userProfile, String fileName) throws UserProfileSaveFailedException {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("기존 사용자 정보가 없습니다.");
            return;
        }
        if (file.delete()) {
            System.out.println("사용자 정보를 삭제하는데 성공했습니다.");
        } else {
            throw new UserProfileSaveFailedException();
        }
    }
}
