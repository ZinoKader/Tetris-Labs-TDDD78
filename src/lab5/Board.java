package lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Board {

    private ArrayList<BoardListener> boardListeners;
    private int width;
    private int height;
    private SquareType[][] squares;
    private Random rnd;
    private TetrominoMaker tetrominoMaker;
    private Poly falling;
    private int fallingX;
    private int fallingY;

    private boolean isGameOver;
    private static final int OUTSIDE_FRAME_SIZE = 2;


    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.falling = null;
        this.isGameOver = false;

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

    public void tick() {
	//System.out.println(isRowCompleted(height - 1));
	removeCompletedRows();
	if(isGameOver) {
	    System.out.println("GAME OVER!");
	    return;
	}
	else if(this.falling == null) {
	    this.falling = tetrominoMaker.getPoly(rnd.nextInt(tetrominoMaker.getNumberOfTypes()));
	    if(falling != null) { //Sometimes gets NPEs otherwise. No idea why.
		if(falling.getWidth() == 2) { //account for O-blocks unique size
		    this.fallingX = (width / 2) - 1;
		} else {
		    this.fallingX = (width / 2) - 2;
		}
		this.fallingY = 0; //Block should start falling from inside the frame
		if (hasCollision()) {
		    this.falling = null;
		    this.isGameOver = true;
		}
	    }
	} else {
	    fallDown();
	}
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

    public void removeCompletedRows() {
        for(int row = 0; row < height; row++) {
	    if(!Arrays.asList(getRow(row)).contains(SquareType.EMPTY)) {
	        for(int col = 0; col < width; col++) {
		    squares[row + OUTSIDE_FRAME_SIZE][col + OUTSIDE_FRAME_SIZE] = SquareType.EMPTY;
		}
		moveDownRemainingRows(row);
	    }
	}
	notifyListeners();
    }

    public void moveDownRemainingRows(int removefrom) {
	for(int row = removefrom - 1; 0 <= row; row--) {
	    for(int col = 0; col < width; col++) {
		squares[row + OUTSIDE_FRAME_SIZE + 1][col + OUTSIDE_FRAME_SIZE] = getSquare(col, row);
	    }
	}
	notifyListeners();
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

    public boolean hasCollision() {
	for(int row = 0; row < falling.getHeight(); row++){
	    for(int col = 0; col < falling.getWidth(); col++){
		if (getSquare(fallingX + col, fallingY + row) != SquareType.EMPTY &&
		    falling.getPoly()[row][col] != SquareType.EMPTY) {
		    return true;
		}
	    }
	}
	return false;
    }

    public boolean isGameOver() {
	return isGameOver;
    }

    public void addBoardListener(BoardListener boardListener) {
	boardListeners.add(boardListener);
    }

    private void notifyListeners() {
        for(BoardListener boardListener: boardListeners) {
            boardListener.boardChanged();
	}
    }
}
