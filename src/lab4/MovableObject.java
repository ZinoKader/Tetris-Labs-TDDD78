package lab4;

/**
 * A movable object on the screen, with current x and y coordinates.
 */
public class MovableObject {

    protected int x, y;

    public MovableObject(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}