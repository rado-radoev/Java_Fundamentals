import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
 
import static javax.sound.sampled.AudioSystem.getAudioInputStream;
import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;
 
public class AudioPlayer2 {
	
	private static URL url;
 
    public static void main(String[] args) {
        final AudioPlayer2 player = new AudioPlayer2 ();
        //player.play("something.mp3");
        try {
        	 	url = new URL("http://stream.metacast.eu/nrj.ogg");
			player.play(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    public void play(URL url) {
 
    	
        try (final AudioInputStream in = getAudioInputStream(url)) {
             
            final AudioFormat outFormat = getOutFormat(in.getFormat());
            final Info info = new Info(SourceDataLine.class, outFormat);
 
            try (final SourceDataLine line =
                     (SourceDataLine) AudioSystem.getLine(info)) {
            	
                System.out.println("Frame length: " + in.getFrameLength());
                System.out.println("available: " + in.available());
            	
                if (line != null) {
                    line.open(outFormat);
                    System.out.println("line opened");
                    line.start();
                    System.out.println("line started");
                    stream(getAudioInputStream(outFormat, in), line);
                    System.out.println("streaming");
                    //line.drain();
                    //line.stop();
                }
            }
 
        } catch (UnsupportedAudioFileException 
               | LineUnavailableException 
               | IOException e) {
            throw new IllegalStateException(e);
        }
    }
 
    private AudioFormat getOutFormat(AudioFormat inFormat) {
        final int ch = inFormat.getChannels();
        final float rate = inFormat.getSampleRate();
        return new AudioFormat(PCM_SIGNED, rate, 16, ch, ch * 2, rate, false);
    }
 
    private void stream(AudioInputStream in, SourceDataLine line) 
            throws IOException, UnsupportedAudioFileException {
            final byte[] buffer = new byte[65536];
            for (int n = 0; n != -1; n = in.read(buffer, 0, buffer.length)) {
                line.write(buffer, 0, n);
                System.out.println(n);
                if (n <= -1) {
                		in = getAudioInputStream(url);
                		System.out.println("stream reset");
                		n = 0;
                }
//                System.out.println("n: " + n);
//                System.out.println("BufferSize:" + line.getBufferSize());
//                System.out.println("FramePosition:" + line.getFramePosition());
//                System.out.println("MicrosecondPosition:" + line.getMicrosecondPosition());
//                System.out.println("isOpen:" + line.isOpen());
//                System.out.println("isActive:" + line.isActive());
//                System.out.println("isRunning:" + line.isRunning());
//                System.out.println("BytesAvailable:" + line.available());
//                System.out.println("Frame length: " + in.getFrameLength());
//                System.out.println("available: " + in.available());
            }
        }
}