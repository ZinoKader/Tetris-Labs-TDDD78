package lab5;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;

public class TetrisComponent extends JComponent {

    private Board gameBoard;
    private EnumMap<SquareType,Color> squareColors;

    public TetrisComponent(Board gameBoard, EnumMap<SquareType,Color> squareColors) {
        this.gameBoard = gameBoard;
        this.squareColors = squareColors;
    }

    @Override protected void paintComponent(final Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;

	g2d.setColor(Color.GREEN);
	g2d.drawRect(a, b, getPreferredSize().width / gameBoard.getWidth(), getPreferredSize().height / gameBoard.getHeight());
    }

    @Override public Dimension getPreferredSize() {
	return new Dimension(500, 500);
    }

}
