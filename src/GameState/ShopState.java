package GameState;

import TileMap.Background;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
<<<<<<< HEAD
// this is the class that deals with the shop menu choices and updating currency
public class ShopState extends GameState {
	int currency=0;
   
   // declare variables such as the background to be used and the string that populates the menu
   private Background bg;
=======

public class ShopState extends GameState {
	int currency=0;
   private Background bg;
   
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
   private int currentChoice = 0;
   private String [] options = {"Damage Increase - 25", "Health Increase - 25","GOD MODE - 1000","Back to menu" };
   private Color titleColor;
   private Font titleFont;
   private Font font;
   
<<<<<<< HEAD
   // constructor that sets the background and also the fonts and colors
=======
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
   public ShopState( GameStateManager gsm ) {
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
<<<<<<< HEAD
   // draw everything to the screen 
=======
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
   public  void draw( java.awt.Graphics2D g ){
	   bg.draw(g);
	   g.setColor(titleColor);
	   g.setFont(titleFont);
	   g.drawString("Shop", 80, 70);
<<<<<<< HEAD
	   File file = new File("xp.txt");				// read the currency from the file to be used in the shop
=======
	   File file = new File("xp.txt");
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(file));
			String text = null;
			text = reader.readLine();
			currency = Integer.parseInt(text);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(reader != null){
					reader.close();
				}
			}
			catch (IOException e){
				
			}
		}
<<<<<<< HEAD
	   g.setFont(font);				// print out all the options on the screen to be selected and update currency
=======
	   g.setFont(font);
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
	   g.setColor(Color.GREEN);
	   g.drawString("Currency left - " + currency,90, 92 );
	   g.setColor(Color.BLACK);
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
<<<<<<< HEAD
   // depending on what the user selects the txt files for the appropriate bonus will be changed
   private void select(){
	   int health=0;
	   int damage=0;
	   File file = new File("xp.txt");				// any selection will decrease the currenty or xp
=======
   
   private void select(){
	   int health=0;
	   int damage=0;
	   File file = new File("xp.txt");
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(file));
			String text = null;
			text = reader.readLine();
			currency = Integer.parseInt(text);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(reader != null){
					reader.close();
				}
			}
			catch (IOException e){
				
			}
		}
		
<<<<<<< HEAD
		File file2 = new File("damage.txt");				// if bonus damage is selected then the damage.txt will be updated
=======
		File file2 = new File("damage.txt");
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
		BufferedReader reader2 = null;
		try{
			reader2 = new BufferedReader(new FileReader(file2));
			String text = "";
			text = reader2.readLine();
			damage = Integer.parseInt(text);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(reader != null){
					reader.close();
				}
			}
			catch (IOException e){
				
			}
		}
		
<<<<<<< HEAD
		File file3 = new File("health.txt");			// if bonus health is selected then update health.txt
=======
		File file3 = new File("health.txt");
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
		BufferedReader reader3 = null;
		try{
			reader3 = new BufferedReader(new FileReader(file3));
			String text = null;
			text = reader3.readLine();
			health = Integer.parseInt(text);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(reader != null){
					reader.close();
				}
			}
			catch (IOException e){
				
			}
		}
<<<<<<< HEAD
	   if(currentChoice == 0){				// ensure the player has enough xp to buy items
		   if(currency>=25){				// if damage boost was selected
=======
	   if(currentChoice == 0){
		   if(currency>=25){
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
			   System.out.println(damage);
			   damage=damage+1;
			   System.out.println(damage);
			   currency-=25;
		   }
		   BufferedWriter out = null;
			try{
<<<<<<< HEAD
				FileWriter fstream = new FileWriter("damage.txt");	// writes back to the file depending on what selection is chosen
=======
				FileWriter fstream = new FileWriter("damage.txt");
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
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
<<<<<<< HEAD
				FileWriter fstream = new FileWriter("xp.txt");		// writes back to the file depending on what selection is chosen
=======
				FileWriter fstream = new FileWriter("xp.txt");
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
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
<<<<<<< HEAD
			gsm.setState(GameStateManager.MENUSTATE);		// after any selection you are returned to the main menu
	   }
	   if(currentChoice == 1){		// if health boost was selected
=======
			gsm.setState(GameStateManager.MENUSTATE);
	   }
	   if(currentChoice == 1){
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
		   if(currency>=25){
			   health+=1;
			   currency-=25;
		   }
		   
		   
		   BufferedWriter out1 = null;
			try{
<<<<<<< HEAD
				FileWriter fstream1 = new FileWriter("health.txt");	// writes back to the file depending on what selection is chosen
=======
				FileWriter fstream1 = new FileWriter("health.txt");
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
				out1 = new BufferedWriter(fstream1);
				
				out1.write(String.valueOf(health));
			}
			catch(IOException e){
				e.printStackTrace();
			}
			finally{
				if(out1!=null){
					try{
						out1.close();
					}
					catch(IOException e){
						
					}
				}
			}
			
			BufferedWriter out2 = null;
			try{
<<<<<<< HEAD
				FileWriter fstream2 = new FileWriter("xp.txt");		// writes back to the file depending on what selection is chosen
=======
				FileWriter fstream2 = new FileWriter("xp.txt");
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
				out2 = new BufferedWriter(fstream2);
				
				out2.write(String.valueOf(currency));
			}
			catch(IOException e){
				e.printStackTrace();
			}
			finally{
				if(out2!=null){
					try{
						out2.close();
					}
					catch(IOException e){
						
					}
				}
			}
			gsm.setState(GameStateManager.MENUSTATE);
	   }
		   
	   
<<<<<<< HEAD
	   if(currentChoice == 2){		// if god mode was selected
=======
	   if(currentChoice == 2){
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
		   //store
		   if(currency>=1000){
		   damage = Integer.MAX_VALUE;
		   health = Integer.MAX_VALUE;
		   currency-=1000;
		   }
		   
		   BufferedWriter out = null;
			try{
<<<<<<< HEAD
				FileWriter fstream = new FileWriter("health.txt");		// writes back to the file depending on what selection is chosen
=======
				FileWriter fstream = new FileWriter("health.txt");
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
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
<<<<<<< HEAD
				FileWriter fstream = new FileWriter("damage.txt");		// writes back to the file depending on what selection is chosen
=======
				FileWriter fstream = new FileWriter("damage.txt");
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
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
<<<<<<< HEAD
				FileWriter fstream = new FileWriter("xp.txt");		// writes back to the file depending on what selection is chosen
=======
				FileWriter fstream = new FileWriter("xp.txt");
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
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