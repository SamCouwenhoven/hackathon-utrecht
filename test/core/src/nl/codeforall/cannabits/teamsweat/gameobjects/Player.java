package nl.codeforall.cannabits.teamsweat.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import nl.codeforall.cannabits.teamsweat.gameobjects.playerstates.Default;
import nl.codeforall.cannabits.teamsweat.gameobjects.playerstates.DoubleSpeed;
import nl.codeforall.cannabits.teamsweat.gameobjects.playerstates.Frozen;
import nl.codeforall.cannabits.teamsweat.gameobjects.playerstates.PlayerStatus;
import nl.codeforall.cannabits.teamsweat.gameobjects.powerups.PowerUp;
import nl.codeforall.cannabits.teamsweat.gameobjects.traps.Trap;
import nl.codeforall.cannabits.teamsweat.screens.GameScreen;

import java.util.ArrayList;

public class Player extends GameObject{

    public static PlayerStatus DEFAULT_PLAYER_STATUS = new Default();
    public static PlayerStatus DOUBLE_SPEED_STATUS = new DoubleSpeed();
    public static PlayerStatus FROZEN_STATUS = new Frozen();

    private final int POWERUP_DURATION = 5;


    private float poweredUptime = 0f;
    private PowerUp powerUp;
    private PlayerStatus status;
    private Trap trap;
    private int movementSpeed;
    private ArrayList words;
    private static Texture PLAYER_TEXTURE = new Texture(Gdx.files.internal("example/droplet.png"));
    private int musicBoxes;


    public Player(){
        super(PLAYER_TEXTURE);
        movementSpeed = 1;
        words = new ArrayList();
        status = DEFAULT_PLAYER_STATUS;
    }

    public void moveLeft(){
        x -= GameScreen.TRAVEL_DISTANCE * getMovementSpeed() * Gdx.graphics.getDeltaTime();
    }

    public void moveRight(){
        x += GameScreen.TRAVEL_DISTANCE * getMovementSpeed() * Gdx.graphics.getDeltaTime();
    }

    public void moveUp(){
        y += GameScreen.TRAVEL_DISTANCE * getMovementSpeed() * Gdx.graphics.getDeltaTime();
    }

    public void moveDown(){
        y -= GameScreen.TRAVEL_DISTANCE * getMovementSpeed() * Gdx.graphics.getDeltaTime();
    }

    public int getMovementSpeed() {
        return status.getMovementSpeed();
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
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
            status = powerUp.use();
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

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    public void setDefault(){
        status = DEFAULT_PLAYER_STATUS;
    }

}
