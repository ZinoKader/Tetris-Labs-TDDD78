package lab3;

import java.awt.*;

public interface Shape {

    @Override String toString();

    abstract void draw(final Graphics g);

    abstract int getX();

    abstract int getY();

    abstract int getRadius();

    abstract java.awt.Color getColor();

}
