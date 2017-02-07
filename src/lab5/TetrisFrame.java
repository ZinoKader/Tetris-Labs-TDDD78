package lab5;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.util.EnumMap;

public class TetrisFrame extends JFrame {

    private TetrisComponent gameComponent;
    private ScoreboardComponent scoreboardComponent;
    private Timer clockTimer;
    private KeyListener restartGameListener;
    private InputMap in;
    private ActionMap act;
    private Board board;
    private HighscoreList highscoreList = HighscoreList.getInstance();


    public TetrisFrame(Board board) {
	super("Zetris");
	createMenu();

	this.board = board;
	gameComponent = new TetrisComponent(board, getDefaultSquareColors());
	scoreboardComponent = new ScoreboardComponent();
	board.addBoardListener(gameComponent);
	this.setLayout(new BorderLayout());
	this.add(gameComponent, BorderLayout.CENTER);
	this.pack();
	this.setVisible(true);

	bindKeys();
	startTimer();
	startMusic();

	restartGameListener = new KeyListener() {
	    @Override public void keyTyped(final KeyEvent e) {

	    }

	    @Override public void keyPressed(final KeyEvent e) {
		startNewGame();
	    }

	    @Override public void keyReleased(final KeyEvent e) {

	    }
	};
    }

    private void startNewGame() {
	this.remove(scoreboardComponent);
	this.add(gameComponent, BorderLayout.CENTER);
	this.pack();
	this.setVisible(true);
	this.repaint();
	board.clearBoard();
	board.removeAllListeners();
	board.addBoardListener(gameComponent);
	startTimer();
    }

    private void startMusic() {
	URL url = getClass().getResource("Tetris.wav");
	try {
	    Clip clip = AudioSystem.getClip();
	    AudioInputStream ais = AudioSystem.getAudioInputStream(url);
	    clip.open(ais);
	    clip.loop(Clip.LOOP_CONTINUOUSLY);
	} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
	    System.out.println("Something went wrong when trying to play the background music.");
	    e.printStackTrace();
	}
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

    private void startTimer() {
	final Action doOneStep = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	        if(!board.isGameOver()) {
	            stopListenForNewGame();
		    board.tick();
		} else {
		    System.out.println("GAME OVER!");
	            clockTimer.stop();
		    showHighscoreList();
		    listenForNewGame();
		}
	    }
	};


	clockTimer = new Timer(200, doOneStep);
	clockTimer.setCoalesce(true);
    	clockTimer.start();
    }

    private void showHighscoreList() {
	String playerName = "";
	while (playerName.isEmpty()) {
	    playerName = JOptionPane.showInputDialog("Enter your name: ");
	}

	highscoreList.addHighscore(new Highscore(playerName, board.getScore()));
	this.remove(gameComponent);
	this.add(scoreboardComponent, BorderLayout.CENTER);
	this.pack();
	this.setVisible(true);
	this.repaint();
    }

    private void listenForNewGame() {
	this.addKeyListener(restartGameListener);
    }

    private void stopListenForNewGame() {
        this.removeKeyListener(restartGameListener);
    }


    private class LeftKeyAction extends AbstractAction {
	@Override public void actionPerformed(final ActionEvent e) {
	    board.moveLeft();
	}
    }

    private class RightKeyAction extends AbstractAction {
	@Override public void actionPerformed(final ActionEvent e) {
	    board.moveRight();
	}
    }

    private class UpKeyAction extends AbstractAction {
	@Override public void actionPerformed(final ActionEvent e) {
	    board.rotate(true);
	}
    }

    private class EscapeKeyAction extends AbstractAction {
	@Override public void actionPerformed(final ActionEvent e) {
	    System.exit(0);
	}
    }

    private void bindKeys() {
	in = gameComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	act = gameComponent.getActionMap();
	in.put(KeyStroke.getKeyStroke("UP"), "up");
	in.put(KeyStroke.getKeyStroke("LEFT"), "left");
	in.put(KeyStroke.getKeyStroke("RIGHT"), "right");
	in.put(KeyStroke.getKeyStroke("ESCAPE"), "escape");
	act.put("up", new UpKeyAction());
	act.put("left", new LeftKeyAction());
	act.put("right", new RightKeyAction());
	act.put("escape", new EscapeKeyAction());
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

    private class QuitListener implements ActionListener {
	@Override public void actionPerformed(final ActionEvent e) {
	    if(JOptionPane.showConfirmDialog(null, "Do you really want to quit?",
					      "Quit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)  {
	        System.exit(0);
	    }
	}
    }



}
