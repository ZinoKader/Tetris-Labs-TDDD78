import javax.swing.*;

public class Exercise3
{

    public static void main(String[] args) {
	String input = JOptionPane.showInputDialog("Please enter a value: ");
	int tabell = Integer.parseInt(input);
	for(int i = 0; i <= 5; i++) {
	    System.out.println(i + " * " + tabell + " = " + i * tabell);
	}
    }
}
