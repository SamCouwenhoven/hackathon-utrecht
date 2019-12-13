package nl.codeforall.cannabits.teamsweat.gameobjects.musicboxes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import nl.codeforall.cannabits.teamsweat.gameobjects.GameObject;
import nl.codeforall.cannabits.teamsweat.gameobjects.Pickable;
import nl.codeforall.cannabits.teamsweat.gameobjects.Player;

import javax.crypto.spec.PSource;

public class MusicBox extends GameObject implements Pickable {

    private static final Texture IMAGE = new Texture("traps/ice.png");
    private Sound sound;


    public MusicBox(Sound sound) {
        super(IMAGE);
        this.sound = Gdx.audio.newSound(Gdx.files.internal("example/musicboxes/Sonic.Ring.mp3"));
    }

    @Override
    public void pickedUp(Player player) {
        player.setMusicBoxes();

    }

    @Override
    public void use() {
        //can't be used
    }
}
