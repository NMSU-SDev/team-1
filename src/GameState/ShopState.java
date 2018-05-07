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

public class ShopState extends GameState {
   
   private Background bg;
   
   private int currentChoice = 0;
   private String [] options = {"Damage Increase - 25", "Health Increase - 25","GOD MODE - 1000","Back to menu" };
   private Color titleColor;
   private Font titleFont;
   private Font font;
   
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
   public  void draw( java.awt.Graphics2D g ){
	   bg.draw(g);
	   g.setColor(titleColor);
	   g.setFont(titleFont);
	   g.drawString("Shop", 80, 70);
	   
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
	   int currency=0;
	   int health=0;
	   int damage=0;
	   File file = new File("xp.txt");
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
		
		File file2 = new File("damage.txt");
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
		
		File file3 = new File("health.txt");
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
	   if(currentChoice == 0){
		   if(currency>=25){
			   System.out.println(damage);
			   damage=damage+1;
			   System.out.println(damage);
			   currency-=25;
		   }
		   BufferedWriter out = null;
			try{
				FileWriter fstream = new FileWriter("damage.txt");
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
				FileWriter fstream = new FileWriter("xp.txt");
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
	   if(currentChoice == 1){
		   if(currency>=25){
			   health+=1;
			   currency-=25;
		   }
		   
		   
		   BufferedWriter out1 = null;
			try{
				FileWriter fstream1 = new FileWriter("health.txt");
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
				FileWriter fstream2 = new FileWriter("xp.txt");
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
		   
	   
	   if(currentChoice == 2){
		   //store
		   if(currency>=1000){
		   damage = Integer.MAX_VALUE;
		   health = Integer.MAX_VALUE;
		   currency-=1000;
		   }
		   
		   BufferedWriter out = null;
			try{
				FileWriter fstream = new FileWriter("health.txt");
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
				FileWriter fstream = new FileWriter("damage.txt");
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
				FileWriter fstream = new FileWriter("xp.txt");
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