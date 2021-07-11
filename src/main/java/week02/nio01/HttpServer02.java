package week02.nio01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer02 {
    static int count = 0;
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(8802);
            while (true){
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    service(socket);
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void service(Socket socket){
        try {
//            System.out.println(count);
//            count++;
//            Thread.sleep(16000);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 Ok");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello socket nio02222";
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
