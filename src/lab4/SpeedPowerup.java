package lab4;

import java.awt.*;

public class SpeedPowerup implements Powerup {
    @Override public String getDescription() {
        return "Makes a player faster";
    }

    public void paint(Graphics g, int x, int y) {
        g.fillRect(x, y, 10, 10);
    }

    @Override public void playerHitMe(final Player player) {
	player.setSpeed(Speed.SPEED_FAST);
    }
}
