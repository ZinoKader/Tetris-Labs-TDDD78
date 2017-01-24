package lab3;

import java.awt.*;

public abstract class AbstractShape implements Shape {

    protected int x;
    protected int y;
    protected Color color;

    public AbstractShape(int x, Color color, int y) {
	this.x = x;
	this.color = color;
	this.y = y;
    }

    @Override public boolean equals(final Object o) {
	if (this == o) return true;
	if (o == null || getClass() != o.getClass()) return false;

	final AbstractShape that = (AbstractShape) o;

	if (x != that.x) return false;
	if (y != that.y) return false;
	if (!color.equals(that.color)) return false;

	return true;
    }

    @Override public int getX() {
	return x;
    }

    @Override public int getY() {
	return y;
    }

    @Override public Color getColor() {
	return color;
    }
}
