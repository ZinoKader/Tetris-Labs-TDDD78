package lab1;

import javax.swing.*;

public class Exercise2
{
    public static void main(String[] args) {
	int min = Integer.parseInt(JOptionPane.showInputDialog("Enter a min value: "));
	int max = Integer.parseInt(JOptionPane.showInputDialog("Enter a max value: "));
	System.out.println(sumFor(min, max));
	System.out.println(sumWhile(min, max));
    }

    private static int sumFor(int min, int max) {
        int sum = 0;
	for(int i = min; i <= max; i++) {
	    sum += i;
	}
	return sum;
    }

    private static int sumWhile(int min, int max) {
        int sum = 0;
        while(min <= max) {
            sum += min;
            min++;
	}
	return sum;
    }
}
