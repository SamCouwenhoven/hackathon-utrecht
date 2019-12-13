package nl.codeforall.cannabits.teamsweat.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import nl.codeforall.cannabits.teamsweat.game.LyricsFinder;
import nl.codeforall.cannabits.teamsweat.gameobjects.Player;

public class WinningScreen implements Screen {

    final LyricsFinder game;
    private Player player;
    private Music bgm;

    private OrthographicCamera camera;

    public WinningScreen(LyricsFinder game, Player player) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        this.player = player;

        bgm = Gdx.audio.newMusic(Gdx.files.internal("endbgm.mp3"));
        bgm.setLooping(true);

    }


    @Override
    public void show() {
        bgm.play();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0.412f, 0.71f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, player.getName() + " Won", 237, 240);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        bgm.dispose();
    }
}
