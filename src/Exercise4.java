import javax.swing.*;

public class Exercise4
{
    public static void main(String[] args) {
	String input = JOptionPane.showInputDialog("Please enter a value: ");
	try {
	    int tabell = Integer.parseInt(input);
	    for(int i = 0; i <= tabell; i++) {
	    	    System.out.println(i + " * " + tabell + " = " + i * tabell);
	    }
	} catch(Exception e) {
	    System.out.println("Please enter a numerical value.");
	}
    }
}
