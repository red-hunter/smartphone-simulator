package simulator.models;

public class CallLog extends CallDetails {
    private int callHour;
    private int callMinute;
    private int callSecond;

    public CallLog(String name, String phone, int hour, int minute, int second){
        super();
        setName(name);
        setPhoneNumber(phone);
        setCallHour(hour);
        setCallMinute(minute);
        setCallSecond(second);
    }

    public int getCallHour() {
        return callHour;
    }

    public void setCallHour(int callHour) {
        this.callHour = callHour;
    }

    public int getCallMinute() {
        return callMinute;
    }

    public void setCallMinute(int callMinute) {
        this.callMinute = callMinute;
    }

    public int getCallSecond() {
        return callSecond;
    }

    public void setCallSecond(int callSecond) {
        this.callSecond = callSecond;
    }
}
