package lab5;

import javax.swing.*;
import java.awt.*;

public class ScoreboardComponent extends JComponent {

    private HighscoreList highscoreList = HighscoreList.getInstance();
    private static final int SCORELIST_WIDTH = 300;
    private static final int SCORELIST_HEIGHT = 400;
    private static final int SCORE_PADDING_TOP = 20;
    private static final int CENTER_WIDTH_TEXT = (int)(SCORELIST_WIDTH / 2.5);

    public ScoreboardComponent() {
    }

    @Override protected void paintComponent(final Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;

	g2d.drawString("Highscores", CENTER_WIDTH_TEXT, SCORE_PADDING_TOP);

	int newPadding = SCORE_PADDING_TOP * 2;

	for(Highscore highScore : highscoreList.getHighscorelist()) {
	    g2d.drawString(highScore.getName() + " : " + highScore.getScore(), CENTER_WIDTH_TEXT, newPadding);
	    newPadding += SCORE_PADDING_TOP;
	}

    }

    @Override public Dimension getPreferredSize() {
	return new Dimension(SCORELIST_WIDTH, SCORELIST_HEIGHT);
    }
}
