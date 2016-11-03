package com.tutorial.main;
import java.awt.Color;
import java.awt.Graphics;

public class HUD {
    public static int HEALTH = 100;
    private int greenValue = 255;
    private int score = 0;
    private int level = 1;
    
    public void tick(){
        HEALTH = Game.clamp(HEALTH, 0, 200);
        greenValue = Game.clamp(greenValue, 0, 255);
        
        greenValue = HEALTH*2;
        
        score++;
        for(float i = 1; i<10; i++){
            if(score/1000 == i)
                level++;
        }
    }
    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 16);
        g.setColor(new Color(75, greenValue, 0));
        g.fillRect(15, 15, HEALTH * 2, 16);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 16);
        
        g.drawString("Score: " + score, 15, 64);
        g.drawString("Level: " + level, 15, 80);
    }
}
