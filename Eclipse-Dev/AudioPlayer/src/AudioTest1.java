import java.net.URL;
import paulscode.sound.SoundSystemException;
import paulscode.sound.Library;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.libraries.LibraryJavaSound;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.codecs.CodecJOgg;

public class AudioTest1 {
	
	// variables checking which library is compatible
	//private static boolean aLCompatible = SoundSystem.libraryCompatible( LibraryLWJGLOpenAL.class	 );
	//private static boolean jSCompatible = SoundSystem.libraryCompatible( LibraryJavaSound.class );

	public static void main(String[] args) {
		// class variable initalized to the supported library
		Class libraryType;
		
		// check which library is supported, if none of the librarires are supporeted on the system
		// refere back to No sound, Silent Mode library
//		if (aLCompatible)
//			libraryType = LibraryLWJGLOpenAL.class; // OpenAL
//		else if (jSCompatible)
//			libraryType = LibraryJavaSound.class; // Java Sound
//		else	
//			libraryType = Library.class; // No sound, Silent Mode
//		
//		// add the library to the SoundSystem before anything else
		addLib(LibraryJavaSound.class);
		
		// create an empty SoundSystem object
		SoundSystem sound = new SoundSystem();
		
		//obtain info which library is currently used
		//Class currentLibrary = SoundSystem.currentLibrary();
		//String title = SoundSystemConfig.getLibraryTitle(currentLibrary);
		//String description = SoundSystemConfig.getLibraryDescription(currentLibrary);
		
		
		try {
			SoundSystemConfig.setCodec("ogg", CodecJOgg.class);
		} catch (Exception e) {
			System.err.printf( "error linking with the CodecJOgg.class plug-in%n"); 
		}
		
		sound.backgroundMusic("Music 1", "beats.ogg", true);
		
		sleep(10);
		
		sound.cleanup();
	}
	
	private static void addLib(Class class1) {
		try {
			SoundSystemConfig.addLibrary(class1);
		} catch (SoundSystemException e) {
			System.err.printf( "error linking with the %s plug-in%n", class1.getName().toString() ); 
		}
	}
	
	private static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
