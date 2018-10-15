package cn.dlj1.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8888);


        while (true) {
            Socket socket = server.accept();

            new Thread(() -> {
                BufferedReader bufferedReader = null;
                PrintWriter printWriter = null;
                try {
                    bufferedReader = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));//获取输入流(请求)
                    StringBuilder stringBuilder = new StringBuilder();
                    String line = null;
                    while ((line = bufferedReader.readLine()) != null
                            && !line.equals("")) {
                        stringBuilder.append(line).append("\n");
                    }
                    String result = stringBuilder.toString();
                    System.out.println(result);

                    printWriter = new PrintWriter(
                            socket.getOutputStream(), true);

                    printWriter.println("HTTP/1.1 200 OK");
                    printWriter.println("Content-Type:text/html;charset=utf-8");
                    printWriter.println();
                    printWriter.println("<h5>你好世界<br>");

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        bufferedReader.close();
                        printWriter.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }).start();


        }


    }

}
