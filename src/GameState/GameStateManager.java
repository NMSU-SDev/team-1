package GameState;

import java.util.ArrayList;

// this class takes the game state and this is where it is managed adding all the states together 
public class GameStateManager {
   
   private ArrayList<GameState> gameStates;
   private int currentState;

<<<<<<< HEAD
   // creating all the states that are used in the game
=======
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
   
   public static final int MENUSTATE = 0;
   public static final int LEVEL1STATE = 1;
   public static final int CONTROLSTATE = 2;
   public static final int DIFFICULTYSTATE = 3;
   public static final int SHOPSTATE = 4;
   public static final int RESETSTATE = 5;
   
   // sets up all the game states and puts them together the default state is the menu
   public GameStateManager( ) {
      
      gameStates = new ArrayList<GameState>( );
      currentState = MENUSTATE;
      gameStates.add(new MenuState( this ) );
      gameStates.add(new Level1State( this ));
      gameStates.add(new ControlState(this));
      gameStates.add(new DifficultyState(this));
      gameStates.add(new ShopState(this));
      gameStates.add(new ResetState(this));
     
      
   }//end constructor
   // this is the function that sets what state you want to be in from the menu
   public void setState( int state ) {
      currentState = state;
      gameStates.get( currentState ).init( );
   }
   
   public void update( ) {
      gameStates.get( currentState ).update( );
   }
   public void draw(java.awt.Graphics2D g ) {
      gameStates.get( currentState ).draw( g );
   }
   public void keyPressed( int k ){
      gameStates.get( currentState ).keyPressed( k );
   }
   public void keyReleased( int k ) {
      gameStates.get( currentState ).keyReleased( k );
   }
}
