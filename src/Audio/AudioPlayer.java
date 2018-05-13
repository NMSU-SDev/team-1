package Audio;
import java.io.IOException;

import javax.sound.sampled.*;
public class AudioPlayer {
	private Clip clip;
	
	public AudioPlayer(String s){
		try{
<<<<<<< HEAD
			AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(s));// get audio file as stream	
			AudioFormat baseFormat = ais.getFormat();//get the format
=======
			AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(s));
			AudioFormat baseFormat = ais.getFormat();
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
			AudioFormat decodeFormat = new AudioFormat(
					AudioFormat.Encoding.PCM_SIGNED,
					baseFormat.getSampleRate(),
					16,
					baseFormat.getChannels(),
					baseFormat.getChannels()*2,
					baseFormat.getSampleRate()
<<<<<<< HEAD
					,false);//decode the audio
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat,ais); //get decoded audio
			clip = AudioSystem.getClip();
			clip.open(dais);//open clip 
=======
					,false);
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat,ais);
			clip = AudioSystem.getClip();
			clip.open(dais);
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
		}
		catch(IOException e){
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	public void play(){//function to play clip 
=======
	public void play(){
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
		if(clip==null) return;
		stop();
		clip.setFramePosition(0);
		clip.start();
	}
<<<<<<< HEAD
	public void stop(){//stops clip 
		if(clip.isRunning()) clip.stop();
	}
	public void close(){//closes clip 
		stop();
		clip.close();
	}
}
=======
	public void stop(){
		if(clip.isRunning()) clip.stop();
	}
	public void close(){
		stop();
		clip.close();
	}
}
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
