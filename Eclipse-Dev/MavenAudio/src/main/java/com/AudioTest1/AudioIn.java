package com.AudioTest1;

import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;

import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.net.MalformedURLException;
import java.net.URL;

import static javax.sound.sampled.AudioSystem.getAudioInputStream;
import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;

public class AudioIn implements Runnable {
	
	private AudioFormat outFormat;
	private AudioInputStream in;
	private URL url;

	@Override
	public void run() {
		try {
			
			url = new URL("http://stream.metacast.eu/nrj.ogg");
			in = getAudioInputStream(url);
			
			outFormat = getOutFormat(in.getFormat());
			Info info = new Info(SourceDataLine.class, outFormat);
			
			try (SourceD) {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void stream(AudioInputStream in, SourceDataLine line) 
            throws IOException, UnsupportedAudioFileException, LineUnavailableException {
			final byte[] buffer = new byte[65536];
            for (int n = 0; n != -1; n = in.read(buffer, 0, buffer.length)) {
                line.write(buffer, 0, n);
            }
        }

    private AudioFormat getOutFormat(AudioFormat inFormat) {
        final int ch = inFormat.getChannels();
        final float rate = inFormat.getSampleRate();
        return new AudioFormat(PCM_SIGNED, rate, 16, ch, ch * 2, rate, false);
    }
}
