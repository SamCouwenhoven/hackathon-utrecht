package nl.codeforall.cannabits.teamsweat.gameobjects.playerstates;

import nl.codeforall.cannabits.teamsweat.gameobjects.Words;
import nl.codeforall.cannabits.teamsweat.gameobjects.powerups.PowerUp;
import nl.codeforall.cannabits.teamsweat.gameobjects.traps.Trap;

public abstract class PlayerStatusImpl implements PlayerStatus{
    @Override
    public int getMovementSpeed() {
        return 1;
    }

    @Override
    public void storeWord(Words words) {

    }

    @Override
    public void addPowerUp(PowerUp powerUp) {

    }

    @Override
    public void addTrap(Trap trap) {

    }

    @Override
    public void placeTrap() {

    }

    @Override
    public PlayerStatus nextState() {
        return new Default();
    }
}
