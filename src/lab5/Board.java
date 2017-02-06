package lab5;

import java.util.ArrayList;
import java.util.Random;

public class Board {

    private ArrayList<BoardListener> boardListeners;
    private int width;
    private int height;
    private SquareType[][] squares;
    private Random rnd;
    private Poly falling = null;
    private int fallingX;
    private int fallingY;
    private boolean isGameOver = false;
    private static final int OUTSIDE_FRAME_SIZE = 2;


    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        boardListeners = new ArrayList<>();
	squares = new SquareType[height + (OUTSIDE_FRAME_SIZE * 2)][width + (OUTSIDE_FRAME_SIZE * 2)];
	rnd = new Random();

	for(int row = 0; row < height + (OUTSIDE_FRAME_SIZE * 2); row++) {
	    for(int col = 0; col < width + (OUTSIDE_FRAME_SIZE * 2); col++) {
	        if(row < 2 || col < 2 || row > height + 1 || col > width + 1) {
		    squares[row][col] = SquareType.OUTSIDE;
		} else {
		    squares[row][col] = SquareType.EMPTY;
		}
	    }
	}
    }

    public void tick() {
	System.out.println(isGameOver);
	if(isGameOver) {
            return;
	}
	if(falling != null) {
	    if(getFallingBottomY() > height || fallingWillReachBottom()) {
		this.falling = null;
	    } else {
		removeFalling();
		fallingY++;
		addFalling();
	    }
	} else {
	    TetrominoMaker tetrominoMaker = new TetrominoMaker();
	    this.falling = tetrominoMaker.getPoly(rnd.nextInt(tetrominoMaker.getNumberOfTypes()));
	    this.fallingX = width / 2;
	    this.fallingY = OUTSIDE_FRAME_SIZE; //Block should start falling from inside the frame
	    addFalling();
	    //if(fallingHasCollision()) { isGameOver = true; }
	}
	notifyListeners();
    }

    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }

    public SquareType getSquareType(int x, int y) {
	return squares[y + 2][x + 2];
    }

    public void addFalling() {
	if(falling != null) {
	    for(int row = 0; row < falling.getHeight(); row++) {
	        for(int col = 0; col < falling.getWidth(); col++) {
		    if(falling.getPoly()[row][col] != SquareType.EMPTY) {
			squares[row + fallingY][col + fallingX] = falling.getPoly()[row][col];
		    }
		}
	    }
	    notifyListeners();
	}
    }

    public void removeFalling() {
	if(falling != null) {
	    for(int row = 0; row < falling.getHeight(); row++) {
	        for(int col = 0; col < falling.getWidth(); col++) {
		    squares[row + fallingY][col + fallingX] = SquareType.EMPTY;
		}
	    }
	    notifyListeners();
	}
    }

    public void moveLeft() {
	if(falling != null) {
	    fallingX--;
            if(!fallingHasCollision()) {
                fallingX++;
     		removeFalling();
		fallingX--;
	     	addFalling();
	    } else {
                fallingX++;
	    }
	    notifyListeners();
	}
    }

    public void moveRight() {
	if(falling != null) {
	    fallingX += falling.getWidth();
            if(!fallingHasCollision()) {
                fallingX -= falling.getWidth(); //We want our current falling pos to be removed
     		removeFalling();
		fallingX++; //Add back to the new falling pos so we can create our block at it
	     	addFalling();
	    } else {
                fallingX -= falling.getWidth();
	    }
	    notifyListeners();
	}
    }

    public boolean fallingHasCollision() {
        for(int row = 0; row < falling.getHeight(); row++) {
            for(int col = 0; col < falling.getWidth(); col++) {
                if(falling.getPoly()[row][col] != SquareType.EMPTY &&
		   squares[fallingY][fallingX] != SquareType.EMPTY) {
		    return true;
		}
	    }
	}
	return false;
    }

    public boolean fallingWillReachBottom() {
	for(int row = 0; row < falling.getHeight(); row++) {
	    for(int col = 0; col < falling.getWidth(); col++) {
	        if(falling.getPoly()[row][col] != SquareType.EMPTY) {
		    if (squares[fallingY + getFallingBottomY() + 1][fallingX + col] != SquareType.EMPTY) {
			return true;
		    }
		}
	    }
	}
	return false;
    }

    /**
     * We go through the falling block from the bottom to the top.
     * As soon as a row that contains a non-empty block is found, we return it.
     */
    public int getFallingBottomY() {
	int bottomY = falling.getHeight();
	for(int row = falling.getHeight() - 1; row >= 0; row--) {
	    for(int col = 0; col < falling.getWidth(); col++) {
		if(falling.getPoly()[row][col] != SquareType.EMPTY){
		    bottomY = row;
		    return bottomY;
		}
	    }
	}
	return bottomY;
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
