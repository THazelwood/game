package com.tutorial.main;

import static com.tutorial.main.Game.HEIGHT;
import static com.tutorial.main.Game.WIDTH;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author travbot5000
 */
public class Handler {
    
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            
            tempObject.tick();
        }
    }
    
    public void render(Graphics g){
         for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            
            tempObject.render(g);
        }
    }
    
    public void clearEnemys(){
      for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            
            if(tempObject.getID() != ID.Player){
                object.clear();
                addObject(new Player(WIDTH/2-32,HEIGHT/2-32, ID.Player, this));
            }
        }  
    }
    
    public void addObject(GameObject object){
        this.object.add(object);
    }
    
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
    
}
