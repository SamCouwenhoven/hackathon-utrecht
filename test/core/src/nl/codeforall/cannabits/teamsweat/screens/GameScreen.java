package nl.codeforall.cannabits.teamsweat.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import nl.codeforall.cannabits.teamsweat.game.LyricsFinder;
import nl.codeforall.cannabits.teamsweat.gameobjects.Player;

import java.io.InputStream;

public class GameScreen implements Screen {

    private final int TRAVEL_DISTANCE = 200;
    private LyricsFinder game;
    private OrthographicCamera camera;
    private Player player1;

    public GameScreen(final LyricsFinder game) {
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
        /*
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            player1.x -= TRAVEL_DISTANCE * player1.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            player1.x += TRAVEL_DISTANCE * player1.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            player1.y -= TRAVEL_DISTANCE * player1.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            player1.y += TRAVEL_DISTANCE * player1.getMovementSpeed() * Gdx.graphics.getDeltaTime();

         */
        setPlayerControls(player1);
    }

    private void setPlayerControls(Player player){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            player.x -= TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            player.x += TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            player.y -= TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            player.y += TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();

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
