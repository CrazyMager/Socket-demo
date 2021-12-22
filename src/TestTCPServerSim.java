import util.ReadDataFromFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


class ThreadServerSocketSim implements Runnable {
    private Socket clientSocket;

    public ThreadServerSocketSim(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            System.out.println("client connected" + clientSocket.getInetAddress());
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));

            System.out.println("waiting receive");
            String recvInt = reader.readLine();
            System.out.println(Integer.parseInt(recvInt));
            String recvDouble = reader.readLine();
            System.out.println(Double.parseDouble(recvDouble));
            String recvString = reader.readLine();
            System.out.println(recvString);
            String recvByte = reader.readLine();
            byte[] recvByteB = new byte[100];
            recvByteB = recvByte.getBytes("US-ASCII");
            System.out.println(recvByte);

            DataOutputStream dos=new DataOutputStream(output);
            dos.write(new ReadDataFromFile().readData("E:\\9-7.mp4", 100));
            dos.flush();
            dos.close();


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

public class TestTCPServerSim {
    private static final int PORT = 8082;


    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            int counter = 1;
            serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("第 " + (counter++) + " 个连接");
                Thread t = new Thread(new ThreadServerSocketSim(clientSocket));
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


