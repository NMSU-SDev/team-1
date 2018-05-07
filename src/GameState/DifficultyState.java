package GameState;

import TileMap.Background;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class DifficultyState extends GameState {
	
   private Background bg;
   
   private int currentChoice = 0;
   private String [] options = {"Easy Peasy","Mediocracy is best", "You're Crazy","Go back"};
   private Color titleColor;
   private Font titleFont;
   private Font font;
   
   public DifficultyState( GameStateManager gsm ) {
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
	   g.drawString("Difficulty", 80, 70);
	   
	   g.setFont(font);
	   for(int i =0; i<options.length; i++){
		   if(i == currentChoice) {
			   g.setColor(Color.RED);
		   }
		   else {
			   g.setColor(Color.BLUE);
		   }
		   g.drawString(options[i],90,110 + i * 15);
	   }
   }
   
   private void select(){
	   int difficulty = 1; 
	   
	   if(currentChoice == 0){
		   difficulty = 1;
		   BufferedWriter out = null;
			try{
				FileWriter fstream = new FileWriter("difficulty.txt");
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
		   gsm.setState(GameStateManager.MENUSTATE);
	   }
	   if(currentChoice == 1){
		   difficulty = 2;
		   
		   BufferedWriter out = null;
			try{
				FileWriter fstream = new FileWriter("difficulty.txt");
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
		   gsm.setState(GameStateManager.MENUSTATE);
	   }
	   if(currentChoice == 2){
		   difficulty = 3;
		   
		   BufferedWriter out = null;
			try{
				FileWriter fstream = new FileWriter("difficulty.txt");
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
		   gsm.setState(GameStateManager.MENUSTATE);
	   }
	   if(currentChoice == 3){
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
