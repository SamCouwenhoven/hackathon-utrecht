package nl.codeforall.cannabits.teamsweat.gameobjects.playerstates;

import nl.codeforall.cannabits.teamsweat.gameobjects.Words;
import nl.codeforall.cannabits.teamsweat.gameobjects.powerups.PowerUp;
import nl.codeforall.cannabits.teamsweat.gameobjects.traps.Trap;

public class Frozen extends PlayerStatusImpl {

    @Override
    public int getMovementSpeed() {
        return 0;
    }

    @Override
    public void storeWord(Words words) {
        //can't store words
    }

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
