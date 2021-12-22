import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import entity.*;
import com.alibaba.fastjson.JSON;
import util.ReadDataFromFile;

class ThreadServerSocket2 implements Runnable {
    private Socket clientSocket;

    public ThreadServerSocket2(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            System.out.println("client connected" + clientSocket.getInetAddress());
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
//            BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
            Scanner scanner = new Scanner(new InputStreamReader(input, StandardCharsets.UTF_8));

            // 使用长连接
            String recvJson = null;

            while (scanner.hasNextLine()) {
                recvJson = scanner.nextLine();
                System.out.println("waiting receive");
                System.out.println("receive:" + recvJson);
                RecvMessage recv = JSON.parseObject(recvJson, RecvMessage.class);
                int token = recv.getToken();
                long time = recv.getTime();
                System.out.println("resolve json:" + token + " " + time);


                if (token == 888888) {
                    SendMessage sendMessage = new SendMessage(0L, 1, 1, 1, 1, "zifuchuan",
                            new ReadDataFromFile().readDataFromFile("E:\\02 Projects\\牛客算法课\\算法初级班" +
                                    "\\牛客网 算法初级班第4期课程（已完结）\\初级1.mp4", 100));
                    ArrayList<SendMessage> message = new ArrayList<SendMessage>();
                    message.add(sendMessage);

                    Send sendJson = new Send(203, 1, message);
                    // 注意：toJSONString方法使用的对象变量都需要有getter和setter方法
                    String jsonSend = JSON.toJSONString(sendJson);

                    writer.write(jsonSend);
                    writer.newLine();
                    writer.flush();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } // run() end
}

public class TestTCPServerKeepAlive {
    private static final int PORT = 8081;


    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            int counter = 1;
            serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("第 " + (counter++) + " 个连接");
                Thread t = new Thread(new ThreadServerSocket2(clientSocket));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //操作结束，关闭socket
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

