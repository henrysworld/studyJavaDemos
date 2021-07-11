package week02.nio01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer01 {
    static int count = 0;
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(8801);
            while (true){
                Socket socket = serverSocket.accept();
                service(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void service(Socket socket){
        try {
//            try {
//                System.out.println(count);
//                count++;
//                Thread.sleep(16000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 Ok");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello socket nio01";
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
