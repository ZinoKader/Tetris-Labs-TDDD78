package lab3;

import java.awt.*;

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

    @Override public void draw(final Graphics g) {
	g.setColor(getColor());
 	g.setFont(new Font("serif", Font.PLAIN, size));
 	g.drawString(text, getX(), getY());
    }

    @Override public int getRadius() {
	return 0;
    }

}
