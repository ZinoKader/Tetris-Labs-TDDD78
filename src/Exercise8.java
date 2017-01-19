import javax.swing.*;

public class Exercise8 {

    public static void main(String[] args) {
	while(true) {
	    // Does not evaluate all statements, if the first one is
	    // false, then it won't ask "really?"
	    // This is consequentially more proper for our use case
	    if (askUser("Quit?") && askUser("Really?")) {
	        System.out.println("Quitting...");
	        return;
	    }
	    // Evaluates both statements, if you input something else
	    // other than "Quit?", it'll still ask you "Really?"
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
