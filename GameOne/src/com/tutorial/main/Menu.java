package com.tutorial.main;

import static com.tutorial.main.Game.HEIGHT;
import com.tutorial.main.Game.STATE;
import static com.tutorial.main.Game.WIDTH;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

 class Menu extends MouseAdapter{
     private Game game;
     private Handler handler;
     private Random r = new Random();
     private HUD hud;
     
     public Menu(Game game, Handler handler, HUD hud){
         this.game = game;
         this.handler = handler;
         this.hud = hud;
     }
     
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        if(game.gameState == STATE.Menu){
            
        
            //play button
            if(mouseOver(mx, my, 210, 150, 200, 64)){
                game.gameState = STATE.Game;
                handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player, handler));
                handler.clearEnemys();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50),r.nextInt(Game.HEIGHT -50),ID.BasicEnemy, handler));
                
            }
            //help button
            if(mouseOver(mx, my, 210, 250, 200, 64)){
                game.gameState = STATE.Help;
            }

            //exit button
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                System.exit(1);
            }
        } 
          //back button for help
        if(game.gameState == STATE.Help){
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                game.gameState = STATE.Menu;
                return;
            }
        }
           //back button for endgame
        if(game.gameState == STATE.End){
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                game.gameState = STATE.Menu;
                hud.setLevel(1);
                hud.setScore(0);
                return;
            }
        }
     }
     
     public void mouseReleased(MouseEvent e){
         
     }
     
     private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
         if(mx > x && mx< x + width){
             if(my > y && my < y + height){
                 return true;
             }else return false;
         }else return false;
     }
     
     public void tick(){
         
     }
     
     public void render(Graphics g){
        if(game.gameState == STATE.Menu){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 240, 70);

            g.setFont(fnt2);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Start", 270, 190);

            g.drawRect(210, 250, 200, 64);
            g.drawString("Help", 270, 290);

            g.drawRect(210, 350, 200, 64);
            g.drawString("Quit", 270, 390);
             
        }else if(game.gameState == STATE.Help){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);
            
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("HELP ME!", 200, 70);
            
            g.setFont(fnt3);
            g.drawString("Use the WASD keys to move player and avoid enemies", 50, 200);
            
            g.drawRect(210, 350, 200, 64);
            g.setFont(fnt2);
            g.drawString("Back", 270, 390);
        }else if(game.gameState == STATE.End){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);
            
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("GAME OVER", 150, 70);
            
            g.setFont(fnt3);
            g.drawString("You lost with a score of: " + hud.getScore(),180, 200);
            
            g.drawRect(210, 350, 200, 64);
            g.setFont(fnt2);
            g.drawString("Try Again", 240, 390);
        }
     }
    
}
