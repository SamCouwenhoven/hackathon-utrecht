package nl.codeforall.cannabits.teamsweat.gameobjects.powerups;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import nl.codeforall.cannabits.teamsweat.gameobjects.GameObject;
import nl.codeforall.cannabits.teamsweat.gameobjects.Pickable;
import nl.codeforall.cannabits.teamsweat.gameobjects.Player;

public abstract class PowerUp extends GameObject implements Pickable{

    private boolean picked;
    private Sound activationSound;

    public PowerUp(Texture image,Sound activationSound) {
        super(image);
        this.activationSound = activationSound;
        picked = false;
    }

    @Override
    public void pickedUp() {
        //add to player
        picked = true;


    }

    @Override
    public void use() {
        activationSound.play();
        //remove from inventory

    }

    @Override
    public boolean isPickedUp() {
        return picked;
    }


}
