package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class HUD {

    private Player player;

    private BufferedImage image;
    private Font font;

    public HUD( Player p ){//constructor 

        player = p;

        try{//try to get hud image 

            image = ImageIO.read(
                getClass().getResourceAsStream( "/HUD/hud.gif" ) );
            font = new Font( "Arial", Font.PLAIN, 14 );
        }
        catch( Exception e ){

            e.printStackTrace();

        }
    }

   public void draw( Graphics2D g ){//draw the hud 

        g.drawImage( image, 0, 10, null );//set size 
        g.setFont( font );//set font 
        g.setColor( Color.BLACK );//set color 
        g.drawString( player.getHealth() + "/" + player.getMaxHealth(), 30, 25);//print health 
        g.drawString( player.getExperience() + "", 30, 45);//print experience 
    }
}