package lab5;


import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;

public class TetrisComponent extends JComponent implements BoardListener {

    private static final int PANEL_SIZE = 200;
    private static final int SCORE_FONT_SIZE = 20;
    private static final int SCORE_PADDING_TOP = 30;
    private static final int COLLISION_HANDLER_FONT_SIZE = 15;
    private static final int COLLISION_HANDLER_PADDING_TOP = 60;
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

	        //Handle painting of falling and board blocks
		if(positionIsFalling(col, row)) {
		    g2d.setColor(squareColors.get(gameBoard.getFalling().getPoly()[row - gameBoard.getFallingY()][col - gameBoard.getFallingX()]));
		} else {
		    g2d.setColor(squareColors.get(gameBoard.getSquare(col, row)));
		}

		g2d.fillRect(col * RECTANGLE_WIDTH + BLOCK_OUTLINE_SIZE, row * RECTANGLE_HEIGHT + BLOCK_OUTLINE_SIZE,
			     RECTANGLE_WIDTH - BLOCK_OUTLINE_SIZE, RECTANGLE_HEIGHT - BLOCK_OUTLINE_SIZE);


		//Paint side panel with gradient, magic number 10 here is to paint the remaining bits of the window
		GradientPaint gradient = new GradientPaint(gameBoard.getWidth() * RECTANGLE_WIDTH,
							   gameBoard.getHeight() - RECTANGLE_HEIGHT, Color.orange,
							   gameBoard.getWidth() * RECTANGLE_WIDTH + PANEL_SIZE,
							   gameBoard.getHeight() * RECTANGLE_HEIGHT + 10, Color.gray);
		g2d.setPaint(gradient);
		g2d.fillRect( gameBoard.getWidth() * RECTANGLE_WIDTH, gameBoard.getHeight() - RECTANGLE_HEIGHT,
			      PANEL_SIZE, gameBoard.getHeight() * RECTANGLE_HEIGHT + 10);


		//Paint score text
		g2d.setColor(Color.white);
		g2d.setFont(new Font("Arial", Font.PLAIN, SCORE_FONT_SIZE));
		g2d.drawString("Score: " + Integer.toString(gameBoard.getScore()),
			       gameBoard.getWidth() * RECTANGLE_WIDTH + PANEL_SIZE / 3,  SCORE_PADDING_TOP);

		//Paint collision handler text
		g2d.setColor(Color.white);
		g2d.setFont(new Font("Arial", Font.PLAIN, COLLISION_HANDLER_FONT_SIZE));
		g2d.drawString(gameBoard.getCollisionHandler().getDescription(),
			       gameBoard.getWidth() * RECTANGLE_WIDTH + PANEL_SIZE / 3,  COLLISION_HANDLER_PADDING_TOP);
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
	return new Dimension(gameBoard.getWidth() * RECTANGLE_WIDTH + PANEL_SIZE, gameBoard.getHeight() * RECTANGLE_HEIGHT);
    }

    @Override public void boardChanged() {
	repaint();
    }
}
