package GameState;
import Entity.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import TileMap.Background;

<<<<<<< HEAD
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
=======
//ResetState is an option from the main menu
//in ResetState we give the option to 
//reset all stats
public class ResetState extends GameState {
	
	//Variable for Reset's background
	private Background bg;
	//Variable for which option is selected
	private int currentChoice = 0;
	//The options
	private String [] options = {"YES","NO"};
	//Variables for format of printing
	private Color titleColor;
	private Font titleFont;
	private Font font;
	//Constructor
	public ResetState( GameStateManager gsm ) {
		//make sure gsm is the right one
	   this.gsm = gsm;
		  
		//Try to set the background and formating
	   try{
	    	bg = new Background("/Backgrounds/chickenMBG.jpg",1); 
	    	bg.setVector(0,0);
	    	titleColor = new Color(0,0,0);
	    	titleFont = new Font("Helvetica", Font.PLAIN,45);
	    	font = new Font("Arial",Font.PLAIN,18);
	   }//end try
	   catch(Exception e){
	    	e.printStackTrace();
	   }//end catch
	      
	}//end constructor
	
	//Initializer for ResetState
	public void init( ){ 
	
	}//end init
	
	//Update for ResetState
	public void update( ){
		
		//update the background
		bg.update();
	
	}//end update
	
	//draw the ResetState
	public  void draw( java.awt.Graphics2D g ){
		
		//draw the background
		bg.draw(g);
		//set the options for how title 
		//should look
		g.setColor(titleColor);
		g.setFont(titleFont);
		//draw the Title
		g.drawString("Git Clucked", 50, 70);
		
		//set the font for everything else
		g.setFont(font);
		//draw the options
		//if they are selected they need to be red
		//otherwise they are blue
		for(int i =0; i<options.length; i++){
			
			//set the color
			if(i == currentChoice) {
				g.setColor(Color.RED);
			}//end if
			else {
				g.setColor(Color.BLUE);
			}//end else
			//draw the string
			g.drawString(options[i],130,110 + i * 15);
		}//end for
	}//end draw
	   
	//Check what is selected and do the 
	//required option
	private void select(){
		
		//If the first choice is chosen
      //need to reset stats and return
      //to main menu
		if(currentChoice == 0){

			//Set the default stats
			int damage = 8;
			int health = 5;
			int currency = 0;
			int difficulty = 1;
			//start up the writer
			BufferedWriter out = null;
			//try to open the health file and 
			//write the health to it
			try{
				FileWriter fstream = new FileWriter("health.txt");
				out = new BufferedWriter(fstream);
					
				out.write(String.valueOf(health));
			}//end try
			catch(IOException e){
				e.printStackTrace();
			}//end catch
			finally{
				//if out was used close it
				if(out!=null){
					try{
						out.close();
					}//end try
					catch(IOException e){
							
					}//end catch
				}//end if
			}//end finally
			
			//set out back to null
			out = null;
			//try to open damage file 
			//and write to it	
			try{
				FileWriter fstream = new FileWriter("damage.txt");
				out = new BufferedWriter(fstream);
					
				out.write(String.valueOf(damage));
			}//end try
			catch(IOException e){
				e.printStackTrace();
			}//end catch
			finally{
				//if out was used close it
				if(out!=null){
					try{
						out.close();
					}//end try
					catch(IOException e){
						
					}//end catch
				}//end if
			}//end finally
			
			//set out back to null
			out = null;
			//try to open the xp file
			//and write to it
			try{
				FileWriter fstream = new FileWriter("xp.txt");
				out = new BufferedWriter(fstream);
					
				out.write(String.valueOf(currency));
			}//end try
			catch(IOException e){
				e.printStackTrace();
			}//end catch
			finally{
				//if out was used close it
				if(out!=null){
					try{
						out.close();
					}//end try
					catch(IOException e){
						
					}//end catch
				}//end if
			}//end finally
				
			//set out back to null
			out = null;
			//try to open the diffiulty file
			//and write to it
			try{
				FileWriter fstream = new FileWriter("difficulty.txt");
				out = new BufferedWriter(fstream);
					
				out.write(String.valueOf(difficulty));
			}//end try
			catch(IOException e){
				e.printStackTrace();
			}//end catch
			finally{
				//if out was used close it
				if(out!=null){
					try{
						out.close();
					}//end try
					catch(IOException e){
							
					}//end catch
				}//end if
			}//end finally
			   
			//Go back to the main menu 
		   gsm.setState(GameStateManager.MENUSTATE);
         }//end if
         //if the second choice is selected
         //go back to the main menu
		   if(currentChoice == 1){
			   gsm.setState(GameStateManager.MENUSTATE);
		   }//end if
	   }//end select
      
      //keyPressed
	   public void keyPressed( int k ){
         //if enter is pressed select 
		   if(k == KeyEvent.VK_ENTER){
			   select();
         }//end if
         //if up is pressed the current
         //choice is the one before it
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
		   if(k == KeyEvent.VK_UP){
			   currentChoice--;
			   if(currentChoice == -1){
				   currentChoice = options.length - 1;
<<<<<<< HEAD
			   }
		   }
=======
			   }//end if
         }//end if
         //if down is pressed the current
         //choice is the one after is
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
		   if(k == KeyEvent.VK_DOWN){
			   currentChoice++;
			   if(currentChoice == options.length){
				   currentChoice = 0;
<<<<<<< HEAD
			   }
		   }
	   }
	   public void keyReleased( int k ){
		   
	   }
	   

}
=======
			   }//end if
		   }//end if
      }//end keyPressed
      
      //keyReleased
	   public void keyReleased( int k ){
		   
	   }//end keyReleased
	   

}//end ResetState
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
