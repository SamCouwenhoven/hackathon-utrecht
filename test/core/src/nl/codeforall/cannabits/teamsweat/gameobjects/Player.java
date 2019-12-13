package nl.codeforall.cannabits.teamsweat.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import nl.codeforall.cannabits.teamsweat.gameobjects.powerups.PowerUp;
import nl.codeforall.cannabits.teamsweat.gameobjects.traps.Trap;

import java.util.ArrayList;

public class Player extends GameObject{

    private PowerUp powerUp;
    private Trap trap;
    private boolean freeze;
    private int movementSpeed;
    private ArrayList words;
    private static Texture PLAYER_TEXTURE = new Texture(Gdx.files.internal("example/droplet.png"));
    private int musicBoxes;


    public Player(){
        super(PLAYER_TEXTURE);
        movementSpeed = 1;
        words = new ArrayList();
    }

    public void move(){

    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    /*
    public void pickUp(Pickable pickable){
        if(pickable instanceof PowerUp){
            this.powerUp = (PowerUp) pickable;
        }
        else {this.trap = (Trap) pickable;
        }

    }
 */

    public void storeWord(Words words){
        this.words.add(words);
    }

    public void addPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }

    public void removePowerUp() {
        this.powerUp = null;
    }

    public void addTrap(Trap trap) {
        //sets the inventory trap
        this.trap = trap;
    }

    public void usePowerUp(){

    }

    public void placeTrap(){

    }

    public void setFreeze(){
        //speed 0, disable using powerUps or traps
    }

    public void setFire(){
        //inverted controls, triple speed
    }

    public void setMusicBoxes(){
        this.musicBoxes++;
    }

}
