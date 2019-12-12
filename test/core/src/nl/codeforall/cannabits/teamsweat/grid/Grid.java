package nl.codeforall.cannabits.teamsweat.grid;

//Field

import java.lang.reflect.Array;

public class Grid {
    private Tile[][] tiles;

    public Grid(int col, int rows){
        tiles = new Tile[col][rows];
        createGrid(col, rows);


    }

    private void createGrid(int col, int rows){

        for (int i = 0; i < col; i++){

            for (int j = 0; j < rows; j++){
                tiles[i][j] = new Tile();

            }

        }

    }

}
