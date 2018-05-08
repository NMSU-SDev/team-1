package GameState;

import TileMap.Background;
import java.awt.*;
import java.awt.event.KeyEvent;

public class ControlState extends GameState {
   
   private Background bg;
   
   private int currentChoice = 0;
   private String [] options = {"Right Arrow - Move right","Left Arrow - Move left","Up Arrow - Jump",
		   					    "Space Bar - attack","Go Back"};
   private Color titleColor;
   private Font titleFont;
   private Font font;
   
   public ControlState( GameStateManager gsm ) {
      this.gsm = gsm;
      
      try{
    	 bg = new Background("/Backgrounds/chickenMBG.jpg",1); 
    	 bg.setVector(0,0);
    	 titleColor = new Color(0,0,0);
    	 titleFont = new Font("Helvetica", Font.PLAIN,45);
    	 font = new Font("Arial",Font.PLAIN,18);
      }
       catch(Exception e){
    	   e.printStackTrace();
       }
      
   }
   
   public void init( ){ 
   }
   public void update( ){
	   bg.update();
   }
   public  void draw( java.awt.Graphics2D g ){
	   bg.draw(g);
	   g.setColor(titleColor);
	   g.setFont(titleFont);
	   g.drawString("Controls", 80, 70);
	   
	   g.setFont(font);
	   for(int i =0; i<options.length; i++){
		   if(i == 4) {
			   currentChoice = 4;
			   g.setColor(Color.RED);
		   }
		   else {
			   g.setColor(Color.BLUE);
		   }
		   g.drawString(options[i],90,110 + i * 15);
	   }
   }
   
   private void select(){
	   if(currentChoice == 4){
		   gsm.setState(GameStateManager.MENUSTATE);
	   }
	  
   }
   
   public void keyPressed( int k ){
	   if(k == KeyEvent.VK_ENTER){
		   select();
		   
	 
	   }
   }
   public void keyReleased( int k ){
	   
   }
   
}
