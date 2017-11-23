import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
 
import static javax.sound.sampled.AudioSystem.getAudioInputStream;
import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;

public class AudioPlayerTest1 {

	public static void main(String[] args) {
		
		final AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
				44100, 16, 2, 4, 44100, false);
		
		try {
			final URL url = new URL("http://stream.metacast.eu/nrj.ogg");
			
			DataLine.Info sourceInfo = new DataLine.Info(SourceDataLine.class, format);
			final SourceDataLine sourceLine = (SourceDataLine)AudioSystem.getLine(sourceInfo);
			sourceLine.open();
			
			DataLine.Info targetInfo = new DataLine.Info(TargetDataLine.class, format);
			final TargetDataLine targetLine = (TargetDataLine)AudioSystem.getLine(targetInfo);
			targetLine.open();
			
			final ByteArrayOutputStream out = new ByteArrayOutputStream();
			
			
			Thread sourceThread = new Thread() {
				@Override
				public void run() {
					sourceLine.start();
					while (true) {
						sourceLine.write(out.toByteArray(), 0, out.size());
					}
				}
			};
			
			Thread targetThread = new Thread() {
			
				@Override
				public void run() {
					try {
						AudioInputStream audioStream = getAudioInputStream(url);
						targetLine.start();
						byte[] data = new byte[targetLine.getBufferSize() / 5];
						int readBytes;
						for (int n = 0; n != -1; n = audioStream.read(data, 0, data.length)) {
							readBytes = targetLine.read(data, 0, data.length);
							out.write(data, 0, readBytes);
						}
						} catch (UnsupportedAudioFileException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			};
			
			targetThread.start();
			System.out.println("Started recording ...");
			Thread.sleep(10000);
			targetLine.stop();
			targetLine.close();
			
			System.out.println("Ended recording ...");
			System.out.println("Starting playback ...");
			
			sourceThread.start();
			Thread.sleep(10000);
			sourceLine.stop();
			sourceLine.close();
			System.out.println("Ended playback ...");
			
		} catch (MalformedURLException | LineUnavailableException | InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
}
