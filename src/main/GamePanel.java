package main;

import javax.swing.JPanel;
import GameState.GameStateManager;
import java.awt. *;
import java.awt.image.BufferedImage;
import java.awt.event.*;

//Main driver for game 
public class GamePanel extends JPanel implements Runnable, KeyListener {

<<<<<<< HEAD
   
=======
   //Set the size of the game 
   //Can't be changed
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
   public static final int WIDTH = 320;
   public static final int HEIGHT = 240;
   public static final int SCALE = 2;
   
   //Variables needed to run the game
   private Thread thread;
   private boolean running;
   private int FPS = 60;
   private long targetTime = 1000 / FPS;
   
   private BufferedImage image;
   
   private Graphics2D g;
   private GameStateManager gsm;
   
   //Constructor for GamePanel
   public GamePanel( ) {
      
      super( );
      //Sets the size of the Game Panel
      setPreferredSize( new Dimension( WIDTH * SCALE, HEIGHT * SCALE ) );
      //Set the Game Panel to be Focusable
      setFocusable( true );
      requestFocus( );
      
   }//end constructor
   
   //addNodify
   public void addNotify( ) {
      super.addNotify( );
      if( thread == null ){
         thread = new Thread( this );
         addKeyListener( this );
         thread.start( );
      }//end if
   }//end addNotify
   
   //Initializer for Game Panel
   private void init( ) {

      //setup image
      image = new BufferedImage( WIDTH, HEIGHT,
                 BufferedImage.TYPE_INT_RGB );
      //setup g
      g = ( Graphics2D ) image.getGraphics();
        
      //set running to true
      running = true;
      //make a GameStateManger
      gsm = new GameStateManager( );
      
   }//end init
   
   //run Runs the Game
   public void run( ) {
   
      //Initialize the game
      init( );
      
      //Declare variables to check time
      long start;
      long elapsed;
      long wait;
      
      //While loop to run functions while the
      //game is running
      while( running ){
         
         //Get the start time
         start = System.nanoTime( );
         
         //Update what image to show
         update( );
         //Draw the image
         draw( );
         //draw the image to screen
         drawToScreen( );
         
         //Get how mch time has elapsed
         elapsed = System.nanoTime( ) - start;
         
         //Get how much time left until we need 
         //to update graphics
         wait = targetTime - elapsed / 1000000;
         //If the wait is less than 0 set wait to 5
         if(wait < 0) {
        	   wait = 5;
         }//end if
         //Try to put the tread to seat
         //for the wait time
         try {
            Thread.sleep( wait );
         }//end try
         catch( Exception e ) {
            e.printStackTrace( );
         }//end catch
         
      }//end while
         
   }//end run
   
   //update calls GameStateManager's 
   //update
   private void update(  ){
      gsm.update( );
   }//end update

   //draw calls GameStateManager's
   //draw
   private void draw( ) { 
      gsm.draw(g);
   }//end draw

   //Get the Graphics and draw them
   private void drawToScreen( ) { 
      //Get the graphics
      Graphics g2 = getGraphics( );
      //Draw the graphics
      g2.drawImage( image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null );
      //Get rid of g2
      g2.dispose( );
   }//end drawToScreen
   
   //keyTyped is for typing characters
   public void keyTyped( KeyEvent key ) {
  
   }//end keytyped
   
   //keyPressed gives whatever key was pressed to 
   //GameStateManger's keyPressed
   public void keyPressed( KeyEvent key ) {
      gsm.keyPressed( key.getKeyCode( ) );
   }//end keyPressed
   
   //keyReleased gives whatever key is released
   //to GameStateManager's keyReleased
   public void keyReleased( KeyEvent key ) {
      gsm.keyReleased( key.getKeyCode( ) );
   }//end keyReleased
   
}//end class