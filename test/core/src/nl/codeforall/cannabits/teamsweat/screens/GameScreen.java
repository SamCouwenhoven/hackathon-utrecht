package nl.codeforall.cannabits.teamsweat.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import nl.codeforall.cannabits.teamsweat.game.LyricsFinder;
import nl.codeforall.cannabits.teamsweat.gameobjects.Player;

import java.awt.*;

public class GameScreen implements Screen {

    private final int X_SCREENLIMIT = 500;
    private final int Y_SCREENLIMIT = 150;
    private final int SPRITESIZE = 64;

    private Player player1;
    private Player player2;

    private LyricsFinder game;
    private OrthographicCamera camera;


    public GameScreen(final LyricsFinder game) {
        this.game = game;

        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1000, 600);

        player1 = new Player();
        player2 = new Player();
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
        game.font.draw(game.batch, "this is the temp gamescreen ", X_SCREENLIMIT, Y_SCREENLIMIT);
        game.batch.end();

        //Boundaries
        if (player1.x < 0)
            player1.x = 0;
        if (player2.x < 0)
            player2.x = 0;
        if (player1.x > X_SCREENLIMIT-SPRITESIZE)
            player1.x = X_SCREENLIMIT-SPRITESIZE;
        if (player2.y > Y_SCREENLIMIT-SPRITESIZE)
            player2.y = Y_SCREENLIMIT-SPRITESIZE;

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
