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
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
 
import static javax.sound.sampled.AudioSystem.getAudioInputStream;
import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;
 
public class AudioPlayer5 {
	
	private static URL url;
	AudioFormat outFormat;
	AudioInputStream in;
	
    public static void main(String[] args) {
        final AudioPlayer player = new AudioPlayer ();
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
            Info info = new Info(SourceDataLine.class, outFormat);
 
            try (SourceDataLine line =
                     (SourceDataLine) AudioSystem.getLine(info)) {
            	
               // System.out.println("Frame length: " + in.getFrameLength());
               // System.out.println("available: " + in.available());
            	
                line.addLineListener(
                		new LineListener() {
							
							@Override
							public void update(LineEvent event) {
								if (event.getType() == LineEvent.Type.STOP) {
									System.out.println("LINE EVENT stopped");
								}
								
							}
						});
            	
                if (line != null) {
                    line.open(outFormat);
                    line.start();
                    System.out.println("line opened");
                    System.out.println("line buffer size: " + line.getBufferSize());
                    System.out.println("isActive:" + line.isActive());
                    System.out.println("isRunning:" + line.isRunning());
                    System.out.println("Available:" + line.available());
                    
                    System.out.println("line started");
                    stream(getAudioInputStream(outFormat, in), line);
                    System.out.println("stream stopped");
                    line.drain();
                    line.stop();
                    System.out.println("line stopped");
                    System.out.println("restarting ...");
                    
                    in = getAudioInputStream(url);
                    
                    line.open(outFormat);
                    line.start();
                    stream(getAudioInputStream(outFormat, in), line);
                    line.drain();
                    
                    System.out.println("restarting ...");
                    
                    in = getAudioInputStream(url);
                    
                    line.open(outFormat);
                    line.start();
                    stream(getAudioInputStream(outFormat, in), line);
                    line.drain();
                    
                    
                    System.out.println("restarting ...");
                    
                    in = getAudioInputStream(url);
                    
                    line.addLineListener(
                    		new LineListener() {
								
								@Override
								public void update(LineEvent event) {
									if (event.getType() == LineEvent.Type.STOP) {
										System.out.println("Line stopped");
									}
									
								}
							});
                    
                    line.open(outFormat);
                    line.start();
                    stream(getAudioInputStream(outFormat, in), line);
                    line.drain();
                    
                    
                    System.out.println("restarting ...");
                    
                    in = getAudioInputStream(url);
                    
                    line.open(outFormat);
                    line.start();
                    stream(getAudioInputStream(outFormat, in), line);
                    line.drain();
                    
                    
                    
                    System.out.println("restarting ...");
                    
                    in = getAudioInputStream(url);
                    
                    line.open(outFormat);
                    line.start();
                    stream(getAudioInputStream(outFormat, in), line);
                    line.drain();
                    
                    
                    System.out.println("restarting ...");
                    
                    in = getAudioInputStream(url);
                    
                    line.open(outFormat);
                    line.start();
                    stream(getAudioInputStream(outFormat, in), line);
                    line.drain();
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
            throws IOException, UnsupportedAudioFileException, LineUnavailableException {
            final byte[] buffer = new byte[65536];
            for (int n = 0; n != -1; n = in.read(buffer, 0, buffer.length)) {
                line.write(buffer, 0, n);
                //System.out.println(n);

//                System.out.println("n: " + n);
//                System.out.println("BufferSize:" + line.getBufferSize());
//                System.out.println("FramePosition:" + line.getFramePosition());
//                System.out.println("MicrosecondPosition:" + line.getMicrosecondPosition());
//                System.out.println("isOpen:" + line.isOpen());
//                System.out.println("isActive:" + line.isActive());
//                System.out.println("isRunning:" + line.isRunning());
//                System.out.println("Available:" + line.available());
//                System.out.println("BytesAvailable:" + line.available());
//                System.out.println("Frame length: " + in.getFrameLength());
//                System.out.println("available: " + in.available());
            }
        }
}