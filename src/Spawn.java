
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
public class Spawn {

    private Handler handler;
    private HUD hud;
    private Game game;
    private int scoreKeep;
    private Random random = new Random();

    public Spawn(Handler handler, HUD hud, Game game) {
        this.handler = handler;
        this.hud = hud;
        this.game = game;
    }

    public void tick(){
        scoreKeep++;
        if(Game.gameState != Game.STATE.End){
            if(scoreKeep >= 200){
                scoreKeep = 0;
                hud.setLevel(hud.getLevel() + 1);

                if(game.diff == 0){
                    if(hud.getLevel() == 2){
                        handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                    }
                    else if(hud.getLevel() == 3){
                        handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                    }
                    else if(hud.getLevel() == 4){
                        handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                    }
                    else if(hud.getLevel() == 5){
                        handler.addObject(new SmartEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                    }
                    else if(hud.getLevel() == 6){
                        handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                    }
                    else if(hud.getLevel() == 7){
                        handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                    }
                    else if(hud.getLevel() == 10){
                        handler.clearEnemys();
                        handler.addObject(new EnemyBoss((Game.WIDTH/2)-48, -120, ID.EnemyBoss, handler));
                    }
                }
                else if(game.diff == 1){
                    if(hud.getLevel() == 2){
                        handler.addObject(new HardEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                    }
                    else if(hud.getLevel() == 3){
                        handler.addObject(new HardEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                    }
                    else if(hud.getLevel() == 4){
                        handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                    }
                    else if(hud.getLevel() == 5){
                        handler.addObject(new SmartEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                    }
                    else if(hud.getLevel() == 6){
                        handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                    }
                    else if(hud.getLevel() == 7){
                        handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                    }
                    else if(hud.getLevel() == 10){
                        handler.clearEnemys();
                        handler.addObject(new EnemyBoss((Game.WIDTH/2)-48, -120, ID.EnemyBoss, handler));
                    }
                }

            }
        }


    }


}
