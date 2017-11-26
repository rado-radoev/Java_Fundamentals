
import java.io.*;
import java.net.*;
import javax.sound.sampled.*;

public class AudioPlayer4 {

	private static URL url;
	
	
	public static void main(String[] args) {
		try {
			url = new URL("http://stream.metacast.eu/nrj.ogg");
			streamAudio(url);
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public static void streamAudio(URL url) 
			throws IOException, UnsupportedAudioFileException,
				LineUnavailableException {
		
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
			sourceLine.open(format);
			sourceLine.start();
			
			int bufferSize = (int) format.getSampleRate() * format.getFrameSize();
			byte[] buffer = new byte[bufferSize];
			int count = 0 ; 
			while (count != -1) {
				count = input.read(buffer, 0, buffer.length);
				sourceLine.write(buffer, 0, count);
				System.out.println(count);
			}
			System.out.println(count);
			if (count < 0) {
				System.out.println("Resrarted ...");
				input = AudioSystem.getAudioInputStream(pcm, input);
				
				format = input.getFormat();
				dataInfo = new DataLine.Info(SourceDataLine.class, format);
				sourceLine = (SourceDataLine)AudioSystem.getLine(dataInfo);
				sourceLine.open(format);
				sourceLine.start();
				while (count != -1) {
					count = input.read(buffer, 0, buffer.length);
					sourceLine.write(buffer, 0, count);
				}
			}
			
			sourceLine.drain();
			sourceLine.stop();
			sourceLine.close();
			
			Thread read = new Thread() {
				@Override
				public void run() {
					
				}
			};
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
