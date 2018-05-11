package TileMap;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

import Entity.Player;
import main.GamePanel;

//Class for TileMap
public class TileMap {
	
	// position
	private double x;
	private double y;
	
	// boundaries
	private int xmin;
	private int ymin;
	private int xmax;
	private int ymax;
	
	private double tween;
	
	//map description
	private int [] [] map;
	private int tileSize;
	private int numRows;
	private int numCols;
	private int width;
	private int height;
	
	// tile set
	private BufferedImage tileset;
	private int numTilesAcross;
	private Tile [] [] tiles;
	
	// drawing
	private int rowOffset;
	private int colOffset;
	private int numRowsToDraw;
	private int numColsToDraw;
	
	// constructor
	public TileMap(int tileSize){
		this.tileSize = tileSize;
		numRowsToDraw = GamePanel.HEIGHT / tileSize + 2;
		numColsToDraw = GamePanel.WIDTH / tileSize + 2;
		tween = 0.07;
	}//end constructor
	
	//loadTiles based on given string
	public void loadTiles(String s){
      
      //try to load the tile set and 
      //set the variables 
		try {
			
			tileset = ImageIO.read(getClass().getResourceAsStream(s));
			numTilesAcross = tileset.getWidth() / tileSize;
			tiles = new Tile[2][numTilesAcross];
			//Create temp Buffered Image to load Tiles
			BufferedImage subimage;
			for (int col =  0; col < numTilesAcross; col++){
				subimage = tileset.getSubimage(col * tileSize,0, tileSize,tileSize);
				tiles [0] [col] = new Tile(subimage,Tile.NORMAL);
				subimage = tileset.getSubimage(col * tileSize, tileSize,tileSize, tileSize);
				tiles [1] [col] = new Tile(subimage,Tile.BLOCKED); 
			}//end for
		}//end try
		catch (Exception e) {
			e.printStackTrace();
		}//end catch
	}//end loadTiles
   
   //loadMap from given String
	public void loadMap(String s) {
      
      //try to load the map and set the 
      //needed variables
		try{
			
			InputStream in = getClass().getResourceAsStream(s) ;
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			numCols = Integer.parseInt(br.readLine());
			numRows = Integer.parseInt(br.readLine());
			map = new int [numRows] [numCols];
			width = numCols * tileSize;
			height = numRows * tileSize;
         
         //min is the GamePanel's width minus the 
         //width of the tiles
			xmin= GamePanel.WIDTH-width;
         xmax = 0;
         //min is the GamePanel's height minus the 
         //height of the tiles
			ymin = GamePanel.HEIGHT - height;
			ymax = 0;
			
			//set delim for where to break up the string
         String delims = "\\s+";
         //Go through all the rows
			for(int row = 0; row < numRows; row++) {
            //read the line from the Reader
            String line = br.readLine();
            //split the line based on the delim
            String [] tokens = line.split(delims);
            //load the map with each token broken from 
            //the line
				for(int col = 0; col < numCols; col++) {
					map [row] [ col ] = Integer.parseInt( tokens[ col ] );
               
				}//end for
			}//end for
			
		}//end try
		catch (Exception e) {
			e.printStackTrace();
		}//end catch
	}//end loadMap
   
   //accessor for Tile Size
   public int getTileSize( ) {
      return tileSize;
   }//end accessor
   
   //accessor for x
   public double getx( ) {
      return x;
   }//end accessor
   
   //accessor for y
   public double gety( ) {
      return  y;
   }//end accessor
   
   //accessor for Width
   public int getWidth( ) {
      return width;
   }//end accessor
   
   //accessor for height
   public int getHeight( ) {
      return height;
   }//end accessor
   
   //accessor fot Type
   public int getType( int row, int col ) {
      //load variables from the map
      //get the number of tiles to given one
      //return the type of the tile at the loacation
      try{
        	int rc = map[ row ] [ col ];
        	int r = rc / numTilesAcross;
         int c = rc % numTilesAcross;
         return tiles[ r ][ c ].getType( );
      }//end try
      //if exeception loading tile doesn't exist
      //kill the character because something fell off the map
      catch( Exception e ){
        	Player.dead = true;
      }//end catch
      //return 1 only if execption thrown
      return 1;
           
	}//end accessor
   
   //Mutator for Tween
	public void setTween( double d ){

		tween = d;

	}//end mutator
   
   //setPosition take x and y set globals based on 
   //the given
   public void setPosition( double x, double y ) {
            
      this.x += ( x - this.x ) * tween;
      this.y += ( y - this.y ) * tween;
      
      //ensure x and y aren't out of bounds
      fixBounds( );
            
      colOffset = ( int ) -this.x / tileSize;
      rowOffset = ( int ) -this.y / tileSize;
   
   }//end setPosition
   
   //check if x and y are out of bounds
   //if they are set them to max or min
   //depending on which way out of bounds they are
   private void fixBounds( ) {
            
      if( x < xmin )
         x = xmin;
      if( y < ymin )
         y = ymin;
      if( x > xmax )
         x = xmax;
      if( y > ymax )
         y = ymax;
         
   }//end fix bounds
   
   
   //draw the map
   public void draw( Graphics2D g ) {
      
      //Go through all the rows
      for( int row = rowOffset; row < rowOffset + numRowsToDraw; row++ ) {
         //if we get to the number of rows total break out
         if(row >= numRows)
            break;
         //Go throug all the col
         for( int col = colOffset; col < colOffset + numColsToDraw; col++ ) {
            //if we get to the number of cols total break out
            if( col >= numCols )
               break;
            //If it's 0 nothing to draw
            if( map[ row ][ col] == 0 )
               continue;
            //load r and c from the map
            int rc = map[ row ] [ col ];
            int r = rc / numTilesAcross;
            int c = rc % numTilesAcross;
            //draw the tile
            g.drawImage( tiles[ r ][ c ].getImage( ),( int ) x + col * tileSize, 
                     ( int ) y + row * tileSize, null );
         }//end for
      }//end for
   }//end draw
}//end class