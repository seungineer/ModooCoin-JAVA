package server;

import server.Handler.ClientHandler;
import server.Handler.UpbitWebSocketClient;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        // 업비트 웹소켓 연결
        UpbitWebSocketClient.connect();

        // 클라이언트 TCP 서버 시작
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("🚀 서버 시작: 포트 9999에서 대기 중...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(clientSocket);
                UpbitWebSocketClient.clients.add(handler);
                handler.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
