package pong_af_michael;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class Enemy extends Rectangle{
	public static double x = 659;
	public static double y = 0;
	public static double velocity = 4; //Fera Office de niveau
	public static double critical = 500; //Fera office de de niveau
	public Enemy(Ball b){
		relocate(x, y);
		setWidth(30);
		setHeight(100);
		setFill(Color.WHITE);
		AnimationTimer t = new AnimationTimer(){
			public void handle(long arg0) {
				/*
				 * On vérifie si la balle a franchi la ligne critique pour que 
				 * L'intelligence artificielle anticipe la balle
				 */
				if(b.y < y+50 && b.x > critical){
					y-= (velocity);
				}
				if(b.y > y+50 && b.x > critical){
					y+= (velocity);
				}
				relocate(x,y);
			}
		};
		t.start();
		if(Math.abs(b.y - (y+50))<0.5){
			//Acceptable pour |dy| -> 0
			t.stop();
		}	
	}
}
