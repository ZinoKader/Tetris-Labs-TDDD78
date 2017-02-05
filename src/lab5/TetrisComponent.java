package lab5;


import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;

public class TetrisComponent extends JComponent implements BoardListener {

    private static final int RECTANGLE_WIDTH = 24;
    private static final int RECTANGLE_HEIGHT = 24;

    private Board gameBoard;
    private EnumMap<SquareType,Color> squareColors;

    public TetrisComponent(Board gameBoard, EnumMap<SquareType,Color> squareColors) {
        this.gameBoard = gameBoard;
        this.squareColors = squareColors;
    }

    @Override protected void paintComponent(final Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;

	for(int row = 0; row < gameBoard.getHeight(); row++) {
	    for(int col = 0; col < gameBoard.getWidth(); col++) {

		SquareType square = gameBoard.getSquareType(col, row);
		g2d.setColor(squareColors.get(square));
		g2d.fillRect(col * RECTANGLE_WIDTH, row * RECTANGLE_HEIGHT,  RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
	    }
	}

    }

    /**
     * Fönstrets storlek bestäms utifrån blockstorlek
     *
     */
    @Override public Dimension getPreferredSize() {
	return new Dimension(gameBoard.getWidth() * RECTANGLE_WIDTH, gameBoard.getHeight() * RECTANGLE_HEIGHT);
    }

    @Override public void boardChanged() {
	repaint();
    }
}
