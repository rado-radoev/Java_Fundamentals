import java.io.*;
import java.net.*;
import javax.sound.sampled.*;

public class Producer implements Runnable {
	
	private final Buffer sharedLocation;
	private URL url;
	
	public Procuer(Buffer sharedLocation, URL url) {
		this.sharedLocation = sharedLocation;
		this.url = url;
	}
	

	@Override
	public void run() {
		try {
			AudioInputStream input = AudioSystem.getAudioInputStream(url);
			AudioFormat format = input.getFormat();
			AudioFormat pcm =
                    new AudioFormat(format.getSampleRate( ), 16,
                                    format.getChannels( ), true, false);
			
			input = AudioSystem.getAudioInputStream(pcm, input);
				
			format = input.getFormat();
			DataLine.Info dataInfo = new DataLine.Info(SourceDataLine.class, format);
			SourceDataLine sourceLine = (SourceDataLine)AudioSystem.getLine(dataInfo);
			
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

}
