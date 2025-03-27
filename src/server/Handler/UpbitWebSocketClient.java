package server.Handler;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class UpbitWebSocketClient {

    // 연결된 클라이언트 소켓 관리
    public static List<ClientHandler> clients = new ArrayList<>();

    public static void connect() {
        HttpClient client = HttpClient.newHttpClient();

        client.newWebSocketBuilder()
                .buildAsync(URI.create("wss://api.upbit.com/websocket/v1"), new WebSocket.Listener() {
                    @Override
                    public void onOpen(WebSocket webSocket) {
                        System.out.println("✅ 업비트에 연결됨");

                        String subscribeMessage = "[{\"ticket\":\"test\"},{\"type\":\"ticker\",\"codes\":[\"KRW-BTC\"]}]";
                        ByteBuffer buffer = StandardCharsets.UTF_8.encode(subscribeMessage);
                        webSocket.sendBinary(buffer, true);

                        WebSocket.Listener.super.onOpen(webSocket);
                    }

                    @Override
                    public CompletionStage<?> onBinary(WebSocket webSocket, ByteBuffer data, boolean last) {

                        String message = StandardCharsets.UTF_8.decode(data).toString();
                        System.out.println("📥 업비트 데이터 수신: " + message);

                        // 연결된 모든 클라이언트에 전송
                        broadcastToClients(message);

                        return WebSocket.Listener.super.onBinary(webSocket, data, last);
                    }
                });
    }

    // 연결된 클라이언트에게 데이터 전송
    private static void broadcastToClients(String message) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                client.send(message);
            }
        }
    }
}
