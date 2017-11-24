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
	
	public class AudioPlayer {
	
		private static URL url;
	
		public static void main(String[] args) {
			final AudioPlayer player = new AudioPlayer();
			// player.play("something.mp3");
			try {
				url = new URL("http://stream.metacast.eu/nrj.ogg");
				player.play(url);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	
		public void play(URL url) {
	
			try {
	
				final AudioInputStream in = getAudioInputStream(url);
	
				final AudioFormat outFormat = getOutFormat(in.getFormat());
	
				final DataLine.Info sourceInfo = new DataLine.Info(SourceDataLine.class, outFormat);
				final SourceDataLine sourceLine = (SourceDataLine) AudioSystem.getLine(sourceInfo);
				sourceLine.open();
	
				Thread sourceThread = new Thread() {
					@Override
					public void run() {
						sourceLine.start();
						byte[] data = new byte[65536];
						int readBytes;
						while (true) {
							try {
								readBytes = in.read(data, 0, data.length);
								sourceLine.write(data, 0, readBytes);
							} catch (IOException e) {
								e.printStackTrace();
							}
	
						}
					}
				};
	
				System.out.println("Start playing ...");
				sourceThread.start();
				Thread.sleep(20000);
				sourceLine.stop();
				sourceLine.close();
	
			} catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException e) {
				throw new IllegalStateException(e);
			}
		}
	
		private AudioFormat getOutFormat(AudioFormat inFormat) {
			final int ch = inFormat.getChannels();
			final float rate = inFormat.getSampleRate();
			return new AudioFormat(PCM_SIGNED, rate, 16, ch, ch * 2, rate, false);
		}
	
	}