package lab3;

import javafx.scene.paint.Color;

public interface Shape {

    @Override String toString();

    abstract void draw();

    abstract int getX();

    abstract int getY();

    abstract int getRadius();

    abstract Color getColor();

}
