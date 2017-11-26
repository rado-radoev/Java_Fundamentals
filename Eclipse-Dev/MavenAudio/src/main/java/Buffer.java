import java.io.*;
import java.net.*;
import javax.sound.sampled.*;

public interface Buffer {

	// place bytes into Buffer
	public AudioInputStream blockingPut(SourceDataLine) throws InterruptedException;
	
	// read bytes from Buffer
	public void blockingGet(SourceDataLine sourceDataLine) throws InterruptedException;
}
