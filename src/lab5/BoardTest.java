package lab5;


public final class BoardTest {

    private static final int BOARD_WIDTH = 12;
    private static final int BOARD_HEIGHT = 12;

    public static void main(String[] args) {
	Board testBoard = new Board(BOARD_WIDTH, BOARD_HEIGHT);
	new TetrisFrame(testBoard);
    }

}
