package client;

import client.service.GameManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static client.service.ConsoleManager.*;
import static client.service.GameManager.userProfile;
import static client.service.UserService.saveUserProfile;

public class UpbitClient {
    public static String SAVE_FILE = "user_profile.dat";

    public static void main(String[] args) {
        printStart();

        String serverAddress = "localhost";
        int port = 9999;
        GameManager gameManager = new GameManager();

        try (
                Socket socket = new Socket(serverAddress, port);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        ) {
            System.out.println("✅ 서버 연결 완료.");
            gameManager.gameInit();
            // 메시지 수신 쓰레드
            new Thread(() -> {
                try {
                    String line;
                    while ((line = in.readLine()) != null) {
                        //System.out.println("📥 서버로부터: " + line);
                        gameManager.updateCoinMap(line);
                    }
                } catch (Exception e) {
                    System.out.println("🔌 수신 스레드 종료됨.");
                }
            }).start();
            if(gameManager.gameStart()){
                saveUserProfile(userProfile, SAVE_FILE);
                System.out.println("모두의 코인 서비스를 종료합니다.");
                out.println("exit");
                System.exit(0);
            }
            
            // 사용자 입력 → 서버 전송
            String userInput;
            while ((userInput = consoleInput.readLine()) != null) {
                out.println(userInput); // 서버로 전송
            }

        } catch (Exception e) {
            System.err.println("❌ 연결 실패: " + e.getMessage());
        }
    }
}
