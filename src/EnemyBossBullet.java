
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
public class EnemyBossBullet extends GameObject{

    private Handler handler;
    Random random = new Random();

    public EnemyBossBullet(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = random.nextInt(5 - -5) + -5;
        velY = 5;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

//        if(y <= 0 || y >= Game.HEIGHT - 60){
//            velY *= -1;
//        }
//        if(x <= 0 || x >= Game.WIDTH - 25){
//            velX *= -1;
//        }

        if(y >= Game.HEIGHT) handler.remove(this);

        handler.addObject(new Trail(x, y, ID.Trail, Color.RED, 16, 16, 0.03f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, 16, 16);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }




}
