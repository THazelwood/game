package com.tutorial.main;

import java.util.Random;

public class Spawn {
    private Handler handler;
    private HUD hud;
    
    private int scoreKeep = 0;
    private Random r = new Random();
    
    public Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }
    
    public void tick(){
        scoreKeep++;
        if(scoreKeep >= 300){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            switch(hud.getLevel()) {
                case 2: handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50),ID.BasicEnemy, handler));
                        break;
                case 3: handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50),ID.BasicEnemy, handler));
                        break;
                case 4: handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50),ID.FastEnemy, handler));
                        break;
                case 5: handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50),ID.SmartEnemy, handler));
                        break;
                case 6: handler.addObject(new HorizontalEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50),ID.HorizontalEnemy, handler));
                        break;
                case 7: handler.addObject(new VerticalEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50),ID.VerticalEnemy, handler));
                        break;
                case 8: handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50),ID.FastEnemy, handler));
                        break;
                case 9: handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50),ID.BasicEnemy, handler));
                        break;
                case 10: 
                    handler.clearEnemys();
                    handler.addObject(new EnemyBossOne((Game.WIDTH / 2)-48,-150,ID.EnemyBossOne, handler));
                        break;
            }
        }
    }
}
