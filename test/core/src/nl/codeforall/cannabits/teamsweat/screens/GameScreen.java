package nl.codeforall.cannabits.teamsweat.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import nl.codeforall.cannabits.teamsweat.game.LyricsFinder;

public class GameScreen implements Screen {

    private LyricsFinder game;
    private OrthographicCamera camera;

    public GameScreen(final LyricsFinder game) {
        this.game = game;

        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1000, 600);


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0.412f, 0.71f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();// draw in here
        game.font.draw(game.batch, "this is the temp gamescreen ", 500, 150);
        game.batch.end();

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

    }
}
