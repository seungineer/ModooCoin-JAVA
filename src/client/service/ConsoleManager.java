package client.service;

import client.dto.TradingHistoryDTO;
import client.dto.PositionDTO;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import static client.service.GameManager.userProfile;

public class ConsoleManager {
    public static void printStart() {
        printVoid();
        System.out.println( "  __  __           _                ____      _         _ _ \n" +
                            " |  \\/  | ___   __| | ___   ___    / ___|___ (_)_ __   | | |\n" +
                            " | |\\/| |/ _ \\ / _` |/ _ \\ / _ \\  | |   / _ \\| | '_ \\  | | |\n" +
                            " | |  | | (_) | (_| | (_) | (_) | | |__| (_) | | | | | |_|_|\n" +
                            " |_|  |_|\\___/ \\__,_|\\___/ \\___/   \\____\\___/|_|_| |_| (_|_)");
    }

    public static void printMain() {
        printVoid();
        System.out.printf( "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\n" +
                            "|　모두의 코인 (메인)　　　　　　　　　　　　　　[－][口][×] |\n" +
                            "|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣|\n" +
                            "|　%s님, 환영합니다 !        　　　　　　　　　　　　　　　　\n" +
                            "|　아래의 메뉴 중 원하시는 서비스를 입력해주세요.        　|\n" +
                            "|　        　　　　　　　　　　　　　　　　　　　　　　　　 　|\n" +
                            "| 　＿＿＿＿＿＿　　 　 ＿＿＿＿＿＿　　　 　＿＿＿＿＿＿＿　　|\n" +
                            "|  |  Long  |　　  |  Short |　　  |  청산하기  | 　|\n" +
                            "| 　￣￣￣￣￣￣　　  　￣￣￣￣￣￣　　　 　￣￣￣￣￣￣￣　　|\n" +
                            "| 　＿＿＿＿＿＿＿　  　＿＿＿＿＿＿　　　 ＿＿＿＿＿＿＿＿　　|\n" +
                            "|  | 내 포지션 |　 　| 내 정보  |　 　|  거래 기록  |  |\n" +
                            "| 　￣￣￣￣￣￣￣　  　￣￣￣￣￣￣　　 　￣￣￣￣￣￣￣￣　　|\n" +
                            "|　　　　　　　　     ＿＿＿＿＿＿＿＿　　　　　　　　　　　　 |\n" +
                            "|　　　　　　　　     |  종료하기　 |　　　　　　　　　　　  |\n" +
                            "|　　　　　　　　     ￣￣￣￣￣￣￣￣　　　　　　　　　　　　 |\n" +
                            "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\n", userProfile.getUsername());
    }

    public static void printTrade() {
        printVoid();
        System.out.printf( "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\n" +
                "|　모두의 코인 (메인)　　　　　　　　　　　　　　[－][口][×] |\n" +
                "|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣|\n" +
                "|　%s님, 환영합니다 !        　　　　　　　　　　　　　　　　\n" +
                "|　아래의 메뉴 중 원하시는 서비스를 입력해주세요.        　|\n" +
                "|　        　　　　　　　　　　　　　　　　　　　　　　　　 　|\n" +
                "| 　＿＿＿＿＿＿　　 　 ＿＿＿＿＿＿　　　 　＿＿＿＿＿＿＿　　|\n" +
                "|  |  Long  |　　  |  Short |　　  |  청산하기  | 　|\n" +
                "| 　￣￣￣￣￣￣　　  　￣￣￣￣￣￣　　　 　￣￣￣￣￣￣￣　　|\n" +
                "| 　＿＿＿＿＿＿＿　  　＿＿＿＿＿＿　　　 ＿＿＿＿＿＿＿＿　　|\n" +
                "|  | 내 포지션 |　 　| 내 정보  |　 　|  거래 기록  |  |\n" +
                "| 　￣￣￣￣￣￣￣　  　￣￣￣￣￣￣　　 　￣￣￣￣￣￣￣￣　　|\n" +
                "|　　　　　　　　     ＿＿＿＿＿＿＿＿　　　　　　　　　　　　 |\n" +
                "|　　　　　　　　     |  종료하기　 |　　　　　　　　　　　  |\n" +
                "|　　　　　　　　     ￣￣￣￣￣￣￣￣　　　　　　　　　　　　 |\n" +
                "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\n", userProfile.getUsername());
    }

