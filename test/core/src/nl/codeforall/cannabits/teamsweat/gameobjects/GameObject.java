package nl.codeforall.cannabits.teamsweat.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import nl.codeforall.cannabits.teamsweat.screens.GameScreen;

public abstract class GameObject extends Rectangle {
    private Texture image;

    public GameObject(Texture image){
        this.image = image;
        this.x = (float) (Math.random() * GameScreen.X_SCREENLIMIT);
        this.y = (float) (Math.random() * GameScreen.Y_SCREENLIMIT);
        this.width = GameScreen.SPRITESIZE;
        this.height = GameScreen.SPRITESIZE;
    }

    public Texture getImage() {
        return image;
    }

    public void setImage(Texture texture){
        this.image = texture;
    }
}
