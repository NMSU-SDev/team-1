package GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import TileMap.Background;
import TileMap.TileMap;
import main.GamePanel;
import Entity.*;
import Entity.Enemies.Slugger;
public class Level1State extends GameState {

	private TileMap tileMap;
	private Background bg;
	
	private Player player;
	

	private ArrayList<Enemy> enemies; 
	private ArrayList<Explosion> explosions;

	private HUD hud;
	
	public Level1State(GameStateManager gsm){
		
		this.gsm = gsm;
		init();
	}
	
	public void init( ) {
	  tileMap = new TileMap( 30 );
      tileMap.loadTiles( "/Tilesets/grasstileset.gif" );
      tileMap.loadMap( "/Maps/level1-1.map" );
	  tileMap.setPosition( 0, 0 );
	  tileMap.setTween( 1 );
      
      bg = new Background ("/Backgrounds/grassbg1.gif",1 );
      
      player = new Player(tileMap);
      player.setPosition(100,200);
      
	  populateEnemies();
	  
	  explosions = new ArrayList <Explosion>();
	  
	  hud = new HUD( player );
	}
	
	private void populateEnemies(){
		enemies = new ArrayList<Enemy>();
		
		Slugger s;
		Point[] points = new Point[] {
			new Point(200,200),
			new Point(860,200),
			new Point(1525, 200),
			new Point(1680,200),
			new Point(1800, 200)};
		for(int i = 0; i < points.length; i++){
			s = new Slugger(tileMap);
			s.setPosition(points[ i ].x ,points[ i ].y);
			enemies.add(s);
		}
		
	}
	
	
	public void update( ) {
		player.update();
		tileMap.setPosition( GamePanel.WIDTH / 2 - player.getx( ),
			                 GamePanel.HEIGHT / 2 - player.gety( ));
		
		//set background 
		bg.setPosition( tileMap.getx( ), tileMap.gety( ));
		
		player.checkAttack(enemies);
		Enemy e;
		//update all enemies
		for( int i = 0; i < enemies.size( ); i++ ) {
			e = enemies.get(i);
			e.update();
			if(e.isDead()){
				player.incrXP( );
				enemies.remove(i);
				i--;
				explosions.add(new Explosion (e.getx(),e.gety()));
			}
		}
		
		//update explosoins
		for(int i =0;i<explosions.size();i++){
			explosions.get(i).update();
			if(explosions.get(i).shouldRemove()){
				explosions.remove(i);
				i--;
			}
		}
		
	}
	public void draw(Graphics2D g ) {
		
      //clear screen
	  bg.draw(g);
	  
      
      //draw tilemap
      tileMap.draw( g );
      
      player.draw(g);
	 
	  //draw enemies
	  for( int i = 0; i < enemies.size( ); i++ )
		enemies.get( i ).draw( g );
	  
	  //draw hud
	  hud.draw( g );
	}
	public void keyPressed( int k ) {
		if(k == KeyEvent.VK_LEFT) player.setLeft(true);
		if(k == KeyEvent.VK_RIGHT) player.setRight(true);
		if(k == KeyEvent.VK_UP) player.setJumping(true);
		if(k == KeyEvent.VK_DOWN) player.setDown(true);
		if(k == KeyEvent.VK_SPACE) player.setPunching();
		
		
	}
	public void keyReleased( int k ) {
		if(k == KeyEvent.VK_LEFT) player.setLeft(false);
		if(k == KeyEvent.VK_RIGHT) player.setRight(false);
		if(k == KeyEvent.VK_UP) player.setJumping(false);
		if(k == KeyEvent.VK_DOWN) player.setDown(false);
	}
}