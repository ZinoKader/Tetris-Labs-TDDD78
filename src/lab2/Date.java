package lab2;

public class Date {

    private int year;
    private Month month;
    private int day;

    public Date(final int year, final Month month, final int day) {
	this.year = year;
	this.month = month;
	this.day = day;
    }

    public int getYear() {
	return year;
    }

    public Month getMonth() {
	return month;
    }

    public int getDay() {
	return day;
    }

    public void setYear(final int year) {
	this.year = year;
    }

    public void setMonth(final Month month) {
	this.month = month;
    }

    public void setDay(final int day) {
	this.day = day;
    }

    @Override public String toString() {
	return year + "-" + Month.getMonthNumber(month.getName()) + "-" + day;
    }
}
