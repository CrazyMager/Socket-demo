package util;

import org.apache.commons.io.IOUtils;

import java.io.*;
/**
 * @description:
 * @projectName:TCPServerAndClient
 * @see:util
 * @author:Lujw
 * @createTime:12:41 2021/10/23
 * @version:1.0
 */
public class ReadDataFromFile {
    public byte[] readDataFromFile(String path, int length) {
        byte[] buffer = new byte[length];
        try {
            IOUtils.toByteArray(new FileInputStream(path), length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public byte[] readData(String path, int length) {
        byte[] buffer = new byte[length];
        try {
            DataInputStream is = new DataInputStream(
                    new BufferedInputStream(new FileInputStream(path)));
            int tag = is.read(buffer, 0, length);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public void readData() {
        try {
            DataInputStream is = new DataInputStream(
                    new BufferedInputStream(new FileInputStream(
                            "E:\\data.dat")));
            System.out.println(is.readInt());
            System.out.println(is.readByte());
            System.out.println(is.readBoolean());
            System.out.println(is.readFloat());
            System.out.println(is.readLong());
            System.out.println(is.readUTF());

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
