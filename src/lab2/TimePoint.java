package lab2;

public class TimePoint {

    private String time;
    private int hour;
    private int minute;

    public TimePoint(final String time) {
	String[] parts = time.split(":");
	this.time = time;
        this.hour = Integer.parseInt(parts[0]);
        this.minute = Integer.parseInt(parts[1]);
    }

    @Override public String toString() {
	return this.time;
    }

    public int getHour() {
	return hour;
    }

    public int getMinute() {
	return minute;
    }
}
