import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.*;

public class AudioPlayer {
	private Clip clip;
	private AudioInputStream input;
	private File audioFile;
	
	public AudioPlayer(String fileName){
		audioFile = new File(fileName);
		try {
			input = AudioSystem.getAudioInputStream(audioFile);
			clip = AudioSystem.getClip();
			clip.open(input);
		} catch (UnsupportedAudioFileException e) {
			System.out.println("ERROR: UNUSABLE AUDIO FILE");
		} catch (IOException e) {
			System.out.println("ERROR:FAILED INPUT OR OUTPUT");
		} catch (LineUnavailableException e) {
			System.out.println("ERROR:LINE NONEXISTENT");
		}

	}
	
	public void playClip()
	{
		clip.start();
	}
	
	public void stopAndResetClip()
	{
		if(clip.isRunning()){
			clip.stop();
			clip.setFramePosition(0);
		}
	}

}
