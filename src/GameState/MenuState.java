package GameState;

import TileMap.Background;
import java.awt.*;
import java.awt.event.KeyEvent;
// default state for the game controls navigation to the other states
public class MenuState extends GameState {
   
   private Background bg;		// uses same background class
   
   private int currentChoice = 0;
   private String [] options = {"Start", "Difficulty","Store","Controls","Reset","Quit"};
   private Color titleColor;
   private Font titleFont;
   private Font font;
   
   // sets up all the fonts and background to be used
   public MenuState( GameStateManager gsm ) {
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
   // draws items to the screen
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
   // this is where the user will select which state they want to navigate to from the main menu
   private void select(){
	   if(currentChoice == 0){
		   gsm.setState(GameStateManager.LEVEL1STATE);
	   }
	   if(currentChoice == 1){
		   gsm.setState(GameStateManager.DIFFICULTYSTATE);
	   }
	   if(currentChoice == 2){
		   gsm.setState(GameStateManager.SHOPSTATE);
	   }
	   if(currentChoice == 3){
		   //controls
		   gsm.setState(GameStateManager.CONTROLSTATE);
	   }
	   if(currentChoice == 4){
		   gsm.setState(GameStateManager.RESETSTATE);
	   }
	   if(currentChoice == 5){
		   System.exit(0);
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