package lab5;

public class Fallthrough implements CollisionHandler {

    @Override public boolean hasCollision(Board board) {
	//prevents NPE when tick() can't keep up with key press events (I think?)
	if(board.getFalling() == null) {
	    return false;
	}

	//Control for collision with OUTSIDE type blocks
	for(int row = 0; row < board.getFalling().getHeight(); row++) {
	    for(int col = 0; col < board.getFalling().getWidth(); col++) {
		if(board.getFalling().getPoly()[row][col] != SquareType.EMPTY &&
		   board.getSquare(board.getFallingX() + col, board.getFallingY() + row) == SquareType.OUTSIDE) {
		    return true;
		}
	    }
	}

	//If we didn't collide with any OUTSIDE blocks, proceed to remove everything in our way
	for(int row = 0; row < board.getFalling().getHeight(); row++) {
	    for(int col = 0; col < board.getFalling().getWidth(); col++) {
		if(board.getFalling().getPoly()[row][col] != SquareType.EMPTY &&
		   board.getSquare(board.getFallingX() + col, board.getFallingY() + row) != SquareType.EMPTY) {
		    board.removeSquare(board.getFallingX() + col, board.getFallingY() + row);
		}
	    }
	}

	return false;
    }

    @Override public String getDescription() {
	return "Fallthrough!";
    }
}
