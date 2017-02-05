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
    private Poly falling = null;
    private int fallingX;
    private int fallingY;
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
	if(falling != null) {
	    removeFalling();
	    fallingY++;
	    addFalling();
	} else {
	    TetrominoMaker tetrominoMaker = new TetrominoMaker();
	    this.falling = tetrominoMaker.getPoly(rnd.nextInt(tetrominoMaker.getNumberOfTypes()));
	    this.fallingX = (width / 2);
	    this.fallingY = OUTSIDE_FRAME_SIZE; //Block should start falling from inside the frame
	    addFalling();
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
		    if(falling.getPolyShape()[row][col] != SquareType.EMPTY) {
			squares[row + fallingY][col + fallingX] = falling.getPolyShape()[row][col];
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
            if(!hasCollision()) {
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
            if(!hasCollision()) {
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

    public boolean hasCollision() {
        for(int row = 0; row < falling.getHeight(); row++) {
            for(int col = 0; col < falling.getWidth(); col++) {
                if(falling.getPolyShape()[row][col] != SquareType.EMPTY &&
		   squares[fallingY][fallingX] != SquareType.EMPTY) {
		    System.out.println(squares[fallingY][fallingX]);
		    return true;
		}
	    }
	}
	return false;
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
