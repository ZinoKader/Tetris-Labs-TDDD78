package lab4;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player = new Player();
    private List<Powerup> activePowerups = new ArrayList<>();

    public void playerHitPowerup(Powerup power) {
        activePowerups.add(power);
	power.playerHitMe(player);
    }

}
