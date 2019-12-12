package nl.codeforall.cannabits.teamsweat.gameobjects.powerups;

import nl.codeforall.cannabits.teamsweat.gameobjects.GameObject;
import nl.codeforall.cannabits.teamsweat.gameobjects.Pickable;
import nl.codeforall.cannabits.teamsweat.gameobjects.Player;
import nl.codeforall.cannabits.teamsweat.gameobjects.Useable;

public abstract class PowerUp extends GameObject implements Pickable, Useable {
    private Player player;
    @Override
    public void pickedUp(Player player) {
        //add to player
        this.player = player;
        player.addPowerUp(this);
    }

    @Override
    public void use() {
        //remove from inventory
        player.removePowerUp();
    }


}
