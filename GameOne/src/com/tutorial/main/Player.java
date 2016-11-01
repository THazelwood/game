package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author travbot5000
 */
public class Player extends GameObject {
    private Random r = new Random();
    public Player(int x, int y, ID id){
        super(x,y,id);
        
        //velX = r.nextInt(5) + 1;
        //velY = r.nextInt(5);
    }
    
    public void tick(){
        x += velX;
        y += velY;
    }
    
    public void render(Graphics g){
        if(id == ID.Player) g.setColor(Color.white);
        else if(id == ID.Player2)g.setColor(Color.blue);
        //g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }
    
}
