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

<<<<<<< HEAD
    public Enemy( TileMap t ) {//construtor calls super constructor 
=======
    public Enemy( TileMap t ) {
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
        
        super( t );

    }

<<<<<<< HEAD
    public boolean isDead( ){//checks if the enemy is dead 
=======
    public boolean isDead( ){
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345

        return dead;

    }

<<<<<<< HEAD
    public int getDamage( ) {//gets the enemy damage 
=======
    public int getDamage( ) {
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345

        return damage;

    }

<<<<<<< HEAD
    public void hit( int d ) {//if hit is successful then remove damage from health 
=======
    public void hit( int d ) {
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345

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
<<<<<<< HEAD
    public int getHealth( ){//getter for health 
=======
    public int getHealth( ){
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
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