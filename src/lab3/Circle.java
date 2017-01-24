package lab3;

import java.awt.*;

public class Circle extends AbstractShape {

    private int radius;

    public Circle(int x, int y, int radius, Color color) {
	super(x, color, y);

	if(radius < 0) {
            throw new IllegalArgumentException("Radius must be positive");
	}

	this.radius = radius;
    }

    @Override public int getRadius() {
	return radius;
    }

    @Override public String toString() {
	return "Circle{" + "x=" + getX() + ", y=" + getY() + ", radius=" + radius + ", color=" + getColor() + '}';
    }

    @Override public void draw(final Graphics g) {
	g.setColor(getColor());
 	g.drawOval(x, y, getRadius() * 2, getRadius() * 2); // calculated from radius!
    }
}
