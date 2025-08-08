package N14_Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class SimpleServer{
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("서버 실행 중... 클라이언트 대기 중...");

        Socket clientSocket = serverSocket.accept(); // 클라이언트 연결 대기
        System.out.println("클라이언트 연결 됨");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String message = in.readLine(); // 클라이언트로부터 메시지 1줄 수신
        System.out.println("클라이언트로부터 받은 메시지: " + message);

        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}

class SimpleClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 9999);

        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        out.println("Hello Server");

        out.close();
        socket.close();
    }
}

public class Ex01_SimpleSocket {
    public static void main(String[] args) throws Exception{

        // 서버 먼저 실행
        Thread serverThread = new Thread(()->{
            try{
                SimpleServer.main(null); // 서버 실행
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // 클래이언트는 약간 대기 후 실행(Thread 사용)
        Thread clientThread = new Thread(()->{
            try{
                Thread.sleep(1000); // 서버 먼저 열리게 약간 기다림
                SimpleClient.main(null); // 클라이언트 실행
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        serverThread.start();
        clientThread.start();

        serverThread.join();
        clientThread.join();
    }
}
