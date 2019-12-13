package nl.codeforall.cannabits.teamsweat.gameobjects.playerstates;

import nl.codeforall.cannabits.teamsweat.gameobjects.Words;
import nl.codeforall.cannabits.teamsweat.gameobjects.powerups.PowerUp;
import nl.codeforall.cannabits.teamsweat.gameobjects.traps.Trap;

public class Default extends PlayerStatusImpl {
    @Override
    public int getMovementSpeed() {
        return 1;
    }

}
