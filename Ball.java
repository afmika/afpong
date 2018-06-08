package pong_af_michael;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Ball extends Circle{
	public int x=300,y=350;
	public int derivationX = 4, derivationY = 4;
	public int dx = Principal.width;
	public int dy = Principal.height;
	public Player pl = Principal.joueur;
	public Enemy en = Principal.enemy;
	public Ball(){
		setFill(Color.WHITE);
		setCenterX(x);
		setCenterY(y);
		setRadius(16);
		new AnimationTimer(){
			public void handle(long arg0) {
				if(y+getRadius() >= dy || y-getRadius() <= 0){
					derivationY *= -1;
					Song.play(2);
				}
				if(x-getRadius() <= 30 && y >= pl.y && pl.y + 100 > y 
				   || x+getRadius() >= 656 && y >= en.y && en.y+100 > y){
					derivationX *=-1;
					Song.play(1);
				}
				if(x-getRadius() <= 0){
					x = 100;
					y = 100;
					derivationX = Math.abs(derivationX);
					derivationY = Math.abs(derivationY);
					Principal.score[1]++;
					Principal.score_txt.setText(""+Principal.score[0]+"\t"+Principal.score[1]);
					Song.play(0);
				}
				if(x+getRadius() >= 670){
					x = 500;
					y = 100 ;
					derivationX = -Math.abs(derivationX);
					derivationY = Math.abs(derivationY);
					Principal.score[0]++;
					Principal.score_txt.setText(""+Principal.score[0]+"\t"+Principal.score[1]);
					
					if(Principal.score[0]%3 == 0 && Principal.score[0] != 0){
						Principal.cte_level++;
						Principal.level.setText("Level "+Principal.cte_level);
						/*
						 * On rend l'IA plus intelligente
						 * */
						Enemy.velocity += 1;
						/*
						 * La ligne critique pour recalculer la collision de la balle devient plus éloignée
						 * */
						Enemy.critical-=5; 
					}
					Song.play(0);
				}

				setCenterX(x+=derivationX);
				setCenterY(y+=derivationY);
				}
		}.start();
	}
}
