package nl.codeforall.cannabits.teamsweat.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import nl.codeforall.cannabits.teamsweat.game.LyricsFinder;
import nl.codeforall.cannabits.teamsweat.gameobjects.Player;
import nl.codeforall.cannabits.teamsweat.gameobjects.musicboxes.MusicBox;

import java.util.ArrayList;
import java.util.Iterator;

public class GameScreen implements Screen {

    private final int TRAVEL_DISTANCE = 200;
    public static final int X_SCREENLIMIT = 800;
    public static final int Y_SCREENLIMIT = 480;
    public static final int SPRITESIZE = 64;

    private Player player1;
    private Player player2;

    private ArrayList<MusicBox> musicBoxes;

    //TODO: remove placeholder
    private Texture playerPlaceHolder;
    private Texture musicPlaceHolder;

    private LyricsFinder game;
    private OrthographicCamera camera;

    public GameScreen(final LyricsFinder game) {
        this.game = game;
        musicBoxes = new ArrayList<MusicBox>();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, X_SCREENLIMIT, Y_SCREENLIMIT);

        //TODO: remove placeholder
        playerPlaceHolder = new Texture(Gdx.files.internal("example/droplet.png"));
        musicPlaceHolder = new Texture(Gdx.files.internal("musicboxes/73687619-icon-music-box-scaled.png"));


        player1 = new Player();
        player1.x = 500/2 - SPRITESIZE;
        player1.y = 20;
        player1.width = SPRITESIZE;
        player1.height = SPRITESIZE;
        player2 = new Player();
        player2.x = 200;
        player2.y = 20;
        player2.width = SPRITESIZE;
        player2.height = SPRITESIZE;


        for (int i = 0; i<15; i++){
        musicBoxes.add(new MusicBox());
        musicBoxes.get(i).x = (float) (Math.random() * X_SCREENLIMIT + 1);
        musicBoxes.get(i).y = (float) (Math.random() * Y_SCREENLIMIT + 1);
        musicBoxes.get(i).width = SPRITESIZE;
        musicBoxes.get(i).height = SPRITESIZE;
        }

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
        game.batch.draw(playerPlaceHolder, player1.x, player1.y);
        game.batch.draw(playerPlaceHolder, player2.x, player2.y);

        for (MusicBox musicBox :musicBoxes
             ) {game.batch.draw(musicPlaceHolder,musicBox.x,musicBox.y);
            
        }

        Iterator<MusicBox> iter = musicBoxes.iterator();
        while (iter.hasNext()) {
            MusicBox musicBox = iter.next();
            if (musicBox.overlaps(player1) || musicBox.overlaps(player2)) {
                musicBox.getSound().play();
                iter.remove();
            }
        }

        for (MusicBox musicBox :musicBoxes
        ) {
            if (musicBox.overlaps(player1) || musicBox.overlaps(player2)){
            musicBoxes.remove(musicBox);
        }

        }
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
        setPlayerControls(player1, Input.Keys.UP, Input.Keys.DOWN, Input.Keys.LEFT, Input.Keys.RIGHT);
        setPlayerControls(player2, Input.Keys.W, Input.Keys.S, Input.Keys.A, Input.Keys.D);

    }

    private void setPlayerControls(Player player, int up, int down, int left, int right){
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

        if(Gdx.input.isKeyPressed(left))
            player.x -= TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(right))
            player.x += TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(down))
            player.y -= TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(up))
            player.y += TRAVEL_DISTANCE * player.getMovementSpeed() * Gdx.graphics.getDeltaTime();

        //Boundaries
        if (player.x < 0)
            player.x = 0;
        if (player.y < 0)
            player.y = 0;
        if (player.x > X_SCREENLIMIT-SPRITESIZE)
            player.x = X_SCREENLIMIT-SPRITESIZE;
        if (player.y > Y_SCREENLIMIT-SPRITESIZE)
            player.y = Y_SCREENLIMIT-SPRITESIZE;
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
