package Entity;

import java.awt.Rectangle;

import TileMap.Tile;
import TileMap.TileMap;
import main.GamePanel;

public abstract class MapObject {

	protected TileMap tileMap;
	protected int tileSize;
	protected double xmap;
	protected double ymap;
	
	
	
	protected double x;
	protected double y;
	protected double dx;
	protected double dy;
	
	protected int width;
	protected int height;
	
	protected int cwidth;
	protected int cheight;
	
	//collision
	protected int currRow;
	protected int currCol;
	protected double xdest;
	protected double ydest;
	protected double xtemp;
	protected double ytemp;
	protected boolean topLeft;
	protected boolean topRight;
	protected boolean bottomLeft;
	protected boolean bottomRight;
	
	
	//animation
	protected Animation animation;
	protected int currentAction;
	protected int previousAction;
	protected boolean facingRight;
	
	//movement
	protected boolean left;
	protected boolean right;
	protected boolean up;
	protected boolean down;
	protected boolean jumping;
	protected boolean falling;

	//movement attribute 
	protected double moveSpeed;
	protected double maxSpeed;
	protected double stopSpeed;
	protected double fallSpeed;
	protected double maxFallSpeed;
	protected double jumpStart;
	protected double stopJumpSpeed;
	
	public MapObject (TileMap tm) {//constructor 
		tileMap = tm;
		tileSize = tm.getTileSize();
	}
	
	public boolean intersects(MapObject o){//check if 2 objects intersect 
		Rectangle r1 = getRectangle();
		Rectangle r2 = o.getRectangle();	
		return r1.intersects(r2);
	}
	
	public Rectangle getRectangle(){//get location of object 
		return new Rectangle((int)x-cwidth,(int)y-cheight,cwidth,cheight);
	}
	
	public void calculateCorners(double x, double y){//calculate corners of object 
		int leftTile = (int) (x - cwidth/2) / tileSize;
		int rightTile = (int) (x+ cwidth/2-1)/ tileSize;
		int topTile = (int) (y - cheight /2)/tileSize;
		int bottomTile = (int) (y + cheight /2-1)/tileSize;
	
		int tl = tileMap.getType(topTile, leftTile);
		int tr = tileMap.getType(topTile, rightTile);
		int bl = tileMap.getType(bottomTile,leftTile);
		int br = tileMap.getType(bottomTile, rightTile);
		
		topLeft = tl == Tile.BLOCKED;
		topRight = tr == Tile.BLOCKED;
		bottomLeft = bl == Tile.BLOCKED;
		bottomRight = br == Tile.BLOCKED;
				
		
	}
	
	
	public void checkTileMapCollision(){//check if colliding with the map 
		currCol = (int) x / tileSize;
		currRow = (int) y/ tileSize;
		
		xdest = x + dx;
		ydest = y + dy;
		
		xtemp = x;
		ytemp = y;
		
		calculateCorners(x,ydest);
		if(dy<0){
			if(topLeft || topRight){
				dy = 0;
				ytemp = currRow * tileSize + cheight /2;
			}
			else{
				ytemp += dy;
			}
		}
		if(dy>0){
			if(bottomLeft || bottomRight){
				dy =0;
				falling = false;
				ytemp = (currRow +1) * tileSize - cheight / 2;
			}
			else {
				ytemp += dy;
			}
		}
		
		calculateCorners(xdest,y);
		if(dx<0){
			if(topLeft || bottomLeft){
				dx = 0;
				xtemp = currCol * tileSize + cwidth /2;
			}
			else{
				xtemp += dx;
			}
		}
		if(dx>0){
			if(topRight || bottomRight){
				dx =0;
				xtemp = (currCol +1) * tileSize - cwidth / 2;
			}
			else {
				xtemp += dx;
			}

		}		
		if(!falling){
			calculateCorners(x,ydest +1);
			if(!bottomLeft && !bottomRight){
				falling = true;
			}
		}
	
	}
	
	public int getx(){//getter for x 
		return (int) x;
	}
	
	public int gety(){//getter for y 
		return (int) y;
	}
	public int getWidth(){//getter for width 
		return width;
	}
	public int getHeight(){//getter for height 
		return height;
	}
	public int getCWidth(){//getter for cwidth 
		return cwidth;
	}
	public int getCHeight(){//getter for cheight 
		return cheight;
	}

	public void setPosition(double x, double y){//set the position of the object 
		this.x = x;
		this.y = y;
	}

	public void setVector(double dx, double dy){//set direction and speed 
		this.dx = dx;
		this.dy = dy;
	}

	public void setMapPosition(){//set position on map 
		xmap = tileMap.getx();
		ymap = tileMap.gety();
	}

	public void setLeft(boolean b){ left = b;}//if facing left 
	public void setRight(boolean b){right = b;}//if facing right 
	public void setUp(boolean b){ up = b;}//going up 
	public void setDown(boolean b){ down = b;}//falling 
	public void setJumping(boolean b){ jumping = b;}//jumping 

	public boolean notOnScreen(){//if not on screen 
		return x + xmap + width < 0 || x + xmap - width > GamePanel.WIDTH ||
			   y + ymap + height < 0 || y + ymap - height > GamePanel.HEIGHT;
	}
}