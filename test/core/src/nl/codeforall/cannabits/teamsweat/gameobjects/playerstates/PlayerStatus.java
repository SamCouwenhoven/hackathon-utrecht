package nl.codeforall.cannabits.teamsweat.gameobjects.playerstates;

import nl.codeforall.cannabits.teamsweat.gameobjects.Words;
import nl.codeforall.cannabits.teamsweat.gameobjects.powerups.PowerUp;
import nl.codeforall.cannabits.teamsweat.gameobjects.traps.Trap;

public interface PlayerStatus {
    public int getMovementSpeed();

    public void storeWord(Words words);

    public void addPowerUp(PowerUp powerUp);

    public void addTrap(Trap trap);

    public void placeTrap();

    public PlayerStatus nextState();

}
