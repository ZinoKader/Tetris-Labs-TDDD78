package lab2;

public class Appointment {

    private String subject;
    private Date date;
    private TimeSpan timeSpan;

    public Appointment(final String subject, final Date date, final TimeSpan timeSpan) {
	this.subject = subject;
	this.date = date;
	this.timeSpan = timeSpan;
    }

    public String getSubject() {
	return subject;
    }

    public Date getDate() {
	return date;
    }

    public TimeSpan getTimeSpan() {
	return timeSpan;
    }

    public void setSubject(final String subject) {
	this.subject = subject;
    }

    public void setDate(final Date date) {
	this.date = date;
    }

    public void setTimeSpan(final TimeSpan timeSpan) {
	this.timeSpan = timeSpan;
    }

    @Override public String toString() {
	return  date.toString() + " | " + timeSpan.toString() + " | " + subject;
    }
}
