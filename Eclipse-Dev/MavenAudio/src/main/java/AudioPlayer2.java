import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.DataLine.Info;
import javax.swing.plaf.synth.SynthScrollBarUI;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineEvent.Type;
 
import static javax.sound.sampled.AudioSystem.getAudioInputStream;
import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;
 
public class AudioPlayer2 {
	
	private static URL url;
	private AudioInputStream in;
	private AudioFormat outFormat;
	private Info info;
	private SourceDataLine line;
 
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
 
    	
        try {
        		in = getAudioInputStream(url);
            outFormat = getOutFormat(in.getFormat());
            info = new Info(SourceDataLine.class, outFormat);
 
            try {
            		line = (SourceDataLine) AudioSystem.getLine(info);
                System.out.println("Format SampleRate: " + outFormat.getSampleRate());
                System.out.println("Format frame size: " + outFormat.getFrameSize());
                System.out.println("available: " + in.available());
                System.out.println("source line buffer size: " + line.getBufferSize());
            	

                    line.open(outFormat);
                    System.out.println("line opened");
                    line.start();
                    System.out.println("line started");
                    stream(getAudioInputStream(outFormat, in), line);
                    System.out.println("is active: " + line.isActive());
                    System.out.println("is open: " + line.isOpen());
                    System.out.println("is mark supported" +  in.markSupported());
                    
                    line.addLineListener(
                    		new LineListener() {
								
								@Override
								public void update(LineEvent event) {
									if (event.getType() == Type.STOP) {
										try {
											System.out.println("Event detected");
											line = (SourceDataLine) AudioSystem.getLine(info);
											line.open(outFormat);
											line.start();
											stream(getAudioInputStream(outFormat, in), line);
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (UnsupportedAudioFileException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (LineUnavailableException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
								}
							}
                    		);
            } finally {
            	
            }
        } catch (UnsupportedAudioFileException 
               | LineUnavailableException 
               | IOException e) {
        		e.printStackTrace();
        }

    }
 
    private AudioFormat getOutFormat(AudioFormat inFormat) {
        final int ch = inFormat.getChannels();
        final float rate = inFormat.getSampleRate();
        return new AudioFormat(PCM_SIGNED, rate, 16, ch, ch * 2, rate, false);
    }
 
    private void stream(AudioInputStream in, SourceDataLine line) 
            throws IOException, UnsupportedAudioFileException {
            final byte[] buffer = new byte[line.getBufferSize()];
            for (int n = 0; n != -1; n = in.read(buffer, 0, buffer.length)) {
            		in.mark(n);
                line.write(buffer, 0, n);
//                System.out.println(n);
                if (n <= -1) {
                		System.out.println("n <= -1: " + n);
                		in.reset();
                		continue;
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