package nl.codeforall.cannabits.teamsweat.gameobjects.powerups;

import com.badlogic.gdx.graphics.Texture;
import nl.codeforall.cannabits.teamsweat.gameobjects.GameObject;
import nl.codeforall.cannabits.teamsweat.gameobjects.Pickable;
import nl.codeforall.cannabits.teamsweat.gameobjects.Player;

public abstract class PowerUp extends GameObject implements Pickable{

    public PowerUp(Texture image) {
        super(image);
    }

    @Override
    public void pickedUp() {
        //add to player


    }

    @Override
    public void use() {
        //remove from inventory

    }


}
