package Audio;
import java.io.IOException;

import javax.sound.sampled.*;
public class AudioPlayer {
	private Clip clip;
	
	public AudioPlayer(String s){
		try{
			AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(s));
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(
					AudioFormat.Encoding.PCM_SIGNED,
					baseFormat.getSampleRate(),
					16,
					baseFormat.getChannels(),
					baseFormat.getChannels()*2,
					baseFormat.getSampleRate()
					,false);
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat,ais);
			clip = AudioSystem.getClip();
			clip.open(dais);
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
	public void play(){
		if(clip==null) return;
		stop();
		clip.setFramePosition(0);
		clip.start();
	}
	public void stop(){
		if(clip.isRunning()) clip.stop();
	}
	public void close(){
		stop();
		clip.close();
	}
}
