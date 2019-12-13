package nl.codeforall.cannabits.teamsweat.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import nl.codeforall.cannabits.teamsweat.game.LyricsFinder;
import nl.codeforall.cannabits.teamsweat.gameobjects.Pickable;
import nl.codeforall.cannabits.teamsweat.gameobjects.Player;
import nl.codeforall.cannabits.teamsweat.gameobjects.Words;
import nl.codeforall.cannabits.teamsweat.gameobjects.powerups.DoubleSpeed;
import nl.codeforall.cannabits.teamsweat.gameobjects.powerups.PowerUp;
import nl.codeforall.cannabits.teamsweat.gameobjects.traps.FreezeTrap;
import nl.codeforall.cannabits.teamsweat.gameobjects.traps.Trap;

import java.util.ArrayList;
import java.util.Iterator;

import nl.codeforall.cannabits.teamsweat.gameobjects.musicboxes.MusicBox;

public class GameScreen implements Screen {

    private final int TRAVEL_DISTANCE = 200;
    public static final int X_SCREENLIMIT = 800;
    public static final int Y_SCREENLIMIT = 480;
    public static final int SPRITESIZE = 64;

    private Player player1;
    private Player player2;

    private Array<MusicBox> musicBoxes;

    private LyricsFinder game;
    private OrthographicCamera camera;
    private Array<Trap> traps;
    private Music bgm;
    private TextureRegion backgroundTexture;

    private Array<PowerUp> powerUps;

    public GameScreen(final LyricsFinder game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, X_SCREENLIMIT, Y_SCREENLIMIT);

        player1 = new Player("Player 1");
        player2 = new Player("Player 2");

        traps = new Array<>();
        traps.add(new FreezeTrap());
        backgroundTexture = new TextureRegion(new Texture("gamemap.png"), 0, 0, X_SCREENLIMIT, Y_SCREENLIMIT);

        powerUps = new Array<>();
        powerUps.add(new DoubleSpeed());

        musicBoxes = new Array<>();
        musicBoxes.add(new MusicBox());
        musicBoxes.add(new MusicBox());
        musicBoxes.add(new MusicBox());


        bgm = Gdx.audio.newMusic(Gdx.files.internal("gamebgm.mp3"));
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

        game.batch.begin();// draw in here
        game.batch.draw(backgroundTexture, 0, 0);
        game.font.draw(game.batch, "this is the temp gamescreen ", X_SCREENLIMIT, Y_SCREENLIMIT);
        game.batch.draw(player1.getImage(), player1.getX(), player1.getY());
        game.batch.draw(player2.getImage(), player2.getX(), player2.getY());
        for (Trap trap : traps) {
            game.batch.draw(trap.getImage(), trap.getX(), trap.getY());
        }
        for (PowerUp powerUp : powerUps) {
            game.batch.draw(powerUp.getImage(), powerUp.getX(), powerUp.getY());
        }

        for (MusicBox musicBox : musicBoxes
        ) {
            game.batch.draw(musicBox.getImage(), musicBox.x, musicBox.y);

        }

        Iterator<MusicBox> musicBoxIterator = musicBoxes.iterator();
        while (musicBoxIterator.hasNext()) {
            MusicBox musicBox = musicBoxIterator.next();
            if (musicBox.overlaps(player1)) {
                musicBox.getSound().play();
                musicBoxIterator.remove();
                player1.setMusicBoxes();
            }

            if (musicBox.overlaps(player2)) {
                player2.setMusicBoxes();
                musicBox.getSound().play();
                musicBoxIterator.remove();

            }
        }


        game.batch.end();

        Iterator<PowerUp> powerUpIterator = powerUps.iterator();
        while (powerUpIterator.hasNext()) {
            PowerUp powerUp = powerUpIterator.next();

            if (player1.overlaps(powerUp)) {
                player1.setPowerUp(powerUp);
            }
            if (player2.overlaps(powerUp)) {
                player2.setPowerUp(powerUp);
            }

            if (powerUp.isPickedUp()) {
                powerUpIterator.remove();
            }

        }

        Iterator<Trap> trapIterator = traps.iterator();
        while (trapIterator.hasNext()) {
            Trap trap = trapIterator.next();
            if (trap.isPickedUp() && !trap.isArmed()) {
                trapIterator.remove();
            }
            if (trap.isArmed()) {
                if (player1.overlaps(trap)) {
                    trap.spring();
                    trapIterator.remove();
                }
                if (player2.overlaps(trap)) {
                    trap.spring();
                    trapIterator.remove();
                }
            } else {
                if (player1.overlaps(trap)) {
                    player1.setTrap(trap);
                }
                if (player2.overlaps(trap)) {
                    player2.setTrap(trap);
                }
            }
        }

        if (musicBoxes.isEmpty()) {
            game.setScreen(new WinningScreen(game,getWinningPlayer()));
            dispose();
        }

        setPlayerControls(player1, Input.Keys.UP, Input.Keys.DOWN, Input.Keys.LEFT, Input.Keys.RIGHT, Input.Keys.SHIFT_RIGHT, Input.Keys.BACKSLASH);
        setPlayerControls(player2, Input.Keys.W, Input.Keys.S, Input.Keys.A, Input.Keys.D, Input.Keys.SHIFT_LEFT, Input.Keys.TAB);


    }

    private void setPlayerControls(Player player, int up, int down, int left, int right, int placeTrap, int usePowerUp) {


        if (Gdx.input.isKeyPressed(left)) {
            player.x -= TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(right)) {
            player.x += TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(down)) {
            player.y -= TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(up)) {
            player.y += TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(placeTrap)) {
            Trap trap = player.placeTrap();
            if (trap != null) {
                traps.add(trap);
            }
        }
        if (Gdx.input.isKeyPressed(usePowerUp)) {
            PowerUp powerUp;
            if ((powerUp = player.getPowerUp()) != null) {
                player.usePowerUp();
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

    public Player getWinningPlayer(){
        if (player1.getMusicBoxes() > player2.getMusicBoxes())
        {
            return player1;
        }

        return player2;
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