    public static void printPosition() {
        printVoid();
        ArrayList<PositionDTO> positionList = userProfile.getPositions();

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println(" 　모두의 코인 (내 포지션) 　　　　　　　　　　　　　　　　　　　　                          [－][口][×]     ");
        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");

        // 테이블 헤더
        System.out.println("  번호  |   코인명   |   포지션   |      진입가      |     현재가     |     수량     |      손익       ");
        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");

        if (positionList.isEmpty()) {
            System.out.println("                             보유 중인 포지션이 없습니다                                 \n");
        } else {
            // 포지션 목록 출력
            for (int i = 0; i < positionList.size(); i++) {
                PositionDTO position = positionList.get(i);

                // 손익에 따라 색상 지정 (ANSI 이스케이프 코드)
                String profitColor = position.getProfit() >= 0 ? "\u001B[32m" : "\u001B[31m"; // 양수면 녹색, 음수면 적색
                String resetColor = "\u001B[0m";

                // 포맷팅된 가격 변화율 계산 (%)
                double priceChangeRate = ((double)position.getCurrentPrice() / position.getEntryPrice() - 1) * 100;
                String changeRateFormatted = String.format("%.2f%%", priceChangeRate);

                // 날짜 포맷팅
                String entryDate = position.getEntryTime().split("T")[0];

                System.out.printf(" %d | %-8s | %-8s | %,12d | %,12d | %,7d | %s%,12d%s |\n",
                        i + 1,
                        position.getCoinName(),
                        position.getOrderType(),
                        position.getEntryPrice(),
                        position.getCurrentPrice(),
                        position.getQuantity(),
                        profitColor,
                        position.getProfit(),
                        resetColor);
            }
        }

        // 뒤로 가기 버튼
        System.out.println(" 　　　　　　　　                        ＿＿＿＿＿＿＿＿　　　　　　　　　　　　                 ");
        System.out.println(" 　　　　　　　　                       |  뒤로 가기　 |　　　　　　　　　　　                  ");
        System.out.println(" 　　　　　　　　                        ￣￣￣￣￣￣￣￣　　　　　　　　　　　　                  ");
        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
    }

    public static void printUserInfo() {
        printVoid();
        System.out.printf("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\n" +
                        "　모두의 코인 (내 정보)　　　　　　　　　　　　[－][口][×] \n" +
                        "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\n" +
                        "    이름: %s\n" +
                        "    잔고: %s\n" +
                        "    수익: %s\n" +
                        "　 　　　 ＿＿＿＿＿＿＿＿　　　      ＿＿＿＿＿＿＿＿　　　　 \n" +
                        " 　　　　|  뒤로 가기　 |         |  계정 삭제　 |　　  \n" +
                        " 　　　　 ￣￣￣￣￣￣￣￣　　　      ￣￣￣￣￣￣￣￣　　　　 \n" +
                        "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\n",
                userProfile.getUsername(),
                toLocaleString(userProfile.getUserDeposit()),
                toLocaleString(userProfile.getUserProfit()));
    }

    public static void printHistory() {
        printVoid();
        ArrayList<TradingHistoryDTO> historyList = userProfile.getTradingHistories();

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println(" 　모두의 코인 (거래 기록)　　　　　　　　　　　　　　　　　　　　                          [－][口][×]     ");
        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");

        // 테이블 헤더
        System.out.println("    코인명   |   포지션   |      청산일자      |     진입가     |     청산가     |      손익       ");
        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");

        if (historyList.isEmpty()) {
            System.out.println("                             거래 기록이 없습니다                                 \n");
        } else {
            // 거래 기록 출력
            for (TradingHistoryDTO history : historyList) {
                // 손익에 따라 색상 지정 (ANSI 이스케이프 코드)
                String benefitColor = history.getBenefit() >= 0 ? "\u001B[32m" : "\u001B[31m"; // 양수면 녹색, 음수면 적색
                String resetColor = "\u001B[0m";

                // 통화 포맷 설정
                NumberFormat currencyFormat = NumberFormat.getNumberInstance(Locale.KOREA);

                System.out.printf("| %-8s | %-8s | %-18s | %,10d | %,10d | %s%,10d%s |\n",
                        history.getCoinName(),
                        history.getOrderType(),
                        history.getCloseTime() != null ? history.getCloseTime().split("T")[0] : "진행중",
                        history.getEntryPrice(),
                        history.getClosePrice() > 0 ? history.getClosePrice() : 0,
                        benefitColor,
                        history.getBenefit(),
                        resetColor);
            }
        }

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");

        // 페이지네이션 또는 요약 정보
        int totalProfit = historyList.stream().mapToInt(h -> (int)h.getBenefit()).sum();
        String totalProfitColor = totalProfit >= 0 ? "\u001B[32m" : "\u001B[31m";
        System.out.printf("  총 거래: %-3d건                                  총 손익: %s%,10d%s     \n",
                historyList.size(), totalProfitColor, totalProfit, "\u001B[0m");

        // 뒤로가기 버튼
        System.out.println(" 　　　　　　　　                        ＿＿＿＿＿＿＿＿　　　　　　　　　　　　                 ");
        System.out.println(" 　　　　　　　　                       |  뒤로 가기　 |　　　　　　　　　　　                  ");
        System.out.println(" 　　　　　　　　                        ￣￣￣￣￣￣￣￣　　　　　　　　　　　　                  ");
        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
    }

//    public static void printExit() {
//    }

    public static void printVoid() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

    private static String toLocaleString(long number) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.KOREA);
        String formattedCurrency = currencyFormat.format(number);

        return formattedCurrency;
    }
}
