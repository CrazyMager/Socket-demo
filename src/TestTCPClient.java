import com.alibaba.fastjson.JSON;
import entity.RecvMessage;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TestTCPClient {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8081;

    public static void main(String[] args) {
        Socket socket = null;
        try {
            //对服务端发起连接请求
            socket = new Socket(HOST, 8081);
            System.out.println("connect server");


            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));

            RecvMessage sendMessage = new RecvMessage(888888, 162322088634L);
            String jsonSend = JSON.toJSONString(sendMessage);

            writer.write(jsonSend);
            writer.newLine();
            writer.flush();

            String recvJson = reader.readLine();
            System.out.println("receive:" + recvJson);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
