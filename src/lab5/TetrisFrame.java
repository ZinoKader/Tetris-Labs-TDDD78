package lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumMap;

public class TetrisFrame extends JFrame{

    public TetrisFrame(Board board) {
	super("Zetris");
	createMenu();

	TetrisComponent gameComponent = new TetrisComponent(board, getDefaultSquareColors());

	this.setLayout(new BorderLayout());
	this.add(gameComponent, BorderLayout.CENTER);
	this.pack();
	this.setVisible(true);

	final Action doOneStep = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
		board.randomizeBoard();
		gameComponent.repaint();
	    }
	};

	final Timer clockTimer = new Timer(500, doOneStep);
	clockTimer.setCoalesce(true);
    	clockTimer.start();

    }

    private EnumMap<SquareType, Color> getDefaultSquareColors() {
        EnumMap<SquareType, Color> squareColors = new EnumMap<>(SquareType.class);
        squareColors.put(SquareType.S, Color.gray);
        squareColors.put(SquareType.I, Color.blue);
        squareColors.put(SquareType.J, Color.green);
        squareColors.put(SquareType.L, Color.black);
        squareColors.put(SquareType.O, Color.magenta);
        squareColors.put(SquareType.T, Color.red);
        squareColors.put(SquareType.Z, Color.gray);
        return squareColors;
    }

    private void createMenu() {
	final JMenuBar bar = new JMenuBar();
	final JMenu menu = new JMenu("Options");
	JMenuItem quit = new JMenuItem("Quit");
	quit.addActionListener(new QuitListener());
	menu.add(quit);
	bar.add(menu);
	this.setJMenuBar(bar);
    }

    private class QuitListener implements ActionListener {
	@Override public void actionPerformed(final ActionEvent e) {
	    if(JOptionPane.showConfirmDialog(null, "Do you really quit?",
					      "Quit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)  {
	        System.exit(0);
	    }
	}
    }


}
