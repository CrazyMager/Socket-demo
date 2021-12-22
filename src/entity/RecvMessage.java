package entity;

/**
 * @description:
 * @projectName:Unknown
 * @see:entity
 * @author:Lujw
 * @createTime:21:29 2021/5/25
 * @version:1.0
 */
public class RecvMessage {

    int token;
    long time;

    public RecvMessage(){}

    public RecvMessage(int token, long time) {
        this.token = token;
        this.time = time;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}

