import javax.swing.*;

public class Excercise4 {
    public static void main(String[] args) {
	String input = JOptionPane.showInputDialog("Please enter a value: ");
	try {
	    int tabell = Integer.parseInt(input);

	} catch(Exception e) {
	    System.out.println("Please enter a numerical value.");
	}
    }
}
