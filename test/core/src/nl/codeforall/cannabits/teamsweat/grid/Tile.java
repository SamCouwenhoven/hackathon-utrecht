package nl.codeforall.cannabits.teamsweat.grid;

//Cell

import nl.codeforall.cannabits.teamsweat.gameobjects.GameObject;

public class Tile {
    private GameObject gameObject;

    public GameObject getGameObject() {
        return gameObject;
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public void removeObject(){
        gameObject = null;
    }
}
