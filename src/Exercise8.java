import javax.swing.*;

public class Exercise8 {

    public static void main(String[] args) {
	while(true) {
	    //
	    if (askUser("Quit?") && askUser("Really?")) {
	        System.out.println("Quitting...");
	        return;
	    }
	    // Evaluates both statements
	    if (askUser("Quit?") & askUser("Really?")) {
		System.out.println("Quitting...");
		return;
	    }
	    System.out.println("OK. I'll keep running then.");
	}
    }

    public static boolean askUser(String question) {
	return JOptionPane.showConfirmDialog(null, question, "",
	JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
}
