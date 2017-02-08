package lab5;

import javax.swing.*;
import java.awt.*;

public class ScoreboardComponent extends JComponent {

    private HighscoreList highscoreList = HighscoreList.getInstance();
    private static final int SCORELIST_WIDTH = 300;
    private static final int SCORELIST_HEIGHT = 400;
    private static final int SCORE_PADDING_TOP = 20;
    private static final int CENTER_WIDTH_TEXT = (int)(SCORELIST_WIDTH / 2.8);
    private static final int CENTER_WIDTH_TOOLTIP = (int)(SCORELIST_WIDTH / 11);
    private static final int FONT_SIZE_TITLE = 17;
    private static final int FONT_SIZE_SCORES = 14;

    public ScoreboardComponent() {
    }

    @Override protected void paintComponent(final Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;

	//Tooltip text
	g2d.setFont(new Font("TimesRoman", Font.BOLD, FONT_SIZE_TITLE));
	g2d.drawString("PRESS ANY KEY TO CONTINUE", CENTER_WIDTH_TOOLTIP, SCORELIST_HEIGHT - SCORE_PADDING_TOP);


	//Title text
	g2d.setFont(new Font("TimesRoman", Font.BOLD, FONT_SIZE_TITLE));
	g2d.drawString("Highscores", CENTER_WIDTH_TEXT, SCORE_PADDING_TOP);


	//Score tex
	int newPadding = SCORE_PADDING_TOP * 2;
	g2d.setFont(new Font("TimesRoman", Font.BOLD, FONT_SIZE_SCORES));
	for(Highscore highScore : highscoreList.getHighscorelist()) {
	    g2d.drawString(highScore.getName() + " : " + highScore.getScore(), CENTER_WIDTH_TEXT, newPadding);
	    newPadding += SCORE_PADDING_TOP;
	}

    }

    @Override public Dimension getPreferredSize() {
	return new Dimension(SCORELIST_WIDTH, SCORELIST_HEIGHT);
    }
}
