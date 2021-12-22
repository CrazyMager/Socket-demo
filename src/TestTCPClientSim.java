import util.ReadDataFromFile;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TestTCPClientSim {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            //对服务端发起连接请求
            socket = new Socket("127.0.0.1", 8082);
//            socket = new Socket("cn.utools.club", 42071);


            System.out.println(" connect server");


            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));


            Integer send = 882;
            Double sendDouble = 3412.132;
            String sendString = "String.";
            byte[] sendByte = new ReadDataFromFile().readData("E:\\9-7.mp4", 100);
            writer.write(send.toString());
            writer.newLine();
            writer.write(sendDouble.toString());
            writer.newLine();
            writer.write(sendString);
            writer.newLine();
            // 数组类中并没有对toString()方法重写(override)。所以,数组直接使用toString()的结果也是[类型@哈希值]。
            // writer.write(sendByte.toString());
            String sendByteStr = new String(sendByte,"US-ASCII");
            writer.write(sendByteStr);
            writer.newLine();
            writer.flush();

            DataInputStream dis = new DataInputStream(input);
            byte[] recvByte = new byte[100];
            dis.read(recvByte);
            System.out.println("receive:"+recvByte);

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
