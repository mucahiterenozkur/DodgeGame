
import com.sun.org.apache.bcel.internal.generic.Select;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mucah
 */
public class Game extends Canvas implements Runnable {

    public static int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    public Thread thread;
    public boolean running = false;

    private Random random;
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Menuu menu;

    public static boolean paused = false;
    public int diff = 0;
    // normal = 0
    // hard = 1

    public enum STATE {
        Menu,
        Select,
        Help,
        Game,
        End
    };

    public static STATE gameState = STATE.Menu;

    public Game() {

        handler = new Handler();
        hud = new HUD();
        menu = new Menuu(this,handler,hud);

        this.addKeyListener(new KeyInput(handler, this));
        this.addMouseListener(menu);

        AudioPlayerr.playMusic("C:\\Users\\mucah\\IdeaProjects\\DodgeGame\\videoplayback (1).wav");

        new Window(WIDTH, HEIGHT, "Dodge Game!", this);

        spawner = new Spawn(handler, hud, this);
        random = new Random();

        /*for(int i = 0; i < 50; i++){
            handler.addObject(new Player(random.nextInt(WIDTH), random.nextInt(HEIGHT), ID.Player));
        }*/


        //we dont need below if but it doesnt give any damage to my code. lets keep it like that.
        if(gameState == STATE.Game){
            handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player,handler));
            handler.addObject(new BasicEnemy(random.nextInt(WIDTH - 50), random.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
        }
        else{
            for(int i = 0; i < 20; i++){
                handler.addObject(new MenuParticle(random.nextInt(WIDTH), random.nextInt(HEIGHT), ID.MenuParticle,handler));
            }
        }

//        handler.addObject(new EnemyBoss((Game.WIDTH/2)-48, -120, ID.EnemyBoss, handler));
//        handler.addObject(new BasicEnemy(random.nextInt(WIDTH), random.nextInt(HEIGHT), ID.BasicEnemy, handler));
//        handler.addObject(new BasicEnemy(random.nextInt(WIDTH), random.nextInt(HEIGHT), ID.BasicEnemy, handler));



        //handler.addObject(new BasicEnemy(WIDTH/2-32, HEIGHT/2-32, ID.BasicEnemy));  // it is coming from the middle and it causes less health in the beginning.

    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running){
                render();
            }

            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;

            }
        }
        stop();
    }

    private void tick(){

        if(gameState == STATE.Game /*|| gameState == STATE.End*/){

            if(!paused){
                hud.tick();
                spawner.tick();
                handler.tick();

                if(HUD.HEALTH <= 0){
                    HUD.HEALTH = 100;
                    gameState = STATE.End;
                    handler.clearEnemys();
                    for(int i = 0; i < 20; i++){
                        handler.addObject(new MenuParticle(random.nextInt(WIDTH), random.nextInt(HEIGHT), ID.MenuParticle,handler));
                    }

                }
            }
        }
        else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select){
            menu.tick();
            handler.tick();
        }
//        else {
//            menu.tick();
//            handler.tick();
//        }

    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        if(paused){
            g.setColor(Color.PINK);
            g.drawString("PAUSED", 15, 100);

        }

        if(gameState == STATE.Game){
            hud.render(g);
        }
        else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select){
            menu.render(g);
        }

        g.dispose();
        bs.show();
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static float clamp(float var, float min, float max){
        if(var >= max){
            return var = max;
        }
        else if(var <= min){
            return var = min;
        }
        else{
            return var;
        }
    }

    public static void main(String[] args) {

        new Game();


    }

}
