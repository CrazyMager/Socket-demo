package entity;

import java.util.ArrayList;

/**
 * @description:
 * @projectName:Unknown
 * @see:entity
 * @author:Lujw
 * @createTime:21:27 2021/5/25
 * @version:1.0
 */
public class Send {
    int type;
    int count;
    ArrayList<SendMessage> message;

    public Send() {
    }

    public Send(int type, int count, ArrayList<SendMessage> message) {
        this.type = type;
        this.count = count;
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<SendMessage> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<SendMessage> message) {
        this.message = message;
    }
}
