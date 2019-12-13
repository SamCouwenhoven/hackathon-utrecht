package nl.codeforall.cannabits.teamsweat.gameobjects.traps;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import nl.codeforall.cannabits.teamsweat.gameobjects.GameObject;
import nl.codeforall.cannabits.teamsweat.gameobjects.Pickable;
import nl.codeforall.cannabits.teamsweat.gameobjects.Player;

public abstract class Trap extends GameObject implements Pickable{
    private boolean armed;
    private boolean pickedUp;
    private Sound springSound;

    public Trap(Texture image,Sound springSound) {

        super(image);
        this.springSound = springSound;
        armed = false;
    }


    @Override
    public void pickedUp() {
        //gets picked up by player
        pickedUp = true;
        //removed from the grid
    }

    @Override
    public void use() {
        //place trap
        armed = true;
        //removed from player inventory

    }


    public void spring(){
        //spring trap
        armed = false;
        springSound.play();
        //removed from the grid

    }

    public boolean isArmed() {
        return armed;
    }

    @Override
    public boolean isPickedUp() {
        return pickedUp;
    }
}
