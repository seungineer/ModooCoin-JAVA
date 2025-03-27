package server.Handler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket socket;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            this.out = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(String message) {
        if (out != null) {
            out.println(message);
        }
    }

    @Override
    public void run() {
        System.out.println("🔌 클라이언트 연결됨: " + socket.getInetAddress());

        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("📩 클라이언트로부터 받은 명령: " + line);

                // 예시: 클라이언트가 "stop" 명령 보내면 이 클라이언트에 데이터 전송 중지
                if (line.equalsIgnoreCase("stop")) {
                    send("✅ 전송 중지됨. bye~");
                    break; // 쓰레드 종료됨 → 연결 끊김
                }

                // 예시: 특정 명령어를 처리해서 서버 상태 변경
                if (line.equalsIgnoreCase("status")) {
                    send("📡 서버 상태: 정상 운영 중입니다.");
                }

                // 더 많은 명령 처리 로직 가능
            }

            socket.close(); // 명령 종료 후 소켓 닫기

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
