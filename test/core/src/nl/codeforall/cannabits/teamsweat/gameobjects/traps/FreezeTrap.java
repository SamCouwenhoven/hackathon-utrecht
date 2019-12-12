package nl.codeforall.cannabits.teamsweat.gameobjects.traps;

import nl.codeforall.cannabits.teamsweat.gameobjects.Player;

public class FreezeTrap extends Trap {

    @Override
    public void spring(){
        player.setFreeze();
    }
}
