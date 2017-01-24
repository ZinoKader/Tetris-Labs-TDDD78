package lab3;

import javafx.scene.paint.Color;

public class Text extends AbstractShape {

    private int size;
    private String text;

    public Text(final int x, final int y, final int size, final Color color, final String text) {
	super(x, color, y);
	this.size = size;
	this.text = text;
    }

    @Override public String toString() {
	return "Text{" + "x=" + x + ", y=" + y + ", size=" + size + ", color=" + color + ", text='" + text + '\'' + '}';
    }

    @Override public void draw() {
	System.out.println("Ritar: " + this);
    }

    @Override public int getRadius() {
	return 0;
    }

}
