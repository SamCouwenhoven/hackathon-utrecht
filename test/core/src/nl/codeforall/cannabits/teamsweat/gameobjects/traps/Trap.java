package nl.codeforall.cannabits.teamsweat.gameobjects.traps;

import com.badlogic.gdx.graphics.Texture;
import nl.codeforall.cannabits.teamsweat.gameobjects.GameObject;
import nl.codeforall.cannabits.teamsweat.gameobjects.Pickable;
import nl.codeforall.cannabits.teamsweat.gameobjects.Player;
import nl.codeforall.cannabits.teamsweat.gameobjects.Useable;

public abstract class Trap extends GameObject implements Pickable, Useable {

    protected Player player;

    public Trap(Texture image) {
        super(image);
    }


    @Override
    public void pickedUp(Player player) {
        //gets picked up by player
        this.player = player;
        player.addTrap(this);
        //removed from the grid
    }

    @Override
    public void use() {
        //place trap

        //removed from player inventory

    }

    public void spring(){
        //spring trap

        //removed from the grid
    }
}
