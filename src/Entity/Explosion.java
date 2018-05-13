package Entity;
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Explosion {
	private int x;
	private int y;
	private int xmap;
	private int ymap;
	
	private int width;
	private int height;
	
	private Animation animation;
	private BufferedImage[] sprites;
	
	private boolean remove;
	
	public Explosion(int x, int y){//constructor 
		this.x=x;
		this.y=y;
		
		width=30;
		height=30;;
		
		try{//try for explosion sprites 
			
			BufferedImage spritesheet = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/Sprites/Enemies/explosion.gif"));
			
			sprites = new BufferedImage[6];
			
			for(int i=0; i < sprites.length;i++){
				sprites[i] = spritesheet.getSubimage(i*width, 0, width, height);
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//set sprite animation 
		animation = new Animation();
		animation.setFrames(sprites);
		animation.setDelay(70);
	}
	
	public void update(){
		animation.update();//update animatoin 
		if(animation.hasPlayedOnce()){//if its been played then remove explosion 
			remove = true;
		}
	}
	
	public boolean shouldRemove(){return remove;}//check if should be removed 
	public void setMapPosition(int x, int y){//set the map position 
		xmap = x;
		ymap = y;
	}
	
	public void draw(Graphics2D g){//draw explosion 
		g.drawImage(animation.getImage(), x+xmap - width/2, y+ymap - height/2, null);
		
		
	}
}