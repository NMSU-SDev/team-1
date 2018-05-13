package Entity;

import java.awt.image.BufferedImage;

public class Animation {

	private BufferedImage[] frames;
	private int currentFrame;
	
	private long startTime;
	private long delay;
	
	private boolean playedOnce;
	
	public void Animation (){//constructor
		playedOnce = false;
		
	}
	
	public void setFrames(BufferedImage[] frames){//function to set the frames for the animation 
		this.frames = frames;
		currentFrame = 0;
		startTime = System.nanoTime();
		playedOnce = false;
	}
	
	public void setDelay(long d) {delay = d;}//set the delay between frames 
	public void setFrame(int i) { currentFrame = i;}//set the frame 
	
	public void update (){//update the animation 
		if(delay == -1 ) return;
		
		long elapsed = (System.nanoTime()-startTime)/1000000;
		if(elapsed > delay){
			currentFrame++;
			startTime = System.nanoTime();
		}
		if(currentFrame == frames.length) {
			currentFrame = 0;
			playedOnce = true;
		}
	}
	
	public int getFrame() {return currentFrame;}//getter for frames 
	public BufferedImage getImage() {return frames[currentFrame];}//getter for image of current frame 
	public boolean hasPlayedOnce() {return playedOnce;}//see if the animation has played 
}