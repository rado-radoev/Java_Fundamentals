package com.AudioTest1;

import javax.sound.sampled.AudioInputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class CirculaBuffer implements Buffer {

	private final Lock accessLock = new ReentrantLock();
	
	private final Condition canWrite = accessLock.newCondition();
	private final Condition canRead = accessLock.newCondition();
	
	private boolean occupied = false;
	
	@Override
	public void blockinPut(AudioInputStream input) throws InterruptedException {
		accessLock.lock();
		
		while (occupied) {
			System.out.println("Producer tries to write");
			System.out.println("Buffer is full");
			canWrite.await();
		}
		
		
		
	}

	@Override
	public AudioInputStream blockingGet() throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

}
