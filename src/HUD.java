
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mucah
 */
public class HUD {

    public static int HEALTH = 100;
    private int greenValue = 255;
    private int level = 1;
    private int score = 0;

    public void tick(){
        //HEALTH--;
        HEALTH = (int) Game.clamp(HEALTH, 0, 100);
        greenValue = (int) Game.clamp(greenValue, 0, 255);
        greenValue = HEALTH*2;

        if(Game.gameState != Game.STATE.End){
            score++;
        }

    }

    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(75,greenValue,0));
        g.fillRect(15, 15, HEALTH * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);

        g.drawString("Level: " + level, 15, 64);
        g.drawString("Score: " + score, 15, 80);


    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
