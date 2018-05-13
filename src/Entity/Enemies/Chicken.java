package Entity.Enemies;

import Entity.*;
import TileMap.TileMap;
import GameState.GameState;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Chicken extends Enemy {

    private BufferedImage[ ] sprites;

    public Chicken( TileMap t, int d ){

        super( t );

        moveSpeed = 0.3;
        maxSpeed = 0.3;
        fallSpeed = 0.2;
        maxFallSpeed = 10.0;

        width = 30;
        height = 30;
        cwidth = 20;
        cheight = 20;

        health = maxHealth = 10 * d;
        damage = 1 * d;

        //load sprites
        try{

            BufferedImage spritesheet = ImageIO.read( 
                getClass( ).getResourceAsStream(
                    "/Sprites/Enemies/slugger.gif"
                )
            );
            sprites = new BufferedImage[ 3 ];
            for( int i = 0; i < sprites.length; i++ ){

                sprites[ i ] = spritesheet.getSubimage( 
                    i * width, 0, width, height );
            }
        }
        catch( Exception e ){
            e.printStackTrace( );
        }
<<<<<<< HEAD
		//set animation for chicken 
=======

>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
        animation = new Animation( );
        animation.setFrames( sprites );
        animation.setDelay( 300 );

        right = true;
        facingRight = true;

    }

<<<<<<< HEAD
    private void getNextPostion( ){//gets the postion of the chicken 
=======
    private void getNextPostion( ){
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345

        if(left){
			dx -= moveSpeed;
			if(dx < -maxSpeed){
				dx = -maxSpeed;
			}
		}
		else if(right){
			dx += moveSpeed;
			if(dx>maxSpeed){
				dx = maxSpeed;
			}
			
        }
        
        if( falling ){
            dy += fallSpeed;
        }
    }

<<<<<<< HEAD
    public void update( ){//updates the chicken 
=======
    public void update( ){
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345

        //update postion
        getNextPostion();
        checkTileMapCollision();
        setPosition( xtemp, ytemp );

        //check flinching
        if( flinching ){
            long elapsed = ( System.nanoTime() - flinchTimer ) / 1000000;
            if( elapsed > 400 ){
                flinching = false;
            }
        }

        //if it hits a wall, go other direction
        if( right && dx == 0 ) {
            right = false;
            left = true;
            facingRight = false;
        }
        else if( left && dx == 0 ){
            right = true;
            left = false;
            facingRight = true;
        }

        //update animation
        animation.update( );
    }

    public void draw( Graphics2D g){

        //if( notOnScreen() )
            //return;

        setMapPosition();
        super.draw( g );
    }
}