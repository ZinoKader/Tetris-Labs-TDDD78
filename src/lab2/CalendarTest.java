package lab2;

public class CalendarTest {
    public static void main(String[] args) {
	Calendar calendar = new Calendar();

	calendar.book(2017, "february", 2, "20:50", "21:55","Eat dinner.");
	calendar.book(2017, "march", 6, "10:20", "10:30","Get the laundry.");
	calendar.book(2017, "march", 18, "15:50", "16:45","Do homework.");
	calendar.book(2017, "april", 17, "13:00", "15:00","Prepare lunchboxes.");
	calendar.book(2017, "may", 28, "11:30", "12:30","Eat lunch.");
	calendar.book(2017, "june", 30, "08:00", "09:00","Morning routine.");
	calendar.book(2018, "january", 1, "00:00", "03:00","Celebrate the new year!");
	calendar.book(2021, "june", 18, "00:00", "23:59","Celebrate your finished degree!");

	calendar.show();

    }
}
