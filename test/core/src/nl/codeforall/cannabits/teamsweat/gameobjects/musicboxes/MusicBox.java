package nl.codeforall.cannabits.teamsweat.gameobjects.musicboxes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import nl.codeforall.cannabits.teamsweat.gameobjects.GameObject;
import nl.codeforall.cannabits.teamsweat.gameobjects.Pickable;
import nl.codeforall.cannabits.teamsweat.gameobjects.Player;

import javax.crypto.spec.PSource;

public class MusicBox extends GameObject implements Pickable {

    private static final Texture IMAGE = new Texture("musicboxes/73687619-icon-music-box-scaled.png");
    private Sound sound;
    private Boolean pickedUp;


    public MusicBox() {
        super(IMAGE);
        this.sound = Gdx.audio.newSound(Gdx.files.internal("musicboxes/Sonic.Ring.mp3"));
    }

    public Sound getSound(){
        return this.sound;
    }

    public boolean isPickedUp(){
        return this.pickedUp;
    }

    @Override
    public void pickedUp() {

    }

    @Override
    public void use() {
        //can't be used
    }
}
