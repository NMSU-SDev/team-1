package GameState;
import Entity.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import TileMap.Background;

public class ResetState extends GameState {
	   // Set up variables to be used such as the background and font color type and the text to be printed
	
	   private Background bg;  
	   private int currentChoice = 0;
	   private String [] options = {"YES","NO"};
	   private Color titleColor;
	   private Font titleFont;
	   private Font font;
	   
	   // constructor that sets everything up
	   public ResetState( GameStateManager gsm ) {
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
	   
	   // draw everything to the screen like the selections in the font and color selected
	   public  void draw( java.awt.Graphics2D g ){
		   bg.draw(g);
		   g.setColor(titleColor);
		   g.setFont(titleFont);
		   g.drawString("Git Clucked", 50, 70);
		   
		   g.setFont(font);
		   for(int i =0; i<options.length; i++){
			   if(i == currentChoice) {
				   g.setColor(Color.RED);
			   }
			   else {
				   g.setColor(Color.BLUE);
			   }
			   g.drawString(options[i],130,110 + i * 15);
		   }
	   }
	   // selection has a special job if yes is selected it should place the default values in all the text documents
	   private void select(){
		   if(currentChoice == 0){
			   int damage = 8;
			   int health = 5;
			   int currency = 0;
			   int difficulty = 1;
			   BufferedWriter out = null;
				try{
					FileWriter fstream = new FileWriter("health.txt");		// reset health back to its default of 5
					out = new BufferedWriter(fstream);
					
					out.write(String.valueOf(health));
				}
				catch(IOException e){
					e.printStackTrace();
				}
				finally{
					if(out!=null){
						try{
							out.close();
						}
						catch(IOException e){
							
						}
					}
				}
				
				 out = null;
				try{
					FileWriter fstream = new FileWriter("damage.txt");		// reset the damage to its default value of 8
					out = new BufferedWriter(fstream);
					
					out.write(String.valueOf(damage));
				}
				catch(IOException e){
					e.printStackTrace();
				}
				finally{
					if(out!=null){
						try{
							out.close();
						}
						catch(IOException e){
							
						}
					}
				}
				
				out = null;
				try{
					FileWriter fstream = new FileWriter("xp.txt");		// reset xp back to 0
					out = new BufferedWriter(fstream);
					
					out.write(String.valueOf(currency));
				}
				catch(IOException e){
					e.printStackTrace();
				}
				finally{
					if(out!=null){
						try{
							out.close();
						}
						catch(IOException e){
							
						}
					}
				}
				
				out = null;
				try{
					FileWriter fstream = new FileWriter("difficulty.txt");			// reset difficulty back to 1
					out = new BufferedWriter(fstream);
					
					out.write(String.valueOf(difficulty));
				}
				catch(IOException e){
					e.printStackTrace();
				}
				finally{
					if(out!=null){
						try{
							out.close();
						}
						catch(IOException e){
							
						}
					}
				}
			   
			   
			   gsm.setState(GameStateManager.MENUSTATE);		// whatever option is selected will return to menu state
		   }
		   if(currentChoice == 1){
			   gsm.setState(GameStateManager.MENUSTATE);
		   }
	   }
	   
	   public void keyPressed( int k ){
		   if(k == KeyEvent.VK_ENTER){
			   select();
		   }
		   if(k == KeyEvent.VK_UP){
			   currentChoice--;
			   if(currentChoice == -1){
				   currentChoice = options.length - 1;
			   }
		   }
		   if(k == KeyEvent.VK_DOWN){
			   currentChoice++;
			   if(currentChoice == options.length){
				   currentChoice = 0;
			   }
		   }
	   }
	   public void keyReleased( int k ){
		   
	   }
	   

}
