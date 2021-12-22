package entity;

/**
 * @description:
 * @projectName:Unknown
 * @see:entity
 * @author:Lujw
 * @createTime:21:28 2021/5/25
 * @version:1.0
 */
public class SendMessage {

    long time;
    double trueLon;
    double trueLat;
    double fakeLon;
    double fakeLat;
    String fakeLocation;
    byte[] videoByte;

    public String getFakeLocation() {
        return fakeLocation;
    }

    public void setFakeLocation(String fakeLocation) {
        this.fakeLocation = fakeLocation;
    }

    public byte[] getVideoByte() {
        return videoByte;
    }

    public void setVideoByte(byte[] videoByte) {
        this.videoByte = videoByte;
    }

    public SendMessage(long time, double trueLon, double trueLat, double fakeLon, double fakeLat, String fakeLocation, byte[] videoByte) {
        this.time = time;
        this.trueLon = trueLon;
        this.trueLat = trueLat;
        this.fakeLon = fakeLon;
        this.fakeLat = fakeLat;
        this.fakeLocation = fakeLocation;
        this.videoByte = videoByte;
    }

    public SendMessage(long time, double trueLon, double trueLat, double fakeLon, double fakeLat) {
        this.time = time;
        this.trueLon = trueLon;
        this.trueLat = trueLat;
        this.fakeLon = fakeLon;
        this.fakeLat = fakeLat;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getTrueLon() {
        return trueLon;
    }

    public void setTrueLon(double trueLon) {
        this.trueLon = trueLon;
    }

    public double getTrueLat() {
        return trueLat;
    }

    public void setTrueLat(double trueLat) {
        this.trueLat = trueLat;
    }

    public double getFakeLon() {
        return fakeLon;
    }

    public void setFakeLon(double fakeLon) {
        this.fakeLon = fakeLon;
    }

    public double getFakeLat() {
        return fakeLat;
    }

    public void setFakeLat(double fakeLat) {
        this.fakeLat = fakeLat;
    }
}
