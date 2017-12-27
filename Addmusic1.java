package test;

import java.applet.Applet;
import java.applet.AudioClip;

public class Addmusic1 extends Thread implements Runnable {
public Addmusic1 () {
	
}
public void run() {
	AudioClip clip;
	clip=Applet.newAudioClip(Addmusic1.class.getResource("firesound.wav"));
	clip.play();
}
}
