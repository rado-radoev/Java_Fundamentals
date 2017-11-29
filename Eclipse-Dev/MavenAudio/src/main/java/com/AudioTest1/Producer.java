package com.AudioTest1;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static javax.sound.sampled.AudioSystem.getAudioInputStream;

public class Producer implements Runnable {

	private URL url;
	private Buffer sharedLocation;  // reference to shared object
	private AudioInputStream in;
	
	// constructor
	public Producer(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
		
		try {
			url = new URL("http://stream.metacast.eu/nrj.ogg");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			in = getAudioInputStream(url);
			sharedLocation.blockinPut(in);
		} catch (UnsupportedAudioFileException | IOException | InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
	}
	
	
}
