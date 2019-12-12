package nl.codeforall.cannabits.teamsweat.gameobjects;

import nl.codeforall.cannabits.teamsweat.gameobjects.powerups.PowerUp;
import nl.codeforall.cannabits.teamsweat.gameobjects.traps.Trap;

import java.util.ArrayList;

public class Player extends GameObject{

    private PowerUp powerUp;
    private Trap trap;// its a trap
    private boolean freeze;
    private ArrayList words;


    public Player(){
        words = new ArrayList();
    }

    public void move(){

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

}
