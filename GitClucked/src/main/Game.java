package main;

import javax.swing.JFrame;

public class Game {

   public static void main( String args[ ] ) {
      
      JFrame window = new JFrame( "" );
      window.setContentPane( new GamePanel( ) );
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      window.setVisible( true );
      window.pack( );
      window.setResizable( false );
      window.setLocationRelativeTo( null );
      
   }//end main
}//end class
      
