package N14_Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class ScannerServer{
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("서버 실행 중... 클라이언트 기다리는 중...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("클라이언트 연결 됨");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);

        String message;
        while ((message = in.readLine())!= null){
            System.out.println("클라이언트로부터 받은 메시지 : " + message);
            String response = "서버의 응답 : 메시지\'" + message +"\' 잘 받았습니다!";
            out.println(response);
        }

        System.out.println("클라이언트 연결 종료됨");

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}

class ScannerClient{
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 9999);
        System.out.println("서버에 연결됨");

        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Scanner sc = new Scanner(System.in);
        String input;

        while (true){
            System.out.println("보낼 메시지 입력 (exit 입력 시 종료)");
            input = sc.nextLine();

            if(input.equalsIgnoreCase("exit")) break;

            out.println(input); // 서버로 메시지 전송
            String response =  in.readLine(); // 서버 응답 수신
            System.out.println("서버 응답 : "+response);
        }

        out.close();
        in.close();
        socket.close();
        sc.close();
        System.out.println("클라이언트 종료");
    }
}

public class Ex03_ScannerSocket {
    public static void main(String[] args) throws Exception{
        Thread serverThread = new Thread(()->{
            try{
                ScannerServer.main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread clientThread = new Thread(()->{
            try {
                Thread.sleep(1000);
                ScannerClient.main(null);
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
