package lab3;

import java.awt.*;

public class Rectangle extends AbstractShape {

    private int width;
    private int height;

    public Rectangle(final int x, final int y, final int width, final int height, final Color color) {
	super(x, color, y);
	this.width = width;
	this.height = height;
    }

    @Override public String toString() {
	return "Rectangle{" + "x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + ", color=" + color + '}';
    }

    @Override public void draw(final Graphics g) {
	g.setColor(color);
 	g.drawRect(getX(), getY(), width, height);
    }

    @Override public int getRadius() {
	return 0;
    }


}
