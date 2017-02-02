package lab5;

import java.util.Random;

public final class BoardTest {

    public static void main(String[] args) {

	TetrisFrame gameFrame;
	Board testBoard = new Board(32, 16);
	Random rnd = new Random();
	TetrominoMaker tetrominoMaker = new TetrominoMaker();

	/*
	testBoard.random®izeBoard();
	testBoard.setFalling(tetrominoMaker.getPoly(rnd.nextInt(tetrominoMaker.getNumberOfTypes())));
	testBoard.setFallingX(0);
	testBoard.setFallingY(0);
	testBoard.addFalling();
	*/


	gameFrame = new TetrisFrame(testBoard);


    }

}
