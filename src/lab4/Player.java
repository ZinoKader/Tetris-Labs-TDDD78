package lab4;


public class Player {


    private int x, y;
    private Speed speed = Speed.SPEED_MEDIUM;
    private Mode mode = Mode.MODE_NORMAL;

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(final Speed speed) {
        this.speed = speed;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(final Mode mode) {
        this.mode = mode;
    }

    public void moveRight() {
        switch (speed) {
	    case SPEED_SLOW:
                x += 5;
                break;
            case SPEED_MEDIUM:
                x += 10;
                break;
            case SPEED_FAST:
                x += 20;
                break;
        }
    }

    /**
     * Describe current speed and mode -- used for a status display
     */
    public String getDescription() {
        return "Player is " + getSpeed() + " and " + getMode();
    }

    public static void main(String[] args) {
        final Player player = new Player();
        System.out.println(player.getDescription());
    }

}
