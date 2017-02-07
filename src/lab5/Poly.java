package lab5;


public class Poly {

    private SquareType[][] polySquares;

    public Poly(SquareType[][] polySquares) {
	this.polySquares = polySquares;
    }

    public SquareType[][] getPoly() {
	return polySquares;
    }

    public int getWidth() { return this.polySquares.length; }

    public int getHeight() { return this.polySquares[0].length; }

    public Poly rotateRight(){

	int size = this.polySquares.length;

        Poly newPoly = new Poly(new SquareType[size][size]);

        for(int r = 0; r < getHeight(); r++) {
            for(int c = 0; c < getWidth(); c++) {
                newPoly.polySquares[c][size - 1 - r] = this.polySquares[r][c];
            }
        }

        return newPoly;
    }

    public Poly rotateLeft() {

 	int size = this.polySquares.length;

         Poly newPoly = new Poly(new SquareType[size][size]);

         for(int r = 0; r < getHeight(); r++) {
             for(int c = 0; c < getWidth(); c++) {
                 newPoly.polySquares[c][size + 1 + r] = this.polySquares[r][c];
             }
         }

         return newPoly;
     }


}
