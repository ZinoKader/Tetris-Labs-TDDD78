package lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Board {

    private List<BoardListener> boardListeners;
    private int width;
    private int height;
    private SquareType[][] squares;
    private Random rnd;
    private TetrominoMaker tetrominoMaker;
    private Poly falling;
    private int fallingX;
    private int fallingY;

    private int removedRows;
    private int score;
    private boolean gameOver;

    private static final int OUTSIDE_FRAME_SIZE = 2;
    private static final int ROW_SCORE_1 = 100;
    private static final int ROW_SCORE_2 = 300;
    private static final int ROW_SCORE_3 = 500;
    private static final int ROW_SCORE_4 = 800;


    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.falling = null;
        this.gameOver = false;
        this.score = 0;

        boardListeners = new ArrayList<>();
	tetrominoMaker = new TetrominoMaker();
	rnd = new Random();
	squares = new SquareType[height + (OUTSIDE_FRAME_SIZE * 2)][width + (OUTSIDE_FRAME_SIZE * 2)];

	createBoard();
    }

    public void createBoard(){
	for(int row = 0; row < this.height + 2 * OUTSIDE_FRAME_SIZE; row++) {
	    for(int col = 0; col < this.width + 2 * OUTSIDE_FRAME_SIZE; col++) {
		squares[row][col] = SquareType.OUTSIDE;
	    }
	}

	for(int row = OUTSIDE_FRAME_SIZE; row < height + OUTSIDE_FRAME_SIZE; row++) {
	    for(int col = OUTSIDE_FRAME_SIZE; col < width + OUTSIDE_FRAME_SIZE; col++) {
		squares[row][col] = SquareType.EMPTY;
	    }
	}
    }

    public void clearBoard() {
	this.falling = null;
 	this.gameOver = false;
	this.score = 0;
 	this.removedRows = 0;
 	createBoard();
    }

    public void tick() {

        removedRows = 0;

	if(gameOver) {
	    System.out.println("GAME OVER!");
	    return;
	}
	else if(this.falling == null) {
	    this.falling = tetrominoMaker.getPoly(rnd.nextInt(tetrominoMaker.getNumberOfTypes()));
	    if(falling != null) { //Sometimes gets NPEs otherwise, no idea why ¯\_(ツ)_/¯
		this.fallingX = (width / 2) - 1;
		this.fallingY = 0; //Block should start falling from inside the frame
		if (hasCollision()) {
		    this.falling = null;
		    this.gameOver = true;
		}
	    }
	} else {
	    fallDown();
	}

	removeCompletedRows();
	addScore();

	notifyListeners();
    }

    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }

    public Poly getFalling() {
	return falling;
    }

    public int getFallingX() {
	return fallingX;
    }

    public int getFallingY() {
	return fallingY;
    }

    private SquareType[] getRow(int row) {
        SquareType[] controlRow = new SquareType[width];
	for(int col = 0; col < width; col++) {
	    controlRow[col] = getSquare(col, row);
	}
	return controlRow;
    }

    private void removeCompletedRows() {
        for(int row = 0; row < height; row++) {
	    if(!Arrays.asList(getRow(row)).contains(SquareType.EMPTY)) {
	        for(int col = 0; col < width; col++) {
		    squares[row + OUTSIDE_FRAME_SIZE][col + OUTSIDE_FRAME_SIZE] = SquareType.EMPTY;
		}
		removedRows++;
		moveDownRemainingRows(row);
	    }
	}
	notifyListeners();
    }

    private void moveDownRemainingRows(int removefrom) {
	for(int row = removefrom - 1; 0 <= row; row--) {
	    for(int col = 0; col < width; col++) {
		squares[row + OUTSIDE_FRAME_SIZE + 1][col + OUTSIDE_FRAME_SIZE] = getSquare(col, row);
	    }
	}
	notifyListeners();
    }

    private void addScore() {
	switch(removedRows) {
	    case 1:
	        score += ROW_SCORE_1;
	        break;
	    case 2:
		score += ROW_SCORE_2;
		break;
	    case 3:
		score += ROW_SCORE_3;
		break;
	    case 4:
		score += ROW_SCORE_4;
		break;
	}
    }

    public int getScore() {
        return score;
    }

    public SquareType getSquare(int x, int y) {
	return squares[y + OUTSIDE_FRAME_SIZE][x + OUTSIDE_FRAME_SIZE];
    }

    public void fallDown(){
  	fallingY++;
  	if(hasCollision()) {
  	    fallingY--;
  	    addFalling();
  	}
  	notifyListeners();
    }

    public void addFalling(){
	for(int row = 0; row < falling.getHeight(); row++) {
	    for(int col = 0; col < falling.getWidth(); col++) {
		if(falling.getPoly()[row][col] != SquareType.EMPTY) {
		    squares[fallingY + row + OUTSIDE_FRAME_SIZE][fallingX + col + OUTSIDE_FRAME_SIZE] = falling.getPoly()[row][col];
		}
	    }
	}
	falling = null;
    }

    public void rotate(boolean b) {
        if(falling != null) {
            Poly oldFalling;
            if(b) {
                oldFalling = falling;
                falling = falling.rotateRight();
                if(hasCollision()) {
                    falling = oldFalling;
		}
	    } else {
		oldFalling = falling;
		falling = falling.rotateLeft();
		if(hasCollision()) {
		    falling = oldFalling;
		}
	    }
	}
    }

    public void moveLeft() {
	fallingX--;
	if(hasCollision()) {
	    fallingX++;
	}
	notifyListeners();
    }

    public void moveRight() {
	fallingX++;
	if(hasCollision()) {
	    fallingX--;
	}
	notifyListeners();
    }

    public void moveDown() {
        fallingY++;
        if(hasCollision()) {
            fallingY--;
	}
	notifyListeners();
    }

    public boolean hasCollision() {
	for(int row = 0; row < falling.getHeight(); row++) {
	    for(int col = 0; col < falling.getWidth(); col++) {
		if(falling.getPoly()[row][col] != SquareType.EMPTY && getSquare(fallingX + col, fallingY + row) != SquareType.EMPTY) {
		    return true;
		}
	    }
	}
	return false;
    }

    public boolean isGameOver() {
	return gameOver;
    }

    public void addBoardListener(BoardListener boardListener) {
	boardListeners.add(boardListener);
    }

    public void removeAllListeners() {
        boardListeners = new ArrayList<>();
    }

    private void notifyListeners() {
        for(BoardListener boardListener: boardListeners) {
            boardListener.boardChanged();
	}
    }
}
