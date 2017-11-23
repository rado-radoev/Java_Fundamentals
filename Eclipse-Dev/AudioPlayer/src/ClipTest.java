import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;


public class ClipTest {

	public static Mixer mixer;
	public static Clip clip;
	
	public static void main(String[] args) {
		Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
//		for (Mixer.Info info : mixInfos) {
//			System.out.println(info.getName() + "----" + info.getDescription());
//		}
		
		mixer = AudioSystem.getMixer(mixInfos[0]);
		
		DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
		
		try {
			clip = (Clip	)mixer.getLine(dataInfo);
		} catch (LineUnavailableException lue) {
			lue.printStackTrace();
		}
		
		try {
			URL soundURL = ClipTest.class.getResource("piano2.wav");
			AudioInputStream audioInputStream =
					AudioSystem.getAudioInputStream(soundURL);
			clip.open(audioInputStream);
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
		
		
		clip.start();
		
		do {
			try {
				System.out.println("Sound is playing...");
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (clip.isActive());
		
		System.out.println("Sound stopped ...");
	}
}
