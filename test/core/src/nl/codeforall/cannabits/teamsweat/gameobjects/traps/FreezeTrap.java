package nl.codeforall.cannabits.teamsweat.gameobjects.traps;

import com.badlogic.gdx.graphics.Texture;
import nl.codeforall.cannabits.teamsweat.gameobjects.Player;

public class FreezeTrap extends Trap {
    private static Texture FREEZE_TRAP_TEXTURE = new Texture("traps/ice.png");

    public FreezeTrap() {
        super(FREEZE_TRAP_TEXTURE);
    }

    @Override
    public void spring(){
        player.setFreeze();
    }
}
