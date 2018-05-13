package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class HUD {

    private Player player;

    private BufferedImage image;
    private Font font;

<<<<<<< HEAD
    public HUD( Player p ){//constructor 

        player = p;

        try{//try to get hud image 
=======
    public HUD( Player p ){

        player = p;

        try{
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345

            image = ImageIO.read(
                getClass().getResourceAsStream( "/HUD/hud.gif" ) );
            font = new Font( "Arial", Font.PLAIN, 14 );
        }
        catch( Exception e ){

            e.printStackTrace();

        }
    }

<<<<<<< HEAD
   public void draw( Graphics2D g ){//draw the hud 

        g.drawImage( image, 0, 10, null );//set size 
        g.setFont( font );//set font 
        g.setColor( Color.BLACK );//set color 
        g.drawString( player.getHealth() + "/" + player.getMaxHealth(), 30, 25);//print health 
        g.drawString( player.getExperience() + "", 30, 45);//print experience 
=======
    public void draw( Graphics2D g ){

        g.drawImage( image, 0, 10, null );
        g.setFont( font );
        g.setColor( Color.BLACK );
        g.drawString( player.getHealth() + "/" + player.getMaxHealth(), 30, 25);
        g.drawString( player.getExperience() + "", 30, 45);
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
    }
}