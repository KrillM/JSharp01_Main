package N14_Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class BidirectionServer{
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("서버 실행 중... 클라이언트 기다리는 중...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("클라이언트 연결 됨");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String clientMessage = in.readLine();
        System.out.println("클라이언트로부터 받은 메시지: " + clientMessage );
        out.println("서버의 응답 : 메시지 잘 받았습니다!");

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}

class BidirectionClient{
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 9999);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println("서버 안녕! 클라이언트야!");
        String serverReply = in.readLine();
        System.out.println("서버 응답 : "+serverReply);

        in.close();
        out.close();
        socket.close();
    }
}

public class Ex02_BidirectionalSocket {
    public static void main(String[] args) throws Exception{
        Thread serverThread = new Thread(()->{
            try{
                BidirectionServer.main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread clientThread = new Thread(()->{
            try {
                Thread.sleep(1000);
                BidirectionClient.main(null);
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
