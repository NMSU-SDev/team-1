package Entity;

import java.awt.image.BufferedImage;

public class Animation {

	private BufferedImage[] frames;
	private int currentFrame;
	
	private long startTime;
	private long delay;
	
	private boolean playedOnce;
	
<<<<<<< HEAD
	public void Animation (){//constructor
=======
	public void Animation (){
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
		playedOnce = false;
		
	}
	
<<<<<<< HEAD
	public void setFrames(BufferedImage[] frames){//function to set the frames for the animation 
=======
	public void setFrames(BufferedImage[] frames){
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
		this.frames = frames;
		currentFrame = 0;
		startTime = System.nanoTime();
		playedOnce = false;
	}
	
<<<<<<< HEAD
	public void setDelay(long d) {delay = d;}//set the delay between frames 
	public void setFrame(int i) { currentFrame = i;}//set the frame 
	
	public void update (){//update the animation 
=======
	public void setDelay(long d) {delay = d;}
	public void setFrame(int i) { currentFrame = i;}
	
	public void update (){
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
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
	
<<<<<<< HEAD
	public int getFrame() {return currentFrame;}//getter for frames 
	public BufferedImage getImage() {return frames[currentFrame];}//getter for image of current frame 
	public boolean hasPlayedOnce() {return playedOnce;}//see if the animation has played 
}
=======
	public int getFrame() {return currentFrame;}
	public BufferedImage getImage() {return frames[currentFrame];}
	public boolean hasPlayedOnce() {return playedOnce;}
	
}
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
