package lab5;


public class Poly {

    private SquareType[][] polyShape;

    public Poly(SquareType[][] polyShape) {
	this.polyShape = polyShape;
    }

    public SquareType[][] getPoly() {
	return polyShape;
    }

    public int getWidth() { return this.polyShape.length; }

    public int getHeight() { return this.polyShape[0].length; }
}
