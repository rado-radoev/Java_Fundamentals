package com.AudioTest1;

import javax.sound.sampled.AudioInputStream;

public interface Buffer {
	
	// generate new Audio Input Stream
	public void blockinPut(AudioInputStream input) throws InterruptedException;

	// obtain Audio Input Stream
	public AudioInputStream blockingGet() throws InterruptedException;
}
