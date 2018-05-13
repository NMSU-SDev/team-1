package TileMap;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import main.GamePanel;

//Background image
public class Background {
   
   //Variable needed for image
   private BufferedImage image;
   
   //Variables needed to draw
   private double x;
   private double y;
   private double dx;
   private double dy;
   private double moveScale;
   
   //Constructor
   public Background(String s, double ms){
      //try to load image from it's name
      //and set the moveScale
      try{
         image = ImageIO.read(getClass().getResourceAsStream(s));
         moveScale = ms;
      }//end try
      catch(Exception e){
    	  e.printStackTrace();
      }//end catch
   }//end constructor
   
   //setPosition set's the class x and y based on
   //the position given times however much it's moving
   //modulus the width and height to set it on the 
   //screen right
   public void setPosition (double x, double y){
	   this.x = (x * moveScale) % GamePanel.WIDTH;
	   this.y = (y * moveScale) % GamePanel.HEIGHT;
   }//end setPosition

   //setVector set's the class vector based on given vector
   public void setVector (double dx, double dy){
	   this.dx = dx;
	   this.dy = dy;
   }//end setVector
   
   //update x and y by adding the vector to them
   public void update(){
	   x = x + dx;
	   y = y + dy;
   }//end update

   //draw the background
   public void draw(Graphics2D  g) {
      //draw the image
      g.drawImage(image,(int)x,(int)y,null);
      //if x is less than 0 add the constant Width
	   if(x<0){
		   g.drawImage(image, (int)x + GamePanel.WIDTH, (int)y, null);
      }//end if
      //if x is greater than 0 subtract the constant Width
	   if(x>0){
		   g.drawImage(image, (int)x - GamePanel.WIDTH, (int)y, null);
	   }//end if  
   }//end draw
}//end class