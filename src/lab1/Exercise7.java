package lab1;

import javax.swing.*;

public class Exercise7 {

    public static void main(String[] args) {

	int min = Integer.parseInt(JOptionPane.showInputDialog("Enter a min value: "));
	int max = Integer.parseInt(JOptionPane.showInputDialog("Enter a max value: "));
	String iterativemethod = JOptionPane.showInputDialog("How would you like to iterate? 'for' / ' while' ");

	switch(iterativemethod) {
	    case "for":
		System.out.println(sumFor(min, max));
	        break;
	    case "while":
		System.out.println(sumWhile(min, max));
	        break;
	    default:
	        System.out.println("Invalid iterative method. Only for and while is accepted.");
	}

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
