package test;

import java.applet.Applet;
import java.applet.AudioClip;

public class Addmusic extends Thread implements Runnable {
public Addmusic () {
	
}
public void run() {
	AudioClip clip;
	clip=Applet.newAudioClip(Addmusic.class.getResource("crush.wav"));
	clip.play();
}
}
