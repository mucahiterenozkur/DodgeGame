
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
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
public class EnemyBoss extends GameObject{

    private Handler handler;
    Random random = new Random();
    private int timer = 70;
    private int timer2 = 50;

    public EnemyBoss(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 0;
        velY = 2;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(timer <= 0) velY = 0;
        else timer--;

        if(timer <= 0) timer2--;
        if(timer2 <= 0){
            if(velX == 0) velX = 2;

            if(velX > 0) velX += 0.005f;
            else if(velX < 0) velX -= 0.005f;

            velX = Game.clamp(velX, -10, 10);

            int spawn = random.nextInt(10);
            if(spawn == 0) handler.addObject(new EnemyBossBullet((int)x+48, (int)y+48, id.EnemyBoss, handler));

        }

        /*if(y <= 0 || y >= Game.HEIGHT - 60){
            velY *= -1;
        }*/
        if(x <= 0 || x >= Game.WIDTH - 96){
            velX *= -1;
        }

        handler.addObject(new Trail(x, y, ID.Trail, Color.RED, 96, 96, 0.50f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 96, 96);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 96, 96);
    }




}
