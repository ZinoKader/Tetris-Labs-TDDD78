package lab2;

public class Month {
    private String name;
    private String number;
    private String days;

    public Month(final String name, final String number, final String days) {
	this.name = name;
	this.number = number;
	this.days = days;
    }

    public static int getMonthNumber(String name) {
	switch (name.toLowerCase()) {
	    case "january":
		return 1;
	    case "february":
		return 2;
	    case "march":
		return 3;
	    case "april":
		return 4;
	    case "may":
		return 5;
	    case "june":
		return 6;
	    case "july":
		return 7;
	    case "august":
		return 8;
	    case "september":
		return 9;
	    case "october":
		return 10;
	    case "november":
		return 11;
	    case "december":
		return 12;
	    default:
		return -1;
	}
    }

    public static int getMonthDays(String name) {
          switch(name.toLowerCase()) {
  	    case "january":
  	        return 31;
  	    case "february":
  	        return 28;
  	    case "march":
  	        return 31;
  	    case "april":
  	    	return 30;
  	    case "may":
  	        return 31;
  	    case "june":
  	        return 30;
  	    case "july":
  	        return 31;
  	    case "august":
  	        return 31;
  	    case "september":
  	        return 30;
  	    case "october":
  	        return 31;
  	    case "november":
  	        return 30;
  	    case "december":
  	        return 31;
  	    default:
  	        return -1;
  	}

    }

    public String getName() {
	return name;
    }
}
