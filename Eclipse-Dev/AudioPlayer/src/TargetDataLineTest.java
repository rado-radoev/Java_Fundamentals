import javax.sound.sampled.AudioFormat;;

public class TargetDataLineTest {

	public static void main(String[] args) {
		System.out.println("Starting sound test ...");
		
		
		AudioFormat format = new AudioFormat(
				AudioFormat.Encoding.PCM_SIGNED,
				44100,
				16,
				4,
				2,
				44100,
				false);
	}
}
