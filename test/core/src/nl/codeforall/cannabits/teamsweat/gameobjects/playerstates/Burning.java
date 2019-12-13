package nl.codeforall.cannabits.teamsweat.gameobjects.playerstates;

import nl.codeforall.cannabits.teamsweat.gameobjects.Words;
import nl.codeforall.cannabits.teamsweat.gameobjects.powerups.PowerUp;
import nl.codeforall.cannabits.teamsweat.gameobjects.traps.Trap;

public class Burning extends PlayerStatusImpl {
    @Override
    public int getMovementSpeed() {
        return 4;
    }
    //Can store words

    @Override
    public void addPowerUp(PowerUp powerUp) {
        //can't pick up power ups
    }

    @Override
    public void addTrap(Trap trap) {
        //can't pick up traps
    }

    @Override
    public void placeTrap() {
        //can't place traps
    }

}
