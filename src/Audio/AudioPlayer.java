package Audio;
import java.io.IOException;

import javax.sound.sampled.*;
public class AudioPlayer {
	private Clip clip;
	
	public AudioPlayer(String s){
		try{
			AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(s));// get audio file as stream	
			AudioFormat baseFormat = ais.getFormat();//get the format
			AudioFormat decodeFormat = new AudioFormat(
					AudioFormat.Encoding.PCM_SIGNED,
					baseFormat.getSampleRate(),
					16,
					baseFormat.getChannels(),
					baseFormat.getChannels()*2,
					baseFormat.getSampleRate()
					,false);//decode the audio
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat,ais); //get decoded audio
			clip = AudioSystem.getClip();
			clip.open(dais);//open clip 
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
	public void play(){//function to play clip 
		if(clip==null) return;
		stop();
		clip.setFramePosition(0);
		clip.start();
	}
	public void stop(){//stops clip 
		if(clip.isRunning()) clip.stop();
	}
	public void close(){//closes clip 
		stop();
		clip.close();
	}
}