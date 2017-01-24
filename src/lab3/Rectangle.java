package lab3;

import javafx.scene.paint.Color;

public class Rectangle extends AbstractShape {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Rectangle(final int x, final int y, final int width, final int height, final Color color) {
	super(x, color, y);
	this.width = width;
	this.height = height;
    }

    @Override public String toString() {
	return "Rectangle{" + "x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + ", color=" + color + '}';
    }

    @Override public void draw() {
	System.out.println("Ritar: " + this);
    }

    @Override public int getRadius() {
	return 0;
    }


}
