import java.io.*;
import javax.sound.sampled.*;

public class AudioPlayer {

	private Clip clip;
	private AudioInputStream inputStream;
	private File file;

	public AudioPlayer(String filePath) {
		file = new File(filePath);
		try {
			inputStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(inputStream);
		}
		catch (UnsupportedAudioFileException exception) {
			System.out.println("ERROR : UNUSABLE AUDIO FILE");
		}
		catch (IOException exception) {
			System.out.println("ERROR : FAILED INPUT OR OUTPUT");
		}
		catch (LineUnavailableException exception) {
			System.out.println("ERROR : LINE NONEXISTENT");
		}
	}

	public void play() {
		clip.start();
	}

	public void stop() {
		if (clip.isRunning()) {
			clip.stop();
			clip.setFramePosition(0);
		}
	}

}
