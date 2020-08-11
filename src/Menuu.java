

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mucah
 */
public class Menuu extends MouseAdapter {

    private Game game;
    private Handler handler;
    private HUD hud;
    Random random = new Random();

    public Menuu(Game game, Handler handler,HUD hud){
        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }

    @Override
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        if(game.gameState == Game.STATE.Menu){
            // play button
            if(mouseOver(mx, my, 210, 140, 200, 64)){
//                game.gameState = Game.STATE.Game;
//                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player,handler));
//                handler.clearEnemys();
//                handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                game.gameState = Game.STATE.Select;
                AudioPlayerr.playMusic("C:\\Users\\mucah\\IdeaProjects\\DodgeGame\\Mouse-Click-00-m-FesliyanStudios.com.wav");
                return;
            }

            // help button
            if(mouseOver(mx, my, 210, 240, 200, 64)){
                game.gameState = Game.STATE.Help;
                AudioPlayerr.playMusic("C:\\Users\\mucah\\IdeaProjects\\DodgeGame\\Mouse-Click-00-m-FesliyanStudios.com.wav");
            }

            // quit button
            if(mouseOver(mx, my, 210, 340, 200, 64)){
                System.exit(1);
            }
        }

        if(game.gameState == Game.STATE.Select){
            // normal button
            if(mouseOver(mx, my, 210, 140, 200, 64)){
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player,handler));
                handler.clearEnemys();
                handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                game.diff = 0;
                AudioPlayerr.playMusic("C:\\Users\\mucah\\IdeaProjects\\DodgeGame\\Mouse-Click-00-m-FesliyanStudios.com.wav");
            }

            // hard button
            if(mouseOver(mx, my, 210, 240, 200, 64)){
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player,handler));
                handler.clearEnemys();
                handler.addObject(new HardEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                game.diff = 1;
                AudioPlayerr.playMusic("C:\\Users\\mucah\\IdeaProjects\\DodgeGame\\Mouse-Click-00-m-FesliyanStudios.com.wav");
            }

            // back button
            if(mouseOver(mx, my, 210, 340, 200, 64)){
                game.gameState = Game.STATE.Menu;
                AudioPlayerr.playMusic("C:\\Users\\mucah\\IdeaProjects\\DodgeGame\\Mouse-Click-00-m-FesliyanStudios.com.wav");
                return;
            }
        }





        // back button
        if(game.gameState == Game.STATE.Help){
            if(mouseOver(mx, my, 210, 340, 200, 64)){
                game.gameState = Game.STATE.Menu;
                AudioPlayerr.playMusic("C:\\Users\\mucah\\IdeaProjects\\DodgeGame\\Mouse-Click-00-m-FesliyanStudios.com.wav");
                return;
            }
        }

        // again button
        if(game.gameState == Game.STATE.End){
            if(mouseOver(mx, my, 210, 340, 200, 64)){
                game.gameState = Game.STATE.Menu;
                hud.setLevel(0);
                hud.setScore(0);
                AudioPlayerr.playMusic("C:\\Users\\mucah\\IdeaProjects\\DodgeGame\\Mouse-Click-00-m-FesliyanStudios.com.wav");
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e){

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;
            }
            else return false;
        }
        else return false;
    }

    public void render(Graphics g){
        if(game.gameState == Game.STATE.Menu){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 15);

            g.setFont(fnt);
            g.setColor(Color.red);
            g.drawString("DODGE", 220, 100);

            g.setFont(fnt2);
            g.setColor(Color.WHITE);
            g.drawRect(210, 140, 200, 64);
            g.drawString("Play", 280, 180);

            g.setColor(Color.WHITE);
            g.drawRect(210, 240, 200, 64);
            g.drawString("Help", 280, 280);

            g.setColor(Color.WHITE);
            g.drawRect(210, 340, 200, 64);
            g.drawString("Quit", 280, 380);

            g.setFont(fnt3);
            g.setColor(Color.GRAY);
            g.drawString("redesigned by Mücahit Eren Özkur", 185, 20);
        }
        else if(game.gameState == Game.STATE.Help){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.red);
            g.drawString("Help", 250, 100);

            g.setFont(fnt3);
            g.setColor(Color.MAGENTA);
            g.drawString("Use 'WASD' Keys to move player and dodge enemies.", 70, 160);
            g.setColor(Color.BLUE);
            g.drawString("Use 'P' Key to pause the game.", 70, 180);
            g.setColor(Color.ORANGE);
            g.drawString("1 Level = 200 Score.", 70, 200);
            g.setColor(Color.CYAN);
            g.drawString("In 10 Level and after, you have to confront with a boss!", 70, 220);
            g.setColor(Color.GREEN);
            g.drawString("Good Luck! Have Fun!", 70, 240);
            g.setColor(Color.RED);
            g.drawString("If you have any feedbacks or ideas;", 70, 280);
            g.setColor(Color.red);
            g.drawString("Contact with me: mucahiterenozkur@hotmail.com", 70, 300);

            g.setFont(fnt2);
            g.setColor(Color.WHITE);
            g.drawRect(210, 340, 200, 64);
            g.drawString("Back", 270, 380);
        }
        else if(game.gameState == Game.STATE.End){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.red);
            g.drawString("Game Over!", 170, 90);

            g.setFont(fnt3);
            g.setColor(Color.WHITE);
            g.drawString("You lost with a score of: " + hud.getScore(), 175, 200);

            g.setFont(fnt2);
            g.setColor(Color.WHITE);
            g.drawRect(210, 340, 200, 64);
            g.drawString("Try Again", 245, 380);
        }
        else if(game.gameState == Game.STATE.Select){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.red);
            g.drawString("Select Difficulty", 140, 90);

            g.setFont(fnt2);
            g.setColor(Color.WHITE);
            g.drawRect(210, 140, 200, 64);
            g.drawString("Normal", 265, 180);

            g.setColor(Color.WHITE);
            g.drawRect(210, 240, 200, 64);
            g.drawString("Hard", 275, 280);

            g.setColor(Color.WHITE);
            g.drawRect(210, 340, 200, 64);
            g.drawString("Back", 275, 380);
        }

    }

    public void tick(){

    }

}
