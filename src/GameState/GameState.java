package GameState;


// This class is the main driver for all the states in the game it links together the necessary classes
// for the game to run properly
public abstract class GameState{
	   
	   protected GameStateManager gsm;
	   
	   
	   public abstract void init( );
	   public abstract void update( );
	   public abstract void draw( java.awt.Graphics2D g );
	   public abstract void keyPressed( int k );
	   public abstract void keyReleased( int k );

	}
