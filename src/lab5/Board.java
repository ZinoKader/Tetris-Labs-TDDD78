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


    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        boardListeners = new ArrayList<>();
	squares = new SquareType[height][width];
	rnd = new Random();

	for(int h = 0; h < height; h++) {
	    for(int w = 0; w < width; w++) {
	        squares[h][w] = SquareType.EMPTY;
	    }
	}

    }

    public static void main(String[] args) {
    }

    public void randomizeBoard() {
	for(int h = 0; h < height; h++) {
	    for(int w = 0; w < width; w++) {
	        int squareTypeIndex = rnd.nextInt(SquareType.values().length);
	        squares[h][w] = SquareType.values()[squareTypeIndex];
	    }
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
	return squares[y][x];
    }

    public void setFalling(Poly falling) {
	this.falling = falling;
    }

    public void setFallingX(int fallingX) {
	this.fallingX = fallingX;
    }

    public void setFallingY(int fallingY) {
	this.fallingY = fallingY;
    }

    public void addFalling(){
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

    public void addBoardListener(BoardListener boardListener) {
	boardListeners.add(boardListener);
    }

    private void notifyListeners() {
        for(BoardListener boardListener: boardListeners) {
            boardListener.boardChanged();
	}
    }
}
