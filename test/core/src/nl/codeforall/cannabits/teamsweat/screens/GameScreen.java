package nl.codeforall.cannabits.teamsweat.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import nl.codeforall.cannabits.teamsweat.game.LyricsFinder;
import nl.codeforall.cannabits.teamsweat.gameobjects.Pickable;
import nl.codeforall.cannabits.teamsweat.gameobjects.Player;
import nl.codeforall.cannabits.teamsweat.gameobjects.traps.FreezeTrap;
import nl.codeforall.cannabits.teamsweat.gameobjects.traps.Trap;

import java.util.Iterator;

public class GameScreen implements Screen {

    private final int TRAVEL_DISTANCE = 200;
    public static final int X_SCREENLIMIT = 800;
    public static final int Y_SCREENLIMIT = 480;
    public static final int SPRITESIZE = 64;

    private Player player1;
    private Player player2;

    private LyricsFinder game;
    private OrthographicCamera camera;
    private Array<Trap> traps;

    public GameScreen(final LyricsFinder game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, X_SCREENLIMIT, Y_SCREENLIMIT);

        player1 = new Player();
        player2 = new Player();

        traps = new Array<>();
        traps.add(new FreezeTrap());


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
        game.batch.draw(player1.getImage(), player1.x, player1.y);
        game.batch.draw(player2.getImage(), player2.x, player2.y);
        for (Trap trap: traps) {
            game.batch.draw(trap.getImage(), trap.x, trap.y);
        }
        game.batch.end();

        Iterator<Trap> iter = traps.iterator();
        while (iter.hasNext()) {
            Trap trap = iter.next();
            if (trap.isPickedUp() && !trap.isArmed()) {
                iter.remove();
            }
            if (trap.isArmed()) {
                if (player1.overlaps(trap)) {
                    trap.spring();
                    iter.remove();
                }
                if (player2.overlaps(trap)) {
                    trap.spring();
                    iter.remove();
                }
            }else{
                if (player1.overlaps(trap)){
                    player1.addTrap(trap);
                }
                if (player2.overlaps(trap)){
                    player2.addTrap(trap);
                }
            }
        }

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


        setPlayerControls(player1, Input.Keys.UP, Input.Keys.DOWN, Input.Keys.LEFT, Input.Keys.RIGHT, Input.Keys.SHIFT_RIGHT);
        setPlayerControls(player2, Input.Keys.W, Input.Keys.S, Input.Keys.A, Input.Keys.D,Input.Keys.SHIFT_LEFT);





    }

    private void setPlayerControls(Player player, int up, int down, int left, int right, int placeTrap){
        /*
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            player.x -= TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            player.x += TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            player.y -= TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            player.y += TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        */

        if(Gdx.input.isKeyPressed(left)) {
            player.x -= TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(right)) {
            player.x += TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(down)) {
            player.y -= TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(up)) {
            player.y += TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(placeTrap)) {
            Trap trap = player.placeTrap();
            if (trap != null){
                traps.add(trap);
            }
        }


        //Boundaries
        if (player.x < 0) {
            player.x = 0;
        }
        if (player.y < 0) {
            player.y = 0;
        }
        if (player.x > X_SCREENLIMIT - SPRITESIZE) {
            player.x = X_SCREENLIMIT - SPRITESIZE;
        }
        if (player.y > Y_SCREENLIMIT - SPRITESIZE) {
            player.y = Y_SCREENLIMIT - SPRITESIZE;
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

    }
}
