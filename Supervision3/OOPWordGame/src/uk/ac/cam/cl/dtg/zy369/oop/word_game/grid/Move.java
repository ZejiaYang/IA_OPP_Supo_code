package uk.ac.cam.cl.dtg.zy369.oop.word_game.grid;

import java.awt.*;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Move {

    private final Grid grid;
    private final GridGUI gui;
    private int score = 0;
    private final Vector<Tile> progressWord;

    public Move(Grid grid, GridGUI gui) {
        this.grid = grid;
        this.gui = gui;
        this.progressWord = new Vector<>();
    }

    public void nextMove(Tile source) {
        this.gui.setTileBackground(this.grid.positionOf(source), Color.white);
        this.gui.setTileForeground(this.grid.positionOf(source), Color.red);
        source.active(true); // changes flag on tile to show}
        progressWord.add(source);
    }

    public boolean validMove(Tile source){
        if(source.checkActive())
            return false;
        if(this.progressWord.isEmpty())
            return true;
        int[][] direction = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        int sy = (int) this.grid.positionOf(source).getY();
        int sx = (int) this.grid.positionOf(source).getX();

        for(Tile pre: progressWord){
            int py = (int) this.grid.positionOf(pre).getY();
            int px = (int) this.grid.positionOf(pre).getX();
            for(int i = 0; i < 8; i++)
            {
                if(sx + direction[i][0] == px && sy + direction[i][1] == py)
                    return true;
            }
        }
        return false;
    }

    public boolean containWord(){
        String word = getProgressWord();
        String dictionary =  "main/resources/words.txt";

        try(BufferedReader search = new BufferedReader(new FileReader(dictionary))){
            String vocab;
            while((vocab = search.readLine()) != null){
                if(vocab.equals(word))
                    return true;
            }
        }catch(IOException e){
            return false;
        }
        return false;
    }
    public String getProgressWord(){
        String ans = "";
        for(Tile tile: progressWord){
            ans += tile.letter();
        }
        return ans.toLowerCase();
    }

    public int getscore(){
        return this.score;
    }

    public boolean acceptWord(){
        if(!containWord())
            return false;
        for(Tile tile: progressWord) {
            this.gui.setTileBackground(this.grid.positionOf(tile), Color.white);
            this.gui.setTileForeground(this.grid.positionOf(tile), Color.CYAN);
            this.score += progressWord.size() * tile.value();
        }
        this.progressWord.clear();
        return true;
    }

    public void resetGame(){
        this.score = 0;
        this.progressWord.clear();
    }

    public void resetMove(Tile tile){
       if(!tile.checkActive() || !this.progressWord.contains(tile))
           return;
       int index = this.progressWord.indexOf(tile);

       for(int i = this.progressWord.size() - 1; i >= index; i--){
           Tile cur = this.progressWord.getLast();
           cur.active(false);
           this.gui.setTileBackground(this.grid.positionOf(cur), Color.white);
           this.gui.setTileForeground(this.grid.positionOf(cur), Color.orange);
           this.progressWord.removeLast();
       }
    }

}
