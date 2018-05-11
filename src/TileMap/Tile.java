package TileMap;

import java.awt.image.BufferedImage;

//Class for individual Tiles
public class Tile {

	//image of tile and tile type
	private BufferedImage image;
	private int type;
	
	// tile types
	public static final int NORMAL = 0;
	public static final int BLOCKED = 1;
	
	//Constructor
	public Tile(BufferedImage image, int type) {
		
		//set the variables to those given
		this.image = image;
		this.type = type;
		
	}//end constructpr
	
	//Accessor for image
	public BufferedImage getImage() {
		return image;
	}//end accessor
	
	//accessor for type
	public int getType() {
		return type;
	}//end accessor
	
}//end class
