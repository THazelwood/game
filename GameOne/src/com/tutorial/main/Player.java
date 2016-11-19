package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
    
    private Random r = new Random();
    Handler handler;
    
    public Player(float x, float y, ID id, Handler handler){
        super(x,y,id);
        this.handler = handler;
    }
    
    public Rectangle getBounds() {
       return new Rectangle((int)x,(int)y,32,32);
    }
    
    public void tick(){
        x += velX;
        y += velY;
       
        x = Game.clamp(x, 0, Game.WIDTH - 35);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);
        
        handler.addObject(new Trail(x,y,ID.Trail,Color.white, 32,32, (float) 0.1, handler));
        
        collision();
    }
    
    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getID() == ID.BasicEnemy || tempObject.getID() == ID.VerticalEnemy || tempObject.getID() == ID.HorizontalEnemy || tempObject.getID() == ID.FastEnemy || tempObject.getID() == ID.SmartEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 2;
                }
            }
            if(tempObject.getID() == ID.EnemyBossOne){
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 10;
                }
            }
        }
    }
    
    public void render(Graphics g){
        g.setColor(Color.white);
        g.fillRect((int)x, (int)y, 32, 32);
    }  
}
