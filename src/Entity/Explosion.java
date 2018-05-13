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
	
<<<<<<< HEAD
	public Explosion(int x, int y){//constructor 
=======
	public Explosion(int x, int y){
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
		this.x=x;
		this.y=y;
		
		width=30;
		height=30;;
		
<<<<<<< HEAD
		try{//try for explosion sprites 
=======
		try{
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
			
			BufferedImage spritesheet = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/Sprites/Enemies/explosion.gif"));
			
			sprites = new BufferedImage[6];
			
			for(int i=0; i < sprites.length;i++){
				sprites[i] = spritesheet.getSubimage(i*width, 0, width, height);
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
<<<<<<< HEAD
		//set sprite animation 
=======
		
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
		animation = new Animation();
		animation.setFrames(sprites);
		animation.setDelay(70);
	}
	
	public void update(){
<<<<<<< HEAD
		animation.update();//update animatoin 
		if(animation.hasPlayedOnce()){//if its been played then remove explosion 
=======
		animation.update();
		if(animation.hasPlayedOnce()){
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
			remove = true;
		}
	}
	
<<<<<<< HEAD
	public boolean shouldRemove(){return remove;}//check if should be removed 
	public void setMapPosition(int x, int y){//set the map position 
=======
	public boolean shouldRemove(){return remove;}
	public void setMapPosition(int x, int y){
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
		xmap = x;
		ymap = y;
	}
	
<<<<<<< HEAD
	public void draw(Graphics2D g){//draw explosion 
=======
	public void draw(Graphics2D g){
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
		g.drawImage(animation.getImage(), x+xmap - width/2, y+ymap - height/2, null);
		
		
	}
<<<<<<< HEAD
}
=======
}

>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
