package com.AudioTest1;

import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;
import static javax.sound.sampled.AudioSystem.getAudioInputStream;

import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;

public class Consumer implements Runnable {
	
	private Buffer sharedLocation; // reference to shared Object
	private AudioInputStream in;
	private AudioFormat outFormat;
	
	Consumer(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}

	@Override
	public void run() {
		try {
			in = sharedLocation.blockingGet();
			
			outFormat = getOutFormat(in.getFormat());
			Info info = new Info(SourceDataLine.class, outFormat);
			
			try (SourceDataLine sourceDataLine = 
					(SourceDataLine) AudioSystem.getLine(info)) {
				
				if (sourceDataLine != null) {
					sourceDataLine.open(outFormat);
					sourceDataLine.start();
					stream(getAudioInputStream(outFormat, in), sourceDataLine);
				}
				
			} 
		} catch (UnsupportedAudioFileException | 
				LineUnavailableException | 
				IOException | 
				InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
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
