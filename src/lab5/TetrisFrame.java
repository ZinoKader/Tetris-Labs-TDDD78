package lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TetrisFrame extends JFrame{

    public TetrisFrame(Board board) {
	super("Zetris");


	JTextArea gameArea = new JTextArea();
	gameArea.setRows(board.getHeight());
	gameArea.setColumns(board.getWidth());
	gameArea.setFont(new Font("Monospaced", Font.PLAIN,20));

	this.setLayout(new BorderLayout());
	this.add(gameArea, BorderLayout.CENTER);
	this.pack();
	this.setVisible(true);

	final Action doOneStep = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
		board.randomizeBoard();
		gameArea.setText(BoardToTextConverter.convertToText(board));
	    }
	};

	final Timer clockTimer = new Timer(500, doOneStep);
	clockTimer.setCoalesce(true);
    	clockTimer.start();

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
