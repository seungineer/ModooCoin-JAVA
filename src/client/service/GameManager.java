package client.service;

import client.dto.UserProfileDTO;
import client.exception.NotValidUserNameException;
import display.dto.Coin;
import display.type.CoinType;
import utils.CoinUpdater;

import static client.UpbitClient.SAVE_FILE;
import static client.service.UserService.loadUserProfile;
import static client.service.ConsoleManager.*;
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

    public boolean gameStart(){
        boolean isEnd = true;
        printMain();
        while(isEnd){
            isEnd = selectedMenu();
        }
        return true;
    }

    /*
        1. Long / short
        2. 청산하기
        3. 히스토리 보기
        4. 히스토리 지우기
        5. 유저 정보 보기
     */
//    public void showMenu(){
//        StringBuilder sb = new StringBuilder();
//        sb.append("====================================\n");
//        sb.append("원하시는 서비스를 입력해주세요 ! \n");
//        sb.append("트레이딩 메뉴\n");
//        sb.append("[Long / Short / Clear]\n");
//        sb.append("사용자 정보 메뉴\n");
//        sb.append("[Info / Position / History / DeleteHistory]\n");
//        sb.append("게임 종료\n[Exit]\n");
//        System.out.println(sb);
//
//    }

    public boolean selectedMenu() {
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
//            case "DeleteHistory":
//                deleteHistory();
//                break;
            case "뒤로 가기":
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

    private void getPosition() {
        tradingService.getPosition(userProfile);
    }

    private void deleteHistory(){
        historyService.deleteHistory(userProfile);
    }

    private void getHistory(){
        historyService.getTradingHistories(userProfile);
    }

    private void getUserInfo(){
        userService.getUserInfo(userProfile);
    }

    private void clearPosition() {
        if(userProfile.getPositions().isEmpty()){
//            System.out.println("현재 포지션이 존재하지않습니다.");
            return;
        }
        // 포지션 목록 보여주기
//        historyService.getCurrentPositions(userProfile);

        // 포지션 청산하기
        System.out.println("청산하기 원하는 포지션의 번호를 입력해주세요.");
        int num = getInteger();
        if (num <= 0 || num > userProfile.getPositions().size()) {
            System.out.println("해당 번호의 포지션은 존재하지 않습니다.");
            return;
        }
        tradingService.closePosition(userProfile,num - 1);

        System.out.println("포지션 청산 완료.");
    }

    public void enterPosition(String orderType) {
        System.out.print("코인이름을 입력해주세요: ");
        CoinType coinName = getValidCoinType();

        System.out.print("수량을 입력해주세요: ");
        Long quantity = getLong();

        if(!coinMap.containsKey(coinName)){
            System.out.println("코인 이름이 잘못되었습니다. ex) KRW-BTC");
            return;
        }

        Coin coin = coinMap.get(coinName);
        tradingService.enterPosition(userProfile,coin.getCoinName().toString(), quantity, coin.getCurrentPrice(),orderType);
        System.out.printf("%s 포지션 진입 완료\n", orderType);
    }

    public int getInteger(){
        while(true){
            try{
                return Integer.parseInt(sc.nextLine());
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
            }
        }
    }
}
