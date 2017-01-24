package lab2;

import java.time.LocalDate;
import java.time.Period;

public class Person
{
    private String name;
    private LocalDate birthDay;

    public Person(final String name, final LocalDate birthDay) {
	this.name = name;
	this.birthDay = birthDay;
    }

    @Override public String toString() {
	return this.name + " " + getAge();
    }

    public int getAge() {
	return Period.between(this.birthDay, LocalDate.now()).getYears();
    }



    public static void main(String[] args) {
	Person zino = new Person("Zino", LocalDate.of(1997, 12, 25));
	Person viktor = new Person("Viktor", LocalDate.of(1997, 6, 2));
	Person arin = new Person("Artin", LocalDate.of(1996, 4, 1));
	Person martin = new Person("Martin", LocalDate.of(1997, 7, 14));
	System.out.println(zino.toString());
	System.out.println(viktor.toString());
	System.out.println(arin.toString());
	System.out.println(martin.toString());
    }
}
