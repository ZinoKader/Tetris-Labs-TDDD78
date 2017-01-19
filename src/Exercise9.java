import javax.swing.*;

public class Exercise9 {
    public static void main(String[] args) {
	String input = JOptionPane.showInputDialog("Enter a number: ");
	System.out.println("Roten ur " + input + " är " + findRoot(Double.parseDouble(input)));
    }

    public static double findRoot(double number) {
        double x = number;
        for(int i = 0; i < 10; i++) {
	    x = x - (x * x - number) / (2 * x);
	}
	return x;
    }
}
