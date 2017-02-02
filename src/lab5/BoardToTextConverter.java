package lab5;

public final class BoardToTextConverter {

    public static String convertToText(Board board) {

        StringBuilder boardSB = new StringBuilder();

	for(int row = 0; row < board.getHeight(); row++) {
	    for(int col = 0; col < board.getWidth(); col++) {


		SquareType square = board.getSquareType(col, row);


	        switch(square) {
		    case EMPTY:
		        boardSB.append("-");
			break;
		    case I:
		        boardSB.append("I");
			break;
		    case O:
		        boardSB.append("O");
			break;
		    case T:
		        boardSB.append("T");
			break;
		    case S:
			boardSB.append("S");
			break;
		    case Z:
			boardSB.append("Z");
			break;
		    case J:
			boardSB.append("J");
			break;
		    case L:
			boardSB.append("L");
			break;
		}

	    }
	    boardSB.append("\n"); //ny rad för varje iteration av en rad
	}

	return boardSB.toString();

    }

}
