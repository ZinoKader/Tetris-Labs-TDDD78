package lab5;

import java.util.ArrayList;
import java.util.List;

public class Heavy implements CollisionHandler {

    @Override public boolean hasCollision(Board board) {
	//prevents NPE when tick() can't keep up with key press events (I think?)
	if(board.getFalling() == null) {
	    return false;
	}

        boolean canCollide = false;
	List<Integer> collapseFrom = new ArrayList<>();
        List<Integer> collapsibleColumns = new ArrayList<>();

	for(int row = 0; row < board.getFalling().getHeight(); row++) {
	    for(int col = 0; col < board.getFalling().getWidth(); col++) {
		if(board.getFalling().getPoly()[row][col] != SquareType.EMPTY &&
		   board.getSquare(board.getFallingX() + col, board.getFallingY() + row) != SquareType.EMPTY) {

		    if(board.isRowCollapisble(board.getFallingX() + col, board.getFallingY() + row)) {
			collapseFrom.add(board.getFallingY() + row + 1);
			collapsibleColumns.add(board.getFallingX() + col);
		    } else {
		        canCollide = true;
		    }

		}
	    }
	}

	if(canCollide) {
	    return true;
	} else {
	    for(int i = 0; i < collapsibleColumns.size(); i++) {
	        board.collapseRow(collapsibleColumns.get(i), collapseFrom.get(i));
	    }
	    return false;
	}

    }

    @Override public String getDescription() {
	return "Heavy!";
    }
}
