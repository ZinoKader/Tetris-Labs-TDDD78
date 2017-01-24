package lab2;

import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private List<Appointment> appointments;

    public Calendar() {
	appointments = new ArrayList<>();
    }

    public void show() {
	for (Appointment appointment : appointments) {
	    System.out.println(appointment.toString());
	}
    }

    public void book(int year, String month, int day, String start, String end, String subject) {

	if(year < 2013) {
	    throw new IllegalArgumentException("Year must be > 2013");
	}
	if(!(0 <= new TimePoint(start).getHour() && new TimePoint(start).getHour() <= 23)
		|| !(0 <= new TimePoint(end).getHour() && new TimePoint(end).getHour() <= 23)) {
	    throw new IllegalArgumentException("Hours must only span from 0 to 23");
	}

	if(!(0 <= new TimePoint(start).getMinute() && new TimePoint(start).getMinute() <= 59)
		|| !(0 <= new TimePoint(end).getMinute() && new TimePoint(end).getMinute() <= 59)) {
	    throw new IllegalArgumentException("Minutes must only span from 0 to 59");
	}

	if(Month.getMonthNumber(month) == -1) {
	    throw new IllegalArgumentException("Please enter a valid month");
	}

	if(Month.getMonthDays(month) < day) {
	    throw new IllegalArgumentException("Your booked day for the chosen month surpasses the number of days in that month");
	}

	Month bookMonth = new Month(month, Integer.toString(Month.getMonthNumber(month)), Integer.toString(Month.getMonthDays(month)));
	Date bookDate = new Date(year, bookMonth, day);
	TimePoint startTime = new TimePoint(start);
	TimePoint endTime = new TimePoint(end);
	TimeSpan bookSpan = new TimeSpan(startTime, endTime);

	this.appointments.add(new Appointment(subject, bookDate, bookSpan));


    }

}
