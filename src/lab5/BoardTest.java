package lab5;


import javax.swing.*;

public final class BoardTest {

    private static final int BOARD_WIDTH = 11;
    private static final int BOARD_HEIGHT = 22;

    private BoardTest() {}

    public static void main(String[] args) {
	Board testBoard = new Board(BOARD_WIDTH, BOARD_HEIGHT);
	JFrame gameFrame = new TetrisFrame(testBoard);
    }

}
