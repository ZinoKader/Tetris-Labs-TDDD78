package lab5;

import java.util.Random;

public final class BoardTest {

    private static final int BOARD_WIDTH = 12;
    private static final int BOARD_HEIGHT = 16;

    public static void main(String[] args) {

	TetrisFrame gameFrame;
	Board testBoard = new Board(BOARD_WIDTH, BOARD_HEIGHT);
	Random rnd = new Random();
	TetrominoMaker tetrominoMaker = new TetrominoMaker();

	/*
	testBoard.randomizeBoard();
	testBoard.setFalling(tetrominoMaker.getPoly(rnd.nextInt(tetrominoMaker.getNumberOfTypes())));
	testBoard.setFallingX(0);
	testBoard.setFallingY(0);
	testBoard.addFalling();
	*/


	gameFrame = new TetrisFrame(testBoard);


    }

}
