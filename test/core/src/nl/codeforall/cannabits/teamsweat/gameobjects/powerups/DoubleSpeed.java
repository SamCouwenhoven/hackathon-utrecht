package nl.codeforall.cannabits.teamsweat.gameobjects.powerups;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class DoubleSpeed extends PowerUp {
    private static Texture DOUBLE_SPEED_TEXTURE = new Texture(Gdx.files.internal("powerups/speed-up.png"));
    private static Sound DOUBLE_SPEED_SOUND = Gdx.audio.newSound(Gdx.files.internal("powerups/sound/speed-up.wav"));

    public DoubleSpeed() {
        super(DOUBLE_SPEED_TEXTURE, DOUBLE_SPEED_SOUND);
    }



}
