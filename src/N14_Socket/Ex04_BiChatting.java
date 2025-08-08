package N14_Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class BiServer{
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("서버 실행 중");

        Socket clientSocket = serverSocket.accept();
        System.out.println("클라이언트 연결 됨");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);
        Scanner sc = new Scanner(System.in);
        String message;

        while (true){
            System.out.println("서버 : ");
            message = sc.nextLine();
            out.println(message);

            if(message.equalsIgnoreCase("exit")) break;

            message = in.readLine();
            if(message == null || message.equalsIgnoreCase("exit")) break;

            System.out.println("클라이언트 : " + message);
        }

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
        sc.close();
    }
}

class BiClient{
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 9999);
        System.out.println("서버에 연결됨");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        Scanner sc = new Scanner(System.in);
        String message;

        while (true){
            message = in.readLine();
            if(message == null || message.equalsIgnoreCase("exit")) break;

            System.out.println("서버 : "+ message);

            System.out.println("클라이언트 : ");
            message = sc.nextLine();
            out.println(message);

            if(message.equalsIgnoreCase("exit")) break;
        }

        System.out.println("채팅 종료");

        in.close();
        out.close();
        socket.close();
        sc.close();
    }
}

public class Ex04_BiChatting {
    public static void main(String[] args) throws Exception{
        Thread serverThread = new Thread(()->{
           try {
               BiServer.main(null);
           } catch (Exception e) {
               e.printStackTrace();
           }
        });

        Thread clientThread = new Thread(()->{
           try {
               Thread.sleep(1000);
               BiClient.main(null);
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
