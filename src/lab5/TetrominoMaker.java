package lab5;

public class TetrominoMaker {

    public TetrominoMaker() {
    }

    public int getNumberOfTypes() {
	return SquareType.values().length - 1; //Vi räknar inte med EMPTY
    }

    public Poly getPoly(int n) {

	if( n < 0 || n > getNumberOfTypes() ) throw new IllegalArgumentException("Invalid index: " + n);

	switch(n) {
	    case 0:
	        return new Poly(createI());
	    case 1:
	        return new Poly(createO());
	    case 2:
	        return new Poly(createT());
	    case 3:
	        return new Poly(createS());
	    case 4:
	        return new Poly(createZ());
	    case 5:
	        return new Poly(createJ());
	    case 6:
	        return new Poly(createL());
	    default:
	        throw new IndexOutOfBoundsException("You can only get polys of index 0 to " + (getNumberOfTypes() - 1));
	}

    }


    private SquareType[][] createI() {
        return new SquareType[][] {
        	new SquareType[] {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY},
		new SquareType[] {SquareType.I, SquareType.I, SquareType.I, SquareType.I},
		new SquareType[] {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY},
		new SquareType[] {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}
	};
    }

    private SquareType[][] createO() {
        return new SquareType[][] {
        	new SquareType[] {SquareType.O, SquareType.O},
		new SquareType[] {SquareType.O, SquareType.O}
	};
    }

    private SquareType[][] createT() {
        return new SquareType[][] {
		new SquareType[] {SquareType.EMPTY, SquareType.T, SquareType.EMPTY},
		new SquareType[] {SquareType.T, SquareType.T, SquareType.T },
		new SquareType[] {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}
	};
    }

    private SquareType[][] createS() {
        return new SquareType[][] {
		new SquareType[] {SquareType.EMPTY, SquareType.S, SquareType.S},
		new SquareType[] {SquareType.S, SquareType.S, SquareType.EMPTY},
		new SquareType[] {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}
	};
    }

    private SquareType[][] createZ() {
        return new SquareType[][] {
		new SquareType[] {SquareType.Z, SquareType.Z, SquareType.EMPTY},
		new SquareType[] {SquareType.EMPTY, SquareType.Z, SquareType.Z},
		new SquareType[] {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}
	};
    }

    private SquareType[][] createJ() {
        return new SquareType[][] {
		new SquareType[] {SquareType.J, SquareType.EMPTY, SquareType.EMPTY},
		new SquareType[] {SquareType.J, SquareType.J, SquareType.J},
		new SquareType[] {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}
	};
    }

    private SquareType[][] createL() {
        return new SquareType[][] {
		new SquareType[] {SquareType.EMPTY, SquareType.EMPTY, SquareType.L},
		new SquareType[] {SquareType.L, SquareType.L, SquareType.L},
		new SquareType[] {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}
	};
    }

}
