package Entity;

import java.awt.Graphics2D;

import TileMap.TileMap;
public class Enemy extends MapObject {

    protected int health;
    protected int maxHealth;
    protected boolean dead;
    protected int damage;

    protected boolean flinching;
    protected long flinchTimer;

    public Enemy( TileMap t ) {//construtor calls super constructor 
        
        super( t );

    }

    public boolean isDead( ){//checks if the enemy is dead 

        return dead;

    }

    public int getDamage( ) {//gets the enemy damage 

        return damage;

    }

    public void hit( int d ) {//if hit is successful then remove damage from health 

        if( dead || flinching )
           return;
        
           health = health - d;
        
        if( health < 0 ){
           health = 0;
           dead = true;
        }
        flinching = true;
        flinchTimer = System.nanoTime( );
    }

    public void update( ){
        
    }
    public int getHealth( ){//getter for health 
    	return maxHealth;
    }

    public void draw(Graphics2D g){
		setMapPosition();
		
		//draw player
		if(flinching){
			long elapsed = (System.nanoTime()- flinchTimer) / 1000000;
			if(elapsed/100%2 == 0){
				return;
			}
		}
		
		if(facingRight){
			g.drawImage(animation.getImage(),(int)(x + xmap - width /2),(int)(y + ymap -height/2),null);
		}
		
		else{
			g.drawImage(animation.getImage(),(int)(x + xmap - width /2 + width),(int)(y + ymap -height/2),-width,height,null);
		}
		
	}







}