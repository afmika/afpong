package pong_af_michael;

import javafx.scene.media.AudioClip;

public class Song {
	/*Joueur audio*/
	private static String[] string = {"ping.wav","pong.wav", "wall.wav"};
	public static void play(int order){
		AudioClip tmp = new AudioClip(Principal.class.getResource(string[order]).toString());
		tmp.play();
	}
}
