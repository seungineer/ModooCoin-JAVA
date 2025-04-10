package client.service;

import client.dto.UserProfileDTO;
import client.exception.NotValidUserNameException;
import client.exception.UserProfileSaveFailedException;
import display.dto.Coin;
import display.type.CoinType;
import utils.CoinUpdater;

import static client.UpbitClient.SAVE_FILE;
import static client.service.UserService.loadUserProfile;
import static client.service.ConsoleManager.*;
import static client.service.UserService.saveUserProfile;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import client.exception.UserProfileNotFoundException;
import client.exception.NotValidUserCommandException;

public class GameManager {
    public static UserProfileDTO userProfile;
    public static HashMap<CoinType, Coin> coinMap = new HashMap<>();
    public CoinUpdater coinUpdater = new CoinUpdater();
    public Scanner sc = new Scanner(System.in);

    public UserService userService = new UserService();
    public TradingService tradingService = new TradingService();
    public HistoryService historyService = new HistoryService();

    public void gameInit() throws UserProfileNotFoundException, NotValidUserNameException, InterruptedException {
        System.out.println("모두의 코인 트레이딩 서비스 시작..");
        userProfile = loadUserProfile(SAVE_FILE);
        coinUpdater.setCoinMap(coinMap);
        Thread.sleep(3000);
    }

    public void updateCoinMap(String data){
        coinUpdater.updateCoinMap(data,coinMap);
        for(CoinType coinType : coinMap.keySet()){
            Coin coin = coinMap.get(coinType);
        }
    }

    public boolean gameStart() throws InterruptedException {
        boolean isEnd = true;
        printMain();
        while(isEnd){
            isEnd = selectedMenu();
            try {
                saveUserProfile(userProfile, SAVE_FILE);
            } catch (UserProfileSaveFailedException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    public boolean selectedMenu() throws InterruptedException {
        System.out.print("메뉴 입력 : ");
        String input = sc.nextLine().trim();
        switch (input) {
            case "Long":
                enterPosition(input);
                break;
            case "Short":
                enterPosition(input);
                break;
            case "청산하기":
                printPosition();
                clearPosition();
                break;
            case "내 포지션":
                printPosition();
                break;
            case "내 정보":
                printUserInfo();
                break;
            case "거래 기록":
                printHistory();
                break;
            case "뒤로 가기":
                printMain();
                break;
            case "계정 삭제":
                DeleteAccount();
                printMain();
                break;
            case "종료하기":
                return false;
            default:
                System.out.println("옳바른 메뉴를 입력해주세요.");
                break;
        }
        return true;
    }

    private void DeleteAccount() {
        try {
            UserService.deleteCurrentUser(userProfile, SAVE_FILE);
            userProfile = loadUserProfile(SAVE_FILE);
        } catch (UserProfileSaveFailedException e) {
            throw new RuntimeException(e);
        } catch (NotValidUserNameException e) {
            throw new RuntimeException(e);
        } catch (UserProfileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearPosition() throws InterruptedException {
        if(userProfile.getPositions().isEmpty()){
            return;
        }

        // 포지션 청산하기
        System.out.println("청산하기 원하는 포지션의 번호를 입력해주세요.");
        int num = getInteger();
        if(num == -1){
            printMain();
            return;
        }
        if (num <= 0 || num > userProfile.getPositions().size()) {
            System.out.println("해당 번호의 포지션은 존재하지 않습니다.");
            Thread.sleep(1000);
            printMain();
            return;
        }
        tradingService.closePosition(userProfile,num - 1);

        System.out.println("포지션 청산 완료.");
        Thread.sleep(1000);
        printMain();
    }

    public void enterPosition(String orderType) throws InterruptedException {
        System.out.print("코인 이름을 입력해주세요: ");
        CoinType coinName = getValidCoinType();

        System.out.print("수량을 입력해주세요: ");
        Long quantity = getLong();

        if(!coinMap.containsKey(coinName)){
            System.out.println("코인 이름이 잘못되었습니다. ex) KRW-BTC");
            return;
        }

        Coin coin = coinMap.get(coinName);
        if(!tradingService.enterPosition(userProfile,coin.getCoinName().toString(), quantity, coin.getCurrentPrice(),orderType))
            return;
        System.out.printf("%s 포지션 진입 완료\n", orderType);
        Thread.sleep(1000);
        printMain();
    }

    public int getInteger(){
        while(true){
            try{
                String str = sc.nextLine();
                if(str.equals("뒤로 가기"))
                    return -1;
                return Integer.parseInt(str);
            }catch (NumberFormatException e){
                System.out.println("숫자를 옳바르게 입력해주세요.");
            }
        }
    }

    public Long getLong(){
        while(true){
            try{
                return Long.parseLong(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("숫자를 옳바르게 입력해주세요.");
            }
        }
    }

    public CoinType getValidCoinType() {
        while (true) {
            try {
                String coinName = sc.nextLine().trim().toUpperCase().replace("-", "_");
                return CoinType.valueOf(coinName);
            } catch (IllegalArgumentException e) {
                System.out.println("❌ 존재하지 않는 코인입니다. 다시 입력해주세요.");
                System.out.print("코인 이름을 입력해주세요: ");
            }
        }
    }
}
