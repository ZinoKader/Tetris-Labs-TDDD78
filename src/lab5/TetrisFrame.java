package lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumMap;

public class TetrisFrame extends JFrame {


    public TetrisFrame(Board board) {
	super("Zetris");
	createMenu();

	TetrisComponent gameComponent = new TetrisComponent(board, getDefaultSquareColors());
	board.addBoardListener(gameComponent);

	this.setLayout(new BorderLayout());
	this.add(gameComponent, BorderLayout.CENTER);
	this.pack();
	this.setVisible(true);


	final Action doOneStep = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
		board.tick();
	    }
	};

	class LeftKeyAction extends AbstractAction {
          @Override public void actionPerformed(final ActionEvent e) {
              board.moveLeft();
          }
   	}

   	class RightKeyAction extends AbstractAction {
          @Override public void actionPerformed(final ActionEvent e) {
              board.moveRight();
          }
   	}


	final InputMap in = gameComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
      	in.put(KeyStroke.getKeyStroke("LEFT"), "moveleft");
	in.put(KeyStroke.getKeyStroke("RIGHT"), "moveright");
      	final ActionMap act = gameComponent.getActionMap();
      	act.put("moveleft", new LeftKeyAction());
	act.put("moveright", new RightKeyAction());

	final Timer clockTimer = new Timer(500, doOneStep);
	clockTimer.setCoalesce(true);
    	clockTimer.start();

    }

    private EnumMap<SquareType, Color> getDefaultSquareColors() {
        EnumMap<SquareType, Color> squareColors = new EnumMap<>(SquareType.class);
        squareColors.put(SquareType.OUTSIDE, Color.black);
        squareColors.put(SquareType.EMPTY, Color.WHITE);
        squareColors.put(SquareType.S, new Color(56, 200, 36));
        squareColors.put(SquareType.I, new Color(122, 188, 200));
        squareColors.put(SquareType.J, new Color(200, 163, 49));
        squareColors.put(SquareType.L, new Color(0, 45, 200));
        squareColors.put(SquareType.O, new Color(194, 200, 67));
        squareColors.put(SquareType.T, new Color(132, 15, 200));
        squareColors.put(SquareType.Z, new Color(200, 44, 40));
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
	    if(JOptionPane.showConfirmDialog(null, "Do you really want to quit?",
					      "Quit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)  {
	        System.exit(0);
	    }
	}
    }



}
