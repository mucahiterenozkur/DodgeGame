
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
public class HardEnemy extends GameObject{

    private Handler handler;
    private Random random = new Random();

    public HardEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 5;
        velY = 5;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT - 60){
            if(velY < 0){
                velY = -(random.nextInt(7)+1)*-1;
            }
            else{
                velY = (random.nextInt(7)+1)*-1;
            }
        }
        if(x <= 0 || x >= Game.WIDTH - 25){
            if(velX < 0){
                velX = -(random.nextInt(7)+1)*-1;
            }
            else{
                velX = (random.nextInt(7)+1)*-1;
            }
        }

        handler.addObject(new Trail(x, y, ID.Trail, Color.YELLOW, 16, 16, 0.03f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int)x, (int)y, 16, 16);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }




}
