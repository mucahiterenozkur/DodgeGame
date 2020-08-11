
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
public class MenuParticle extends GameObject{

    private Handler handler;
    Random random = new Random();
    private Color color;

    public MenuParticle(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = (random.nextInt(7 - -7) + -7);
        velY = (random.nextInt(7 - -7) + -7);

        if(velX == 0) velX = 1;
        if(velY == 0) velY = 1;

        color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT - 60){
            velY *= -1;
        }
        if(x <= 0 || x >= Game.WIDTH - 25){
            velX *= -1;
        }

        handler.addObject(new Trail(x, y, ID.Trail, color, 16, 16, 0.05f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect((int)x, (int)y, 16, 16);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }




}
