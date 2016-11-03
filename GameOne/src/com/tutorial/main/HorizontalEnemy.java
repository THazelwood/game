package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HorizontalEnemy extends GameObject{

    private Handler handler;
    
    public HorizontalEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        velX = 9;
        velY = 2;
        this.handler = handler;
    }
    
    public Rectangle getBounds() {
       return new Rectangle(x,y,16,16);
    }

    public void tick() {
        x += velX;
        y += velY;
        
        if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
        
        handler.addObject(new Trail(x,y,ID.Trail,Color.ORANGE, 16,16, (float) 0.04, handler));
    }

    public void render(Graphics g) { 
        g.setColor(Color.cyan);
        g.fillRect(x, y, 16, 16);
    } 
}