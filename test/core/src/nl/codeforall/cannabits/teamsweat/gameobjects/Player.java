package nl.codeforall.cannabits.teamsweat.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import nl.codeforall.cannabits.teamsweat.gameobjects.powerups.PowerUp;
import nl.codeforall.cannabits.teamsweat.gameobjects.traps.Trap;

import java.util.ArrayList;

public class Player extends GameObject{

    private String name;
    private PowerUp powerUp;
    private Trap trap;
    private boolean freeze;
    private int movementSpeed;
    private ArrayList words;
    private static Texture PLAYER_TEXTURE = new Texture(Gdx.files.internal("example/droplet.png"));
    private int musicBoxes;


    public Player(String name){
        super(PLAYER_TEXTURE);
        movementSpeed = 1;
        musicBoxes = 0;
        words = new ArrayList();
        this.name = name;
    }

    public void move(){

    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }



    public void storeWord(Words words){
        this.words.add(words);
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
        powerUp.pickedUp();
    }

    public void removePowerUp() {
        this.powerUp = null;
    }

    public void setTrap(Trap trap) {
        //sets the inventory trap
        this.trap = trap;
        trap.pickedUp();
    }

    public PowerUp getPowerUp() {
        return powerUp;
    }

    public void usePowerUp(){
        if (powerUp != null) {
            powerUp.use();
            powerUp = null;
        }
    }

    public Trap placeTrap(){
        Trap toReturn = null;
        if (trap != null){
            trap.setX(this.x + 90);
            trap.setY(this.y);
            trap.use();
            toReturn = trap;
            trap = null;
        }
        return toReturn;
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

    public int getMusicBoxes(){
        return this.musicBoxes;
    }

    public String getName(){
        return this.name;
    }

}
