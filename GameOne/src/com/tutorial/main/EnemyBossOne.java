package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class EnemyBossOne extends GameObject{

    private Handler handler;
    Random r = new Random();
    private int timer = 140;
    private int timer2 = 50;
    
    public EnemyBossOne(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        velX = 0;
        velY = 2;
        this.handler = handler;
    }
    
    public Rectangle getBounds() {
       return new Rectangle((int)x,(int)y,96,96);
    }

    public void tick() {
        if(timer < 40) {
            velX = -7;
        }
        
        if(timer<=0) {
            if (!(timer2 <= 0))velY =0;
            velX = 0;
        }
        else timer--;
        
        if(timer <= 0) timer2--;
        if(timer2 <= 0){
            if(velY == 0) velY = 5;
            if(velY >= 0)velY += 0.005;
            if(velY <= 0)velY -= 0.005;
            
            velY = Game.clamp(velY, -7, 7);
            
            int spawn = r.nextInt(10);
            if(spawn ==0) handler.addObject(new EnemyBossOneLaser((int)x+80,(int)y+60, ID.BasicEnemy, handler));
        }
        
        x += velX;
        y += velY;
        if(timer2 <=0){ 
            if(y <= 0 || y >= Game.HEIGHT - 120) velY *= -1;
        }
    }

    public void render(Graphics g) { 
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/images/jake.jpg"));
        } catch (IOException e) {
        }
        g.setColor(Color.red);
        g.drawImage(img, (int)x,(int)y, null);
    } 
}
