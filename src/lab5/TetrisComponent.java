package lab5;


import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;

public class TetrisComponent extends JComponent implements BoardListener {

    private static final int RECTANGLE_WIDTH = 30;
    private static final int RECTANGLE_HEIGHT = 30;
    private static final int BLOCK_OUTLINE_SIZE = 1;

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

		if(positionIsFalling(col, row)){
		    g2d.setColor(squareColors.get(gameBoard.getFalling().getPoly()[row - gameBoard.getFallingY()][col - gameBoard.getFallingX()]));
		} else {
		    g2d.setColor(squareColors.get(gameBoard.getSquare(col, row)));
		}

		g2d.fillRect(col * RECTANGLE_WIDTH + BLOCK_OUTLINE_SIZE, row * RECTANGLE_HEIGHT + BLOCK_OUTLINE_SIZE,
			     RECTANGLE_WIDTH - BLOCK_OUTLINE_SIZE, RECTANGLE_HEIGHT - BLOCK_OUTLINE_SIZE);
	    }
	}

    }
    
    private boolean positionIsFalling(int x, int y){
   	return ((gameBoard.getFalling() != null) &&
		((gameBoard.getFallingX() <= x && (gameBoard.getFallingX() + gameBoard.getFalling().getWidth()) > x) &&
   		(gameBoard.getFallingY() <= y && gameBoard.getFallingY() + gameBoard.getFalling().getHeight() > y) &&
   		(gameBoard.getFalling().getPoly()[y - gameBoard.getFallingY()][x - gameBoard.getFallingX()] != SquareType.EMPTY)));
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
