package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossOneLaser extends GameObject{

    private Handler handler;
    Random r = new Random();
    private int timer = 5;
    
    public EnemyBossOneLaser(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        velX = 5;
        velY = (r.nextInt(5 - (-5+1)) - 5);
        this.handler = handler;
    }
    
    public Rectangle getBounds() {
       return new Rectangle((int)x,(int)y,8,8);
    }

    public void tick() {
        x += velX;
        y += velY;
        
        //if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        //if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
        if(x >= Game.WIDTH) handler.removeObject(this);
            
        handler.addObject(new Trail(x,y,ID.Trail,Color.red, 8,8, (float) 0.06, handler));
    }

    public void render(Graphics g) { 
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 8, 8);
    } 
}
