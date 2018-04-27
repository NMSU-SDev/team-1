package Entity;

import TileMap.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends MapObject {
	
	//player stuff
	private int health;
	private int maxHealth;
	private int experience;
	private int punch;
	private int maxpunch;
	private boolean dead;
	private boolean flinching;
	private long flinchTimer;
	
	//attacks
	private boolean punching;
	private int punchRange;
	private int punchDamage;
	
	// animations
	private ArrayList<BufferedImage[]> sprites;
	private final int[] numFrames = {2,8,1,2,4,2,5};
	
	// animation actions
	private static final int IDLE = 0;
	private static final int WALKING = 1;
	private static final int JUMPING = 2;		
	private static final int FALLING = 3;
	private static final int PUNCHING = 4;
	
	
	public Player(TileMap tm){
		super(tm);
		
		width = 30;
		height = 30;
		cwidth = 20;
		cheight = 20;
		
		moveSpeed = .5;
		maxSpeed = 3;
		stopSpeed = .4;
		fallSpeed = .15;
		maxFallSpeed = 4.0;
		jumpStart = -8;
		stopJumpSpeed = .3;
		
		facingRight = true;
		
		health = maxHealth = 5;
		experience = 0;
		punchDamage = 8;
		punchRange = 40;
		
		// load sprites
		try{
			BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream(
					"/Sprites/Player/playersprites.gif"));
			sprites = new ArrayList<BufferedImage[]>();
			for (int i = 0 ;i <7;i++){
				BufferedImage[] bi = new BufferedImage[numFrames[i]];
				
				for(int j =0; j < numFrames[i]; j++){
					if(i != 4){
						bi[j] = spritesheet.getSubimage(j*width,i*height, width, height);
				
					}
					else {
						bi[j] = spritesheet.getSubimage(j*width * 2,i*height, width, height);
					}
				}
				sprites.add(bi);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		animation = new Animation();
		currentAction = IDLE;
		animation.setFrames(sprites.get(IDLE));
		animation.setDelay(400);
		
	}	// end constructor
	
	
	
	public int getHealth() {return health;}
	public int getMaxHealth() {return maxHealth;}
	public int getExperience( ){
		return experience;
	}
	public void setDamage( int d ){
		punchDamage += d;
	}
	public void setHealth( int h ){
		health +=h;
	}
	public void setExperience( int e ){
		experience = e;
	}
	public void incrXP( ){
		experience += 1;
	}
	public void setPunching(){
		punching = true;
	}
	public void decrXP( int d ){
		experience -= d;
	}
public void checkAttack(ArrayList<Enemy> enemies){
		
		for(int i =0; i < enemies.size(); i++){
			Enemy e = enemies.get(i);
		
		//check punch
		
		if(punching){
			if(facingRight){
					if(e.getx() > x && e.getx() < x + punchRange && e.gety() > y - height/2 && e.gety() < y + height/2){
						e.hit(punchDamage);
					}
			}
			else{
					if(e.getx()<x && e.getx() > x-punchRange && e.gety()>y - height/2 && e.gety() < y + height/2){
						e.hit(punchDamage);
					}
			}
		
			
			//check enemy collision
			
		}
		if(intersects(e)){
			hit(e.getDamage());
		}
	}
}

public void hit(int damage){
	if(flinching)return;
	health -= damage;
	if(health<0) health = 0;
	if(health==0) dead = true;
	flinching = true;
	flinchTimer = System.nanoTime();
}

	private void getNextPosition(){
		//movement
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
	
		else {
			if(dx > 0) {
				dx -= stopSpeed;
				if(dx<0){
					dx = 0;
				}
			}
			else if(dx<0){
				dx += stopSpeed;
				if(dx >0){
					dx = 0;
				}
			}
		}
	
	// cannot move while attacking, except in air
		if((currentAction == PUNCHING) && !(jumping || falling)){
			dx =0;
		}
	
	//jumping
		if(jumping && !falling) {
			dy = jumpStart;
			falling = true;
		}
	
		//falling
		if(falling){
			dy += fallSpeed;
			
			if(dy < 0) jumping = false;
			if(dy < 0 && !jumping) dy += stopJumpSpeed;
			if(dy > maxFallSpeed) dy = maxFallSpeed;
		}
	}
	
	public void update(){
		// update position
		getNextPosition();
		checkTileMapCollision();
		setPosition(xtemp,ytemp);
		if(currentAction == PUNCHING){
			if(animation.hasPlayedOnce()) punching = false;
		}
		
		//check flinching
		
		if(flinching){
			long elapsed = (System.nanoTime()- flinchTimer / 1000000);
			if(elapsed > 1000){
				flinching = false;
			}
		}
		
		//set animation
		if(punching){
			if(currentAction != PUNCHING){
				currentAction = PUNCHING;
				animation.setFrames(sprites.get(PUNCHING));
				animation.setDelay(50);
				width = 60;
			}
		}
		else if (currentAction != FALLING){
			currentAction = FALLING;
			animation.setFrames(sprites.get(FALLING));
			animation.setDelay(100);
			width = 30;
					
				
			}
		
		else if (left || right){
			if(currentAction != WALKING){
				currentAction = WALKING;
				animation.setFrames(sprites.get(WALKING));
				animation.setDelay(40);
				width = 30;
			}
		}
		else {
			if(currentAction != IDLE){
				currentAction = IDLE;
				animation.setFrames(sprites.get(IDLE));
				animation.setDelay(400);
				width = 30;
			}
		}
	
		animation.update();
		
		//set direction
		 if (currentAction != PUNCHING){
			 if(right) facingRight = true;
			 if(left) facingRight = false;
		 }
		
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
